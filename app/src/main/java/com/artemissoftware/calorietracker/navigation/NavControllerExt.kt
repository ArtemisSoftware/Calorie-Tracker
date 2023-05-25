package com.artemissoftware.calorietracker.navigation

import androidx.navigation.NavController
import com.artemissoftware.core.util.UiEvent

fun NavController.navigate(event: UiEvent.Navigate) {
    this.navigate(event.route)
}
