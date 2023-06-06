package com.feature.tracker.presentation.overview

import com.feature.tracker.domain.model.TrackedFood

sealed class OverviewEvent {
    object OnNextDayClick : OverviewEvent()
    object OnPreviousDayClick : OverviewEvent()
    data class OnToggleMealClick(val meal: Meal) : OverviewEvent()
    data class OnDeleteTrackedFoodClick(val trackedFood: TrackedFood) : OverviewEvent()
    data class OnAddFoodClick(val meal: Meal) : OverviewEvent()
}
