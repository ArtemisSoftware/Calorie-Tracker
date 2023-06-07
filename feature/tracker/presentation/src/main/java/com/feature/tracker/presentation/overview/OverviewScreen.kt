package com.feature.tracker.presentation.overview

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.artemissoftware.core.util.UiEvent
import com.artemissoftware.core_ui.LocalSpacing
import com.feature.tracker.presentation.overview.components.NutrientsHeader

@Composable
fun OverviewScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: OverviewViewModel = hiltViewModel(),
) {
    val spacing = LocalSpacing.current
    val state = viewModel.state
    val context = LocalContext.current
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = spacing.spaceMedium),
    ) {
        item {
            NutrientsHeader(state = state)
        }
    }
}
