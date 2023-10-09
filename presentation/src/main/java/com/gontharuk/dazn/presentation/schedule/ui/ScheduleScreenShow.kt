package com.gontharuk.dazn.presentation.schedule.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedFilterChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.gontharuk.dazn.presentation.R
import com.gontharuk.dazn.presentation.core.view.ImageViewUri
import com.gontharuk.dazn.presentation.schedule.entity.ScheduleItemModel
import com.gontharuk.dazn.presentation.schedule.entity.ScheduleState
import com.gontharuk.dazn.presentation.schedule.entity.toItemModel

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ScheduleScreenShow(
    filtered: Boolean,
    state: ScheduleState.Show,
    onFilterClicked: () -> Unit
) {
    val context = LocalContext.current

    val listState = rememberLazyListState()
    val items: List<ScheduleItemModel> = remember(state.items, context) {
        state.items.map { it.toItemModel(context.resources) }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize()
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
        ElevatedFilterChip(
            modifier = Modifier
                .padding(6.dp)
                .align(Alignment.TopEnd),
            onClick = onFilterClicked,
            label = {
                Text(stringResource(R.string.tomorrow))
            },
            selected = filtered,
            leadingIcon = if (filtered) {
                {
                    Icon(
                        imageVector = Icons.Filled.Done,
                        contentDescription = "Done icon",
                        modifier = Modifier.size(FilterChipDefaults.IconSize)
                    )
                }
            } else null
        )
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