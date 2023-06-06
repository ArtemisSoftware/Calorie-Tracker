package com.feature.tracker.domain.di

import com.artemissoftware.core.domain.preferences.Preferences
import com.feature.tracker.domain.repository.TrackerRepository
import com.feature.tracker.domain.usecase.CalculateMealNutrients
import com.feature.tracker.domain.usecase.DeleteTrackedFood
import com.feature.tracker.domain.usecase.GetFoodsForDate
import com.feature.tracker.domain.usecase.SearchFood
import com.feature.tracker.domain.usecase.TrackFood
import com.feature.tracker.domain.usecase.TrackerUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object TrackerDomainModule {

    @ViewModelScoped
    @Provides
    fun provideTrackerUseCases(
        repository: TrackerRepository,
        preferences: Preferences,
    ): TrackerUseCases {
        return TrackerUseCases(
            trackFood = TrackFood(repository),
            searchFood = SearchFood(repository),
            getFoodsForDate = GetFoodsForDate(repository),
            deleteTrackedFood = DeleteTrackedFood(repository),
            calculateMealNutrients = CalculateMealNutrients(preferences),
        )
    }
}
