package org.xima.penguinprojectkmp.presentation.penguinList

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.xima.penguinprojectkmp.domain.model.Penguin
import org.xima.penguinprojectkmp.presentation.util.DataState
import org.xima.penguinprojectkmp.presentation.util.ErrorScreen

@Composable
@Preview
fun PenguinList(
    uiState: DataState<PenguinListState>,
    modifier: Modifier = Modifier
) {
    when (uiState) {
        is DataState.Error -> {
            ErrorScreen(modifier = modifier.fillMaxSize())
        }

        DataState.Loading -> {
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()

            }
        }

        is DataState.Success -> {
            LazyColumn(
                modifier = modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(uiState.data.penguins) { penguin ->
                    PenguinItem(penguin = penguin, modifier = Modifier)
                }
            }

        }
    }
}

@Composable
@Preview
fun PenguinItem(
    penguin: Penguin,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(text = penguin.name)
        Text(text = penguin.description)
    }
}
