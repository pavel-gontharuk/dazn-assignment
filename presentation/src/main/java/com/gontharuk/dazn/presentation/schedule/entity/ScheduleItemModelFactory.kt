package com.gontharuk.dazn.presentation.schedule.entity

import com.gontharuk.dazn.data.schedule.entity.ScheduleModel

class ScheduleItemModelFactory {

    fun create(input: ScheduleModel): ScheduleItemModel = ScheduleItemModel(
        title = input.title,
        subtitle = input.subtitle,
        date = input.date.toString(),
        imageUrl = input.imageUrl,
    )
}