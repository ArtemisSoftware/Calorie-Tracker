package com.feature.tracker.presentation.search

import com.feature.tracker.domain.model.TrackableFood

data class TrackableFoodUiState(
    val food: TrackableFood,
    val isExpanded: Boolean = false,
    val amount: String = "",
)
