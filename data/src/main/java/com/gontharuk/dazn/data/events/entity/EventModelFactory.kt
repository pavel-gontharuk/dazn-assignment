package com.gontharuk.dazn.data.events.entity

import android.net.Uri
import com.gontharuk.dazn.data.api.entity.EventModelServer
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

class EventModelFactory {

    fun create(input: EventModelServer): EventModel = EventModel(
        id = input.id,
        title = input.title,
        subtitle = input.subtitle,
        date = localDateTime(input.date),
        imageUrl = Uri.parse(input.imageUrl),
        videoUrl = Uri.parse(input.videoUrl),
    )

    private fun localDateTime(input: String): LocalDateTime = Instant
        .from(DateTimeFormatter.ISO_INSTANT.parse(input))
        .atZone(ZoneId.of("UTC"))
        .toLocalDateTime()
}