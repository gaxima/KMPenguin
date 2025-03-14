package org.xima.penguinprojectkmp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel
import org.xima.penguinprojectkmp.domain.model.Penguin
import org.xima.penguinprojectkmp.presentation.penguinList.PenguinListViewModel


@Composable
@Preview
fun App() {
    MaterialTheme {
        val viewModel = koinViewModel<PenguinListViewModel>()
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            PenguinList(penguins = viewModel.state)
        }
    }
}

@Composable
@Preview
fun PenguinList(
    penguins: List<Penguin>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(penguins) { penguin ->
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
        Spacer(Modifier.height(16.dp))
        Text(text = penguin.description)
    }
}