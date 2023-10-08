package com.gontharuk.dazn.data.events.entity

import android.net.Uri
import java.time.LocalDateTime

data class EventModel(
    val id: Int,
    val title: String,
    val subtitle: String,
    val date: LocalDateTime,
    val imageUrl: Uri,
    val videoUrl: Uri,
)