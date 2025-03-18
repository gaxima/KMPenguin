package org.xima.penguinprojectkmp.presentation.penguinList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.xima.penguinprojectkmp.domain.repository.PenguinRepository
import org.xima.penguinprojectkmp.presentation.util.DataState

class PenguinListViewModel(
    private val penguinRepository: PenguinRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<DataState<PenguinListState>>(DataState.Loading)

    val uiState = _uiState.asStateFlow()

    init {
        loadPenguins()
    }

    private fun loadPenguins() {
        viewModelScope.launch {
            try {
                _uiState.value = DataState.Loading
                val penguins = penguinRepository.getAllPenguins()
                _uiState.value = DataState.Success(PenguinListState(penguins = penguins))
            } catch (e: Exception) {
                _uiState.value = DataState.Error("Failed to load penguins: ${e.message}")
            }
        }
    }
}