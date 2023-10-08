package com.gontharuk.dazn.data.api

import com.gontharuk.dazn.data.api.entity.EventModelServer
import com.gontharuk.dazn.data.api.entity.ScheduleModelServer
import retrofit2.http.GET

interface ApiService {

    @GET("getEvents")
    fun getEvents(): List<EventModelServer>

    @GET("getSchedule")
    fun getSchedule(): List<ScheduleModelServer>
}