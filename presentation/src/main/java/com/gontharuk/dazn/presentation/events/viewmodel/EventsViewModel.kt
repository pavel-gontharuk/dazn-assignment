package com.gontharuk.dazn.presentation.events.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gontharuk.dazn.data.events.entity.EventModel
import com.gontharuk.dazn.data.events.repository.EventRepository
import com.gontharuk.dazn.presentation.events.enity.EventsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import javax.inject.Inject

@HiltViewModel
class EventsViewModel @Inject constructor(
    private val eventRepository: EventRepository
) : ViewModel() {

    private val _state: MutableStateFlow<EventsState> = MutableStateFlow(EventsState.Loading)
    val state: StateFlow<EventsState> get() = _state

    suspend fun fetch() {
        val events = viewModelScope.async(Dispatchers.IO) {
            eventRepository.getEvents()
                .catch { it.printStackTrace() }
        }
        events.await().collect {
            updateState(it)
        }
    }

    private fun updateState(items: List<EventModel>) {
        state.value.also { state ->
            _state.value = state.update(items)
        }
    }
}