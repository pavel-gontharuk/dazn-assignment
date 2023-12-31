package com.gontharuk.dazn.data.events.entity

import android.net.Uri
import com.gontharuk.dazn.data.api.entity.EventModelServer
import com.gontharuk.dazn.data.extensions.localDateTime

class EventModelFactory {

    fun create(input: EventModelServer): EventModel = EventModel(
        id = input.id,
        title = input.title,
        subtitle = input.subtitle,
        date = input.date.localDateTime(),
        imageUrl = Uri.parse(input.imageUrl),
        videoUrl = Uri.parse(input.videoUrl),
    )
}