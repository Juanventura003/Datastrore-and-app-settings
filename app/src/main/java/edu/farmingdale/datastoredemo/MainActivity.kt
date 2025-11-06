package edu.farmingdale.datastoredemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import edu.farmingdale.datastoredemo.ui.EmojiReleaseApp
import edu.farmingdale.datastoredemo.ui.EmojiScreenViewModel
import edu.farmingdale.datastoredemo.ui.theme.DataStoreDemoTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val emojiViewModel: EmojiScreenViewModel = viewModel(
                factory = EmojiScreenViewModel.Factory
            )
            val isDarkTheme = emojiViewModel.uiState.collectAsState().value.isDarkTheme
            DataStoreDemoTheme(darkTheme = isDarkTheme) {
                EmojiReleaseApp()
            }
        }
    }
}