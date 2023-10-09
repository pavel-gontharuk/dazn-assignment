package com.gontharuk.dazn.presentation.schedule.entity

import android.content.res.Resources
import com.gontharuk.dazn.data.schedule.entity.ScheduleModel
import com.gontharuk.dazn.presentation.core.formatting.format

class ScheduleItemModelFactory(
    private val resources: Resources
) {

    fun create(input: ScheduleModel): ScheduleItemModel = ScheduleItemModel(
        title = input.title,
        subtitle = input.subtitle,
        date = input.date.format(resources),//todo move format to ui
        imageUrl = input.imageUrl,
    )
}