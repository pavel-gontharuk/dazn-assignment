package com.gontharuk.dazn.presentation.schedule.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedFilterChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.gontharuk.dazn.presentation.R
import com.gontharuk.dazn.presentation.core.dimensions.Dimens
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
                .padding(Dimens.Padding.content)
                .align(Alignment.TopEnd),
            onClick = onFilterClicked,
            label = {
                Text(stringResource(R.string.tomorrow))
            },
            selected = filtered,
            leadingIcon = if (filtered) {
                {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.check),
                        contentDescription = "Done icon"
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
    Column(
        modifier = modifier
            .padding(Dimens.Padding.content, 0.dp)
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