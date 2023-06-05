package com.feature.onboarding.presentation.activity


import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import com.artemissoftware.core.domain.models.ActivityLevel
import com.artemissoftware.core.util.UiEvent
import com.artemissoftware.core_ui.LocalSpacing
import com.feature.onboarding.presentation.composables.ActionButton
import com.feature.onboarding.presentation.composables.SelectableButton
import kotlinx.coroutines.flow.collect
import core.R as CoreR

@Composable
fun ActivityScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: ActivityViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.Navigate -> onNavigate(event)
                else -> Unit
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.spaceLarge)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = CoreR.string.whats_your_activity_level),
                style = MaterialTheme.typography.displayMedium /*h3*/
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            Row {
                SelectableButton(
                    text = stringResource(id = CoreR.string.low),
                    isSelected = viewModel.selectedActivityLevel is ActivityLevel.Low,
                    color = MaterialTheme.colorScheme.primary /*primaryVariant*/,
                    selectedTextColor = Color.White,
                    onClick = {
                        viewModel.onActivityLevelSelect(ActivityLevel.Low)
                    },
                    textStyle = MaterialTheme.typography.button.copy(
                        fontWeight = FontWeight.Normal
                    )
                )
                Spacer(modifier = Modifier.width(spacing.spaceMedium))
                SelectableButton(
                    text = stringResource(id = CoreR.string.medium),
                    isSelected = viewModel.selectedActivityLevel is ActivityLevel.Medium,
                    color = MaterialTheme.colorScheme.primary /*primaryVariant*/,
                    selectedTextColor = Color.White,
                    onClick = {
                        viewModel.onActivityLevelSelect(ActivityLevel.Medium)
                    },
                    textStyle = MaterialTheme.typography.button.copy(
                        fontWeight = FontWeight.Normal
                    )
                )
                Spacer(modifier = Modifier.width(spacing.spaceMedium))
                SelectableButton(
                    text = stringResource(id = CoreR.string.high),
                    isSelected = viewModel.selectedActivityLevel is ActivityLevel.High,
                    color = MaterialTheme.colorScheme.primary /*primaryVariant*/,
                    selectedTextColor = Color.White,
                    onClick = {
                        viewModel.onActivityLevelSelect(ActivityLevel.High)
                    },
                    textStyle = MaterialTheme.typography.bodySmall /*button*/.copy(
                        fontWeight = FontWeight.Normal
                    )
                )
            }
        }
        ActionButton(
            text = stringResource(id = CoreR.string.next),
            onClick = viewModel::onNextClick,
            modifier = Modifier.align(Alignment.BottomEnd)
        )
    }
}
