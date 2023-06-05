package com.artemissoftware.calorietracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.artemissoftware.calorietracker.navigation.navigate
import com.artemissoftware.calorietracker.ui.theme.CalorieTrackerTheme
import com.artemissoftware.core.navigation.Route
import com.feature.onboarding.presentation.age.AgeScreen
import com.feature.onboarding.presentation.gender.GenderScreen
import com.feature.onboarding.presentation.height.HeightScreen
import com.feature.onboarding.presentation.weight.WeightScreen
import com.feature.onboarding.presentation.welcome.WelcomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalorieTrackerTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Route.WELCOME,
                ) {
                    composable(Route.WELCOME) {
                        WelcomeScreen(onNavigate = navController::navigate)
                    }
                    composable(Route.AGE) {
                        AgeScreen(onNavigate = navController::navigate)
                    }
                    composable(Route.GENDER) {
                        GenderScreen(onNavigate = navController::navigate)
                    }
                    composable(Route.HEIGHT) {
                        HeightScreen(onNavigate = navController::navigate)
                    }
                    composable(Route.WEIGHT) {
                        WeightScreen(onNavigate = navController::navigate)
                    }
                    composable(Route.NUTRIENT_GOAL) {
                    }
                    composable(Route.ACTIVITY) {
                    }
                    composable(Route.GOAL) {
                    }

                    composable(Route.TRACKER_OVERVIEW) {
                    }
                    composable(Route.SEARCH) {
                    }
                }
            }
        }
    }
}
