package com.gontharuk.dazn.presentation.schedule.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gontharuk.dazn.data.schedule.repository.ScheduleRepository
import com.gontharuk.dazn.presentation.schedule.entity.ScheduleState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class ScheduleViewModel @Inject constructor(
    scheduleRepository: ScheduleRepository
) : ViewModel() {

    val state: StateFlow<ScheduleState> = scheduleRepository.getSchedule(1_000)//todo to 30_000
        .flowOn(Dispatchers.IO)
        .map { list -> list.sortedBy { it.date } }
        .map { list -> // TODO for date test
            list.mapIndexed { index, scheduleModel ->
                scheduleModel.copy(
                    date = scheduleModel.date.plusDays(index.toLong())
                )
            }
        }
        .map { ScheduleState.Show(it) }
        .catch { it.printStackTrace() }
        .stateIn(
            scope = viewModelScope,
            initialValue = ScheduleState.Loading,
            started = SharingStarted.WhileSubscribed(5_000)
        )
}