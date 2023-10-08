package com.gontharuk.dazn.presentation.schedule.entity

sealed class ScheduleState {

    abstract fun update(input: List<ScheduleItemModel>): ScheduleState

    data object Loading : ScheduleState() {

        override fun update(input: List<ScheduleItemModel>): ScheduleState {
            return Show(input)
        }
    }

    data class Show(val items: List<ScheduleItemModel>) : ScheduleState() {

        override fun update(input: List<ScheduleItemModel>): ScheduleState {
            return copy(items = input)
        }
    }
}
