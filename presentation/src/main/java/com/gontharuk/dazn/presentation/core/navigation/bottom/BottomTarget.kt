package com.gontharuk.dazn.presentation.core.navigation.bottom

import androidx.annotation.StringRes
import com.gontharuk.dazn.presentation.R

sealed class BottomTarget(
    val route: String,
    @StringRes val labelId: Int,
) {

    data object Events : BottomTarget("events", R.string.events)

    data object Schedule : BottomTarget("schedule", R.string.schedule)
}
