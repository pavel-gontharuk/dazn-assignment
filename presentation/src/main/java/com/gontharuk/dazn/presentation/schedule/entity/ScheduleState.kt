package com.gontharuk.dazn.presentation.schedule.entity

sealed class ScheduleState {

    abstract fun update(items: List<ScheduleItemModel>): ScheduleState

    data object Loading : ScheduleState() {

        override fun update(items: List<ScheduleItemModel>): ScheduleState {
            return Show(items)
        }
    }

    data class Show(val items: List<ScheduleItemModel>) : ScheduleState() {

        override fun update(items: List<ScheduleItemModel>): ScheduleState {
            TODO("Not yet implemented")
        }
    }
}
