package com.gontharuk.dazn.presentation.events.viewmodel

import androidx.lifecycle.ViewModel
import com.gontharuk.dazn.data.events.repository.EventsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EventsViewModel @Inject constructor(
    private val eventsRepository: EventsRepository
) : ViewModel() {
}