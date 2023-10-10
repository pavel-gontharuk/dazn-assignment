package com.gontharuk.dazn.presentation.events.ui

import android.net.Uri
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.magnifier
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.gontharuk.dazn.presentation.core.dimensions.Dimens
import com.gontharuk.dazn.presentation.core.view.ImageViewUri
import com.gontharuk.dazn.presentation.events.enity.EventItemModel
import com.gontharuk.dazn.presentation.events.enity.EventsState
import com.gontharuk.dazn.presentation.events.enity.toItemModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun EventsScreenShow(
    state: EventsState.Show,
    onClicked: (Uri) -> Unit
) {
    val context = LocalContext.current
    val listState = rememberLazyListState()

    val items: List<EventItemModel> = remember(state.items, context) {
        state.items.map { it.toItemModel(context.resources) }
    }

    Column {
        LazyColumn(
            modifier = Modifier
                .padding(0.dp, Dimens.Padding.content),
            state = listState
        ) {
            items(
                items = items,
                key = { it.hashCode() }
            ) {
                EventItemView(
                    model = it,
                    modifier = Modifier.animateItemPlacement(),
                    onClicked = onClicked
                )
            }
        }
    }
}

@Composable
fun EventItemView(
    modifier: Modifier,
    model: EventItemModel,
    onClicked: (Uri) -> Unit
) {
    Column(
        modifier = modifier
            .padding(Dimens.Padding.content, 0.dp)
            .clickable { onClicked(model.videoUrl) }
    ) {
        Row(
            modifier = Modifier
                .height(Dimens.Size.listItem)
        ) {
            ImageViewUri(
                modifier = Modifier
                    .aspectRatio(Dimens.Ratio.thumbnail)
                    .fillMaxHeight(),
                uri = model.imageUrl
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(Dimens.Padding.content, 0.dp, 0.dp, 0.dp)
                    .height(Dimens.Size.listItem)
            ) {
                Text(
                    text = model.title,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = model.subtitle,
                    style = MaterialTheme.typography.titleSmall
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = model.date,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.tertiary
                )
            }
        }
        Divider(
            color = Color.Black,
            modifier = Modifier.padding(0.dp, Dimens.Padding.divider),
            thickness = Dimens.Size.divider
        )
    }
}