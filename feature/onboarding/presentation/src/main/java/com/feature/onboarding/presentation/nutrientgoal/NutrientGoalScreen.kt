package com.feature.onboarding.presentation.nutrientgoal

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.artemissoftware.core.util.UiEvent
import com.artemissoftware.core_ui.LocalSpacing
import com.feature.onboarding.presentation.composables.ActionButton
import com.feature.onboarding.presentation.composables.UnitTextField
import kotlinx.coroutines.flow.collect
import core.R as CoreR

@Composable
fun NutrientGoalScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: NutrientGoalViewModel = hiltViewModel(),
) {
    val spacing = LocalSpacing.current
    val context = LocalContext.current
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.Navigate -> onNavigate(event)
                is UiEvent.ShowSnackbar -> {
                    snackbarHostState.showSnackbar(
                        message = event.message.asString(context),
                    )
                }
                else -> Unit
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.spaceLarge),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = stringResource(id = CoreR.string.what_are_your_nutrient_goals),
                style = MaterialTheme.typography.displayMedium, /*h3*/
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            UnitTextField(
                value = viewModel.state.carbsRatio,
                onValueChange = {
                    viewModel.onEvent(NutrientGoalEvent.OnCarbRatioEnter(it))
                },
                unit = stringResource(id = CoreR.string.percent_carbs),
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            UnitTextField(
                value = viewModel.state.proteinRatio,
                onValueChange = {
                    viewModel.onEvent(NutrientGoalEvent.OnProteinRatioEnter(it))
                },
                unit = stringResource(id = CoreR.string.percent_proteins),
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            UnitTextField(
                value = viewModel.state.fatRatio,
                onValueChange = {
                    viewModel.onEvent(NutrientGoalEvent.OnFatRatioEnter(it))
                },
                unit = stringResource(id = CoreR.string.percent_fats),
            )
        }
        ActionButton(
            text = stringResource(id = CoreR.string.next),
            onClick = {
                viewModel.onEvent(NutrientGoalEvent.OnNextClick)
            },
            modifier = Modifier.align(Alignment.BottomEnd),
        )
    }
}
