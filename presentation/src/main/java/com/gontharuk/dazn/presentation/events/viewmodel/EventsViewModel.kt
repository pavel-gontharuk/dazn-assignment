package com.gontharuk.dazn.presentation.events.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gontharuk.dazn.data.events.repository.EventRepository
import com.gontharuk.dazn.presentation.events.enity.EventsState
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
class EventsViewModel @Inject constructor(
    eventRepository: EventRepository
) : ViewModel() {

    val state: StateFlow<EventsState> = eventRepository.getEvents()
        .flowOn(Dispatchers.IO)
        .map { list -> list.sortedBy { it.date } }
        .map { EventsState.Show(it) }
        .catch { it.printStackTrace() }
        .stateIn(
            scope = viewModelScope,
            initialValue = EventsState.Loading,
            started = SharingStarted.WhileSubscribed(5_000)
        )
}