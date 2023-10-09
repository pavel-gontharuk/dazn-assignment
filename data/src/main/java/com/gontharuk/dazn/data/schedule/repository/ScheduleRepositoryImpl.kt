package com.gontharuk.dazn.data.schedule.repository

import com.gontharuk.dazn.data.api.ApiService
import com.gontharuk.dazn.data.schedule.entity.ScheduleModel
import com.gontharuk.dazn.data.schedule.entity.ScheduleModelFactory
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ScheduleRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val factory: ScheduleModelFactory
) : ScheduleRepository {

    override fun getSchedule(repeatEachMs: Long): Flow<List<ScheduleModel>> = flow {
        do {
            api.getSchedule()
                .map { factory.create(it) }
                .also { emit(it) }
            delay(repeatEachMs)
        } while (repeatEachMs > 0)
    }
}