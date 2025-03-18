package org.xima.penguinprojectkmp.presentation.util

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import penguinkmp.composeapp.generated.resources.Res
import penguinkmp.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun ErrorScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(Res.drawable.compose_multiplatform),
            contentDescription = null
        )
        Spacer(Modifier.height(16.dp))
        Text(text = "something went wrong, sorry!")
    }
}