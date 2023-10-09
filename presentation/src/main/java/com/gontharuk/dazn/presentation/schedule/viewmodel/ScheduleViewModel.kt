package com.gontharuk.dazn.presentation.schedule.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gontharuk.dazn.data.schedule.repository.ScheduleRepository
import com.gontharuk.dazn.presentation.core.formatting.deltaDays
import com.gontharuk.dazn.presentation.schedule.entity.ScheduleState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class ScheduleViewModel @Inject constructor(
    scheduleRepository: ScheduleRepository
) : ViewModel() {

    private val _tomorrowFilter: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val tomorrowFilter: StateFlow<Boolean> get() = _tomorrowFilter

    val state: StateFlow<ScheduleState> = scheduleRepository.getSchedule(30_000)
        .flowOn(Dispatchers.IO)
        .combine(tomorrowFilter) { list, onlyTomorrow ->
            if (onlyTomorrow) {
                val today = LocalDateTime.now()
                list.filter { today.deltaDays(it.date) == 1 }
            } else list
        }
        .map { list -> list.sortedBy { it.date } }
        .map { ScheduleState.Show(it) }
        .catch { it.printStackTrace() }
        .stateIn(
            scope = viewModelScope,
            initialValue = ScheduleState.Loading,
            started = SharingStarted.WhileSubscribed(5_000)
        )

    fun onFilterClicked() {
        _tomorrowFilter.value = !_tomorrowFilter.value
    }
}