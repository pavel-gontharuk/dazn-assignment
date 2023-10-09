package com.gontharuk.dazn.presentation.events.enity

import com.gontharuk.dazn.data.events.entity.EventModel

sealed class EventsState {

    abstract fun update(input: List<EventModel>): EventsState

    data object Loading : EventsState() {

        override fun update(input: List<EventModel>): EventsState {
            return Show(input)
        }
    }

    data class Show(val items: List<EventModel>) : EventsState() {

        override fun update(input: List<EventModel>): EventsState {
            return copy(items = input)
        }
    }
}
