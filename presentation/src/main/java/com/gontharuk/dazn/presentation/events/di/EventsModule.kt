package com.gontharuk.dazn.presentation.events.di

import com.gontharuk.dazn.presentation.events.enity.EventItemModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object EventsModule {

    @Provides
    @Singleton
    fun provideEventItemModelFactory(): EventItemModelFactory = EventItemModelFactory()
}