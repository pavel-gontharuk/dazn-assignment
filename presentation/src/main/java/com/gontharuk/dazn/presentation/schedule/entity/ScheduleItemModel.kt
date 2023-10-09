package com.gontharuk.dazn.presentation.schedule.entity

import android.content.res.Resources
import android.net.Uri
import com.gontharuk.dazn.data.schedule.entity.ScheduleModel
import com.gontharuk.dazn.presentation.core.formatting.format

data class ScheduleItemModel(
    val title: String,
    val subtitle: String,
    val date: String,
    val imageUrl: Uri,
)

fun ScheduleModel.toItemModel(
    resources: Resources
): ScheduleItemModel = ScheduleItemModel(
    title = title,
    subtitle = subtitle,
    date = date.format(resources),
    imageUrl = imageUrl,
)