package com.gontharuk.dazn.data.extensions

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

fun String.localDateTime(): LocalDateTime = Instant
    .from(DateTimeFormatter.ISO_INSTANT.parse(this))
    .atZone(ZoneId.systemDefault())
    .toLocalDateTime()