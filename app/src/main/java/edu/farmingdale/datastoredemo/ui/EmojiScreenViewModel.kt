package edu.farmingdale.datastoredemo.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import edu.farmingdale.datastoredemo.R
import edu.farmingdale.datastoredemo.EmojiReleaseApplication
import edu.farmingdale.datastoredemo.data.local.UserPreferencesRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.combine


class EmojiScreenViewModel(
    private val userPreferencesRepository: UserPreferencesRepository
) : ViewModel() {

    // Puts layout choice and theme choice together in one box
   // So the app knows both things at once
    val uiState: StateFlow<EmojiReleaseUiState> =
        userPreferencesRepository.isLinearLayout
            .combine(userPreferencesRepository.isDarkTheme) { isLinear, isDark ->
                // Create UI state with both preferences
                EmojiReleaseUiState(isLinearLayout = isLinear, isDarkTheme = isDark)
            }
            .stateIn(
                scope = viewModelScope,
                // Flow is set to emit values when app is in the foreground
                // 5 second stop delay ensures it flows continuously
                // for cases such as configuration changes
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = EmojiReleaseUiState()
            )

    /*
  * [selectLayout] change the layout and icons accordingly and
  * save the selection in DataStore through [userPreferencesRepository]
  */
    fun selectLayout(isLinearLayout: Boolean) {
        viewModelScope.launch {
            userPreferencesRepository.saveLayoutPreference(isLinearLayout)
        }
    }



    // Toggles light and dark theme and saves to the data store
    fun lDSwitch(isDarkTheme: Boolean) {
        viewModelScope.launch {
            userPreferencesRepository.saveThemePreference(isDarkTheme)
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as EmojiReleaseApplication)
                EmojiScreenViewModel(application.userPreferencesRepository)
            }
        }
    }
}

/*
 * Data class that holds all UI state for the Emoji screens
 */
data class EmojiReleaseUiState(
    val isLinearLayout: Boolean = true,
    // sets true to dark mode and false to light mode
    val isDarkTheme: Boolean = false,
    val toggleContentDescription: Int =
        if (isLinearLayout) R.string.grid_layout_toggle else R.string.linear_layout_toggle,
    val toggleIcon: Int =
        if (isLinearLayout) R.drawable.ic_grid_layout else R.drawable.ic_linear_layout
)