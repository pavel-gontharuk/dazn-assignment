package com.gontharuk.dazn.presentation.schedule.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.gontharuk.dazn.presentation.core.view.ImageViewUri
import com.gontharuk.dazn.presentation.schedule.entity.ScheduleItemModel
import com.gontharuk.dazn.presentation.schedule.entity.ScheduleState
import com.gontharuk.dazn.presentation.schedule.entity.toItemModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ScheduleScreenShow(
    state: ScheduleState.Show
) {
    val context = LocalContext.current

    val listState = rememberLazyListState()
    val items: List<ScheduleItemModel> = remember(state.items, context) {
        state.items.map { it.toItemModel(context.resources) }
    }

    Column {
        LazyColumn(
            modifier = Modifier
                .weight(1f),
            state = listState,
        ) {
            items(
                items = items,
                key = { it.hashCode() }
            ) {
                ScheduleItemView(
                    modifier = Modifier.animateItemPlacement(),
                    model = it
                )
            }
        }
    }
}

@Composable
fun ScheduleItemView(
    modifier: Modifier,
    model: ScheduleItemModel
) {
    Row(
        modifier = modifier
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