package com.gontharuk.dazn.presentation.events.enity

sealed class EventsState {

    abstract fun update(input: List<EventItemModel>): EventsState

    data object Loading : EventsState() {

        override fun update(input: List<EventItemModel>): EventsState {
            return Show(input)
        }
    }

    data class Show(val items: List<EventItemModel>) : EventsState() {

        override fun update(input: List<EventItemModel>): EventsState {
            return copy(items = input)
        }
    }
}
