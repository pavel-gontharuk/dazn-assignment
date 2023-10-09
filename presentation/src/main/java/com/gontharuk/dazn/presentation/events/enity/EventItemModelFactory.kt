package com.gontharuk.dazn.presentation.events.enity

import android.content.res.Resources
import com.gontharuk.dazn.data.events.entity.EventModel
import com.gontharuk.dazn.presentation.core.formatting.format

class EventItemModelFactory(
    private val resources: Resources
) {

    fun create(input: EventModel): EventItemModel = EventItemModel(
        title = input.title,
        subtitle = input.subtitle,
        date = input.date.format(resources),//todo move format to ui
        imageUrl = input.imageUrl,
        videoUrl = input.videoUrl,
    )
}