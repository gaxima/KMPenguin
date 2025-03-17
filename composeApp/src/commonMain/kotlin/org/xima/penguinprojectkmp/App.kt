package org.xima.penguinprojectkmp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel
import org.xima.penguinprojectkmp.domain.model.Penguin
import org.xima.penguinprojectkmp.presentation.penguinList.PenguinListState
import org.xima.penguinprojectkmp.presentation.penguinList.PenguinListViewModel
import org.xima.penguinprojectkmp.presentation.util.DataState


@Composable
@Preview
fun App() {
    MaterialTheme {
        val viewModel = koinViewModel<PenguinListViewModel>()
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                topBar = {
                    TopAppBar(content = {
                        Text("Penguin KMP project")
                    }
                    )
                }
            ) { paddingValues ->
                Box(
                    modifier = Modifier.fillMaxSize().padding(paddingValues),
                ) {
                    when (val currentState = uiState) {

                        is DataState.Error -> {

                        }

                        is DataState.Loading -> {
                            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                        }

                        is DataState.Success -> {
                            PenguinList(penguins = currentState.data)
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun PenguinList(
    penguins: PenguinListState,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(penguins.penguins) { penguin ->
            PenguinItem(penguin = penguin, modifier = Modifier)
        }
    }
}

@Composable
@Preview
fun PenguinItem(
    penguin: Penguin,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth().padding(horizontal = 16.dp)) {
        Text(text = penguin.name)
        Text(text = penguin.description)
    }
}