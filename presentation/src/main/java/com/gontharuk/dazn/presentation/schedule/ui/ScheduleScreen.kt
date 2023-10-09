package com.gontharuk.dazn.presentation.schedule.ui

import androidx.compose.runtime.Composable
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
    val filtered: Boolean by viewModel.tomorrowFilter.collectAsState()

    when (val mState = state) {
        ScheduleState.Loading -> ScheduleScreenLoading()
        is ScheduleState.Show -> ScheduleScreenShow(
            filtered = filtered,
            state = mState,
            onFilterClicked = viewModel::onFilterClicked
        )
    }
}