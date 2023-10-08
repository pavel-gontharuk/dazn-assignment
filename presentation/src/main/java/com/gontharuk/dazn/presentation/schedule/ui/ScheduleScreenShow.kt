package com.gontharuk.dazn.presentation.schedule.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
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
import com.gontharuk.dazn.presentation.core.view.ImageViewUri
import com.gontharuk.dazn.presentation.schedule.entity.ScheduleItemModel
import com.gontharuk.dazn.presentation.schedule.entity.ScheduleState

@Composable
fun ScheduleScreenShow(
    state: ScheduleState.Show
) {

    Column {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
        ) {
            items(state.items) {
                ScheduleItemView(it)
            }
        }
    }
}

@Composable
fun ScheduleItemView(
    model: ScheduleItemModel
) {
    Row(
        modifier = Modifier
            .height(100.dp)
    ) {
        ImageViewUri(
            modifier = Modifier
                .aspectRatio(4f / 3f)
                .fillMaxHeight(),
            uri = model.imageUrl
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Divider(thickness = 1.dp, color = Color.Black)
            Text(text = model.title)
            Text(text = model.subtitle)
            Text(text = model.date)
        }
    }
}