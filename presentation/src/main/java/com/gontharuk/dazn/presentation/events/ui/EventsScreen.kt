package com.gontharuk.dazn.presentation.events.ui

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.gontharuk.dazn.presentation.events.enity.EventsState
import com.gontharuk.dazn.presentation.events.viewmodel.EventsViewModel

@Composable
fun EventsScreen(
    viewModel: EventsViewModel = hiltViewModel(),
    onClicked: (Uri) -> Unit
) {
    val state: EventsState by viewModel.state.collectAsState()

    when (val mState = state) {
        EventsState.Loading -> EventsScreenLoading()
        is EventsState.Show -> EventsScreenShow(
            state = mState,
            onClicked = onClicked
        )
    }
}