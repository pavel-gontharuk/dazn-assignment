package com.gontharuk.dazn.presentation.events.enity

import com.gontharuk.dazn.data.events.entity.EventModel

class EventItemModelFactory {

    fun create(input: EventModel): EventItemModel = EventItemModel(
        title = input.title,
        subtitle = input.subtitle,
        date = input.date.toString(),//todo format for UI
        imageUrl = input.imageUrl,
        videoUrl = input.videoUrl,
    )
}