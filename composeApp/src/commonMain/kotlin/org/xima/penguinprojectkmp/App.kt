package org.xima.penguinprojectkmp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel
import org.xima.penguinprojectkmp.presentation.penguinList.PenguinList
import org.xima.penguinprojectkmp.presentation.penguinList.PenguinListViewModel


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
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    PenguinList(uiState = uiState, modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}

