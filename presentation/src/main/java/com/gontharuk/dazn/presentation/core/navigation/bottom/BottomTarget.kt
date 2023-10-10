package com.gontharuk.dazn.presentation.core.navigation.bottom

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.gontharuk.dazn.presentation.R

sealed class BottomTarget(
    val route: String,
    @StringRes val labelRes: Int,
    @DrawableRes val iconRes: Int
) {

    data object Events : BottomTarget(
        route = "events",
        labelRes = R.string.events,
        iconRes = R.drawable.events
    )

    data object Schedule : BottomTarget(
        route = "schedule",
        labelRes = R.string.schedule,
        iconRes = R.drawable.schedule
    )
}