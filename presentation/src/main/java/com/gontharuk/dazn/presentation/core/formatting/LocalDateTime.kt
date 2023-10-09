package com.gontharuk.dazn.presentation.core.formatting

import android.content.res.Resources
import com.gontharuk.dazn.presentation.R
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun LocalDateTime.format(
    resources: Resources
): String {
    val today = LocalDateTime.now().toLocalDate()
    val yesterday = today.minusDays(1)
    val dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy")
    val timeFormat = DateTimeFormatter.ofPattern("HH:mm")

    return when (toLocalDate()) {
        today -> "${resources.getString(R.string.today)}, ${format(timeFormat)}"
        yesterday -> "${resources.getString(R.string.yesterday)}, ${format(timeFormat)}"
        else -> format(dateFormat)
    }
}