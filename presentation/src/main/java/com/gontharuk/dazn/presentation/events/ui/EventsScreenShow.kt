package com.gontharuk.dazn.presentation.events.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.gontharuk.dazn.presentation.events.enity.EventItemModel
import com.gontharuk.dazn.presentation.events.enity.EventsState

@Composable
fun EventsScreenShow(
    state: EventsState.Show
) {
    Column {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
        ) {
            items(state.items) {
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