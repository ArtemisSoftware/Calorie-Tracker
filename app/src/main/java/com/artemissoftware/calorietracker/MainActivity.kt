package com.artemissoftware.calorietracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.artemissoftware.calorietracker.navigation.navigate
import com.artemissoftware.calorietracker.ui.theme.CalorieTrackerTheme
import com.artemissoftware.core.domain.preferences.Preferences
import com.artemissoftware.core.navigation.Route
import com.feature.onboarding.presentation.activity.ActivityScreen
import com.feature.onboarding.presentation.age.AgeScreen
import com.feature.onboarding.presentation.gender.GenderScreen
import com.feature.onboarding.presentation.goal.GoalScreen
import com.feature.onboarding.presentation.height.HeightScreen
import com.feature.onboarding.presentation.nutrientgoal.NutrientGoalScreen
import com.feature.onboarding.presentation.weight.WeightScreen
import com.feature.onboarding.presentation.welcome.WelcomeScreen
import com.feature.tracker.presentation.overview.OverviewScreen
import com.feature.tracker.presentation.search.SearchScreen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var preferences: Preferences

    @OptIn(ExperimentalComposeUiApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val shouldShowOnboarding = preferences.loadShouldShowOnboarding()

        setContent {
            CalorieTrackerTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = if (shouldShowOnboarding) {
                        Route.WELCOME
                    } else {
                        Route.TRACKER_OVERVIEW
                    },
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
                        NutrientGoalScreen(onNavigate = navController::navigate)
                    }
                    composable(Route.ACTIVITY) {
                        ActivityScreen(onNavigate = navController::navigate)
                    }
                    composable(Route.GOAL) {
                        GoalScreen(onNavigate = navController::navigate)
                    }

                    composable(Route.TRACKER_OVERVIEW) {
                        OverviewScreen(
                            onNavigateToSearch = { mealName, day, month, year ->
                                navController.navigate(
                                    Route.SEARCH + "/$mealName" +
                                        "/$day" +
                                        "/$month" +
                                        "/$year",
                                )
                            },
                        )
                    }
                    composable(
                        route = Route.SEARCH + "/{mealName}/{dayOfMonth}/{month}/{year}",
                        arguments = listOf(
                            navArgument("mealName") {
                                type = NavType.StringType
                            },
                            navArgument("dayOfMonth") {
                                type = NavType.IntType
                            },
                            navArgument("month") {
                                type = NavType.IntType
                            },
                            navArgument("year") {
                                type = NavType.IntType
                            },
                        ),
                    ) {
                        val mealName = it.arguments?.getString("mealName")!!
                        val dayOfMonth = it.arguments?.getInt("dayOfMonth")!!
                        val month = it.arguments?.getInt("month")!!
                        val year = it.arguments?.getInt("year")!!
                        SearchScreen(
                            mealName = mealName,
                            dayOfMonth = dayOfMonth,
                            month = month,
                            year = year,
                            onNavigateUp = {
                                //navController.navigateUp()
                                           navController.popBackStack()
                            },
                        )
                    }
                }
            }
        }
    }
}
