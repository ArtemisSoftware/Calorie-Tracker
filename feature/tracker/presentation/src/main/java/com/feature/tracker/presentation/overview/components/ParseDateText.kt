package com.feature.tracker.presentation.overview.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import core.R as CoreR

@Composable
fun parseDateText(date: LocalDate): String {
    val today = LocalDate.now()
    return when(date) {
        today -> stringResource(id = CoreR.string.today)
        today.minusDays(1) -> stringResource(id = CoreR.string.yesterday)
        today.plusDays(1) -> stringResource(id = CoreR.string.tomorrow)
        else -> DateTimeFormatter.ofPattern("dd LLLL").format(date)
    }
}