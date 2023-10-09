package com.gontharuk.dazn.presentation.events.enity

import android.content.res.Resources
import android.net.Uri
import com.gontharuk.dazn.data.events.entity.EventModel
import com.gontharuk.dazn.presentation.core.formatting.format

data class EventItemModel(
    val title: String,
    val subtitle: String,
    val date: String,
    val imageUrl: Uri,
    val videoUrl: Uri,
)

fun EventModel.toItemModel(
    resources: Resources
): EventItemModel = EventItemModel(
    title = title,
    subtitle = subtitle,
    date = date.format(resources),
    imageUrl = imageUrl,
    videoUrl = videoUrl,
)