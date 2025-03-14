package org.xima.penguinprojectkmp.presentation.penguinList

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.xima.penguinprojectkmp.domain.model.Penguin
import org.xima.penguinprojectkmp.domain.repository.PenguinRepository

class PenguinListViewModel(
    private val penguinRepository: PenguinRepository
) : ViewModel() {
    var state by mutableStateOf<List<Penguin>>(emptyList())
        private set

    init {
        viewModelScope.launch {
            state = penguinRepository.getAllPenguins()
        }
    }
}