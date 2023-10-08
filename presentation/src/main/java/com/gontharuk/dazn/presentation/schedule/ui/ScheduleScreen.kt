package com.gontharuk.dazn.presentation.schedule.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.gontharuk.dazn.presentation.schedule.entity.ScheduleState
import com.gontharuk.dazn.presentation.schedule.viewmodel.ScheduleViewModel

@Composable
fun ScheduleScreen(
    viewModel: ScheduleViewModel = hiltViewModel()
) {
    val state: ScheduleState by viewModel.state.collectAsState()

    LaunchedEffect(viewModel) {
        viewModel.fetch()
    }

    when (val mState = state) {
        ScheduleState.Loading -> ScheduleScreenLoading()
        is ScheduleState.Show -> ScheduleScreenShow(state = mState)
    }
}