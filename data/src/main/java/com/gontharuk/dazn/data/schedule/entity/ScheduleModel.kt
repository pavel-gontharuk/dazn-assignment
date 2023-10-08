package com.gontharuk.dazn.data.schedule.entity

import android.net.Uri
import java.time.LocalDateTime

data class ScheduleModel(
    val id: Int,
    val title: String,
    val subtitle: String,
    val date: LocalDateTime,
    val imageUrl: Uri,
)