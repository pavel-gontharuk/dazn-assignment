package com.gontharuk.dazn.data.events.repository

import com.gontharuk.dazn.data.events.entity.EventModel
import kotlinx.coroutines.flow.Flow

interface EventsRepository {

    fun getEvents(): Flow<List<EventModel>>
}