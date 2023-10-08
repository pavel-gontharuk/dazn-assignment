package com.gontharuk.dazn.presentation.events.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.gontharuk.dazn.presentation.events.enity.EventsState
import com.gontharuk.dazn.presentation.events.viewmodel.EventsViewModel

@Composable
fun EventsScreen(
    viewModel: EventsViewModel = hiltViewModel()
) {
    val state: EventsState by viewModel.state.collectAsState()

    LaunchedEffect(viewModel) {
        viewModel.fetch()
    }

    Column(
        modifier = Modifier
            .fillMaxHeight()
    ) {
        state.also {
            when (it) {
                EventsState.Loading -> EventsScreenLoading()
                is EventsState.Show -> EventsScreenShow(state = it)
            }
        }
    }
}