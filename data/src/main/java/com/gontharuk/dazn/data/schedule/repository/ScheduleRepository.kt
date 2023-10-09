package com.gontharuk.dazn.data.schedule.repository

import com.gontharuk.dazn.data.schedule.entity.ScheduleModel
import kotlinx.coroutines.flow.Flow

interface ScheduleRepository {

    fun getSchedule(repeatEachMs: Long = 0L): Flow<List<ScheduleModel>>
}