package com.gontharuk.dazn.data.events.entity

import android.net.Uri
import com.gontharuk.dazn.data.api.entity.EventModelServer
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class EventModelFactory {

    fun create(input: EventModelServer): EventModel = EventModel(
        id = input.id,
        title = input.title,
        subtitle = input.subtitle,
        date = LocalDateTime.parse(input.date, DateTimeFormatter.ISO_INSTANT),
        imageUrl = Uri.parse(input.imageUrl),
        videoUrl = Uri.parse(input.videoUrl),
    )
}