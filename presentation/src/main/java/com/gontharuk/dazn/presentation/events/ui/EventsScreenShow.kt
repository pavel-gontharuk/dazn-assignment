package com.gontharuk.dazn.presentation.events.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.gontharuk.dazn.presentation.events.enity.EventItemModel
import com.gontharuk.dazn.presentation.events.enity.EventsState
import com.gontharuk.dazn.presentation.events.enity.toItemModel

@Composable
fun EventsScreenShow(
    state: EventsState.Show
) {
    val context = LocalContext.current

    val items: List<EventItemModel> = remember(state.items, context) {
        state.items.map { it.toItemModel(context.resources) }
    }

    Column {
        LazyColumn {
            items(items) {
                EventItemView(model = it)
            }
        }
    }
}

@Composable
fun EventItemView(
    model: EventItemModel
) {
    // todo video thumbnail
    // todo click listener
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        Divider(thickness = 1.dp, color = Color.Black)
        Text(text = model.title)
        Text(text = model.subtitle)
        Text(text = model.date)
    }
}