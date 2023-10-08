package com.gontharuk.dazn.presentation.events.enity

sealed class EventsState {

    abstract fun update(data: List<EventItemModel>): EventsState

    data object Loading : EventsState() {

        override fun update(data: List<EventItemModel>): EventsState {
            return Show(data)
        }
    }

    data class Show(val items: List<EventItemModel>) : EventsState() {

        override fun update(data: List<EventItemModel>): EventsState {
            TODO("Not yet implemented")
        }
    }
}
