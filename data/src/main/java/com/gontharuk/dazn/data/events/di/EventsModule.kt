package com.gontharuk.dazn.data.events.di

import com.gontharuk.dazn.data.api.ApiService
import com.gontharuk.dazn.data.events.entity.EventModelFactory
import com.gontharuk.dazn.data.events.repository.EventsRepository
import com.gontharuk.dazn.data.events.repository.EventsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface EventsModule {

    companion object {
        @Provides
        @Singleton
        fun provideEventsRepository(
            api: ApiService,
            factory: EventModelFactory
        ): EventsRepository = EventsRepositoryImpl(
            api = api,
            factory = factory
        )
    }

    @Binds
    @Singleton
    fun provideEventModelFactory(
        factory: EventModelFactory
    ): EventModelFactory
}