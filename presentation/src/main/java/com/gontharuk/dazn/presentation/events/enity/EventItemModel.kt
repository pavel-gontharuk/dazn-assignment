package com.gontharuk.dazn.presentation.events.enity

import android.net.Uri

data class EventItemModel(
    val title: String,
    val subtitle: String,
    val date: String,
    val imageUrl: Uri,
    val videoUrl: Uri,
)
