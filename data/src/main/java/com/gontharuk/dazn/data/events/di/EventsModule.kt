package com.gontharuk.dazn.data.events.di

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
        fun provideEventModelFactory(): EventModelFactory = EventModelFactory()
    }

    @Binds
    @Singleton
    fun provideEventsRepository(
        repository: EventsRepositoryImpl
    ): EventsRepository
}