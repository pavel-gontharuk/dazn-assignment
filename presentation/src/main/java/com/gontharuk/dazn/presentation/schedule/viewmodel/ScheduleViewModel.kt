package com.gontharuk.dazn.presentation.schedule.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gontharuk.dazn.data.schedule.repository.ScheduleRepository
import com.gontharuk.dazn.presentation.schedule.entity.ScheduleItemModel
import com.gontharuk.dazn.presentation.schedule.entity.ScheduleItemModelFactory
import com.gontharuk.dazn.presentation.schedule.entity.ScheduleState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class ScheduleViewModel @Inject constructor(
    private val scheduleRepository: ScheduleRepository,
    private val itemFactory: ScheduleItemModelFactory
) : ViewModel() {

    private val _state: MutableStateFlow<ScheduleState> = MutableStateFlow(ScheduleState.Loading)
    val state: StateFlow<ScheduleState> get() = _state

    suspend fun fetch() {
        val schedule = viewModelScope.async(Dispatchers.IO) {
            scheduleRepository.getSchedule()
                .map { list ->
                    list.map { itemFactory.create(it) }
                }
        }
        schedule.await().collect {
            updateState(it)
        }
    }

    private fun updateState(items: List<ScheduleItemModel>) {
        state.value.also { state ->
            _state.value = state.update(items)
        }
    }
}