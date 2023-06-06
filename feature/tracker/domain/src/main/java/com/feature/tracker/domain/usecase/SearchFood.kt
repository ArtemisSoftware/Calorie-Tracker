package com.feature.tracker.domain.usecase

import com.feature.tracker.domain.model.TrackableFood
import com.feature.tracker.domain.repository.TrackerRepository

class SearchFood(
    private val repository: TrackerRepository,
) {

    suspend operator fun invoke(
        query: String,
        page: Int = 1,
        pageSize: Int = 40,
    ): Result<List<TrackableFood>> {
        if (query.isBlank()) {
            return Result.success(emptyList())
        }
        return repository.searchFood(query.trim(), page, pageSize)
    }
}
