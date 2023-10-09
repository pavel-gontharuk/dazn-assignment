package com.gontharuk.dazn.presentation.schedule.entity

import com.gontharuk.dazn.data.schedule.entity.ScheduleModel

sealed class ScheduleState {

    abstract fun update(input: List<ScheduleModel>): ScheduleState

    data object Loading : ScheduleState() {

        override fun update(input: List<ScheduleModel>): ScheduleState {
            return Show(input)
        }
    }

    data class Show(val items: List<ScheduleModel>) : ScheduleState() {

        override fun update(input: List<ScheduleModel>): ScheduleState {
            return copy(items = input)
        }
    }
}
