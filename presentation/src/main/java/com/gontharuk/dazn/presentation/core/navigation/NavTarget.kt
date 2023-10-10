package com.gontharuk.dazn.presentation.core.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.gontharuk.dazn.presentation.R

sealed class NavTarget(
    val route: String,
    @StringRes val labelRes: Int,
    @DrawableRes val iconRes: Int
) {

    data object Events : NavTarget(
        route = "events",
        labelRes = R.string.events,
        iconRes = R.drawable.events
    )

    data object Schedule : NavTarget(
        route = "schedule",
        labelRes = R.string.schedule,
        iconRes = R.drawable.schedule
    )

    data object Video : NavTarget(
        route = "video/",
        labelRes = R.string.video,
        iconRes = R.drawable.video
    ) {
        const val videoArg: String = "videoArg"
    }
}