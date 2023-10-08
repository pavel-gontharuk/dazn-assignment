package com.gontharuk.dazn.presentation.schedule.entity

import android.net.Uri

data class ScheduleItemModel(
    val title: String,
    val subtitle: String,
    val date: String,
    val imageUrl: Uri,
)
