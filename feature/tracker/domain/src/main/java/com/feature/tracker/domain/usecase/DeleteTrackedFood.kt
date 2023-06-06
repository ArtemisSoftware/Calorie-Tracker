package com.feature.tracker.domain.usecase

import com.feature.tracker.domain.model.TrackedFood
import com.feature.tracker.domain.repository.TrackerRepository

class DeleteTrackedFood(
    private val repository: TrackerRepository,
) {

    suspend operator fun invoke(trackedFood: TrackedFood) {
        repository.deleteTrackedFood(trackedFood)
    }
}
