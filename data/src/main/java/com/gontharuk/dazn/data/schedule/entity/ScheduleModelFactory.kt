package com.gontharuk.dazn.data.schedule.entity

import android.net.Uri
import com.gontharuk.dazn.data.api.entity.ScheduleModelServer
import com.gontharuk.dazn.data.extensions.localDateTime

class ScheduleModelFactory {

    fun create(input: ScheduleModelServer): ScheduleModel = ScheduleModel(
        id = input.id,
        title = input.title,
        subtitle = input.subtitle,
        date = input.date.localDateTime(),
        imageUrl = Uri.parse(input.imageUrl),
    )
}