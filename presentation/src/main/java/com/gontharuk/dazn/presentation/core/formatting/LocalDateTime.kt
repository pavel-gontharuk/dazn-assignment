package com.gontharuk.dazn.presentation.core.formatting

import android.content.res.Resources
import com.gontharuk.dazn.presentation.R
import java.time.LocalDateTime
import java.time.Period
import java.time.format.DateTimeFormatter

fun LocalDateTime.format(
    resources: Resources
): String {
    val dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy")
    val timeFormat = DateTimeFormatter.ofPattern("HH:mm")

    return when (val deltaDays = LocalDateTime.now().deltaDays(this)) {
        -1 -> "${resources.getString(R.string.yesterday)}, ${format(timeFormat)}"
        0 -> "${resources.getString(R.string.today)}, ${format(timeFormat)}"
        1 -> "${resources.getQuantityString(R.plurals.daysToEvent, deltaDays, deltaDays)}, ${format(timeFormat)}"
        in 2..Int.MAX_VALUE -> resources.getQuantityString(R.plurals.daysToEvent, deltaDays, deltaDays)
        else -> format(dateFormat)
    }
}

fun LocalDateTime.deltaDays(target: LocalDateTime): Int = Period
    .between(toLocalDate(), target.toLocalDate())
    .days