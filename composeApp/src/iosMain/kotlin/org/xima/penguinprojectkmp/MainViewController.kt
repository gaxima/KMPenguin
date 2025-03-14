package org.xima.penguinprojectkmp

import androidx.compose.ui.window.ComposeUIViewController
import org.xima.penguinprojectkmp.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    App()
}