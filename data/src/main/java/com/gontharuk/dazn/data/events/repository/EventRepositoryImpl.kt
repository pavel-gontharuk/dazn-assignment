package com.gontharuk.dazn.data.events.repository

import com.gontharuk.dazn.data.api.ApiService
import com.gontharuk.dazn.data.events.entity.EventModel
import com.gontharuk.dazn.data.events.entity.EventModelFactory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class EventRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val factory: EventModelFactory
) : EventRepository {

    override fun getEvents(): Flow<List<EventModel>> = flow {
        api.getEvents()
            .map { factory.create(it) }
            .also { emit(it) }
    }
}