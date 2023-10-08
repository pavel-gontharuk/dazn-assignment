package com.gontharuk.dazn.presentation.schedule.di

import com.gontharuk.dazn.presentation.schedule.entity.ScheduleItemModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ScheduleModule {

    @Provides
    @Singleton
    fun provideScheduleItemModelFactory(): ScheduleItemModelFactory = ScheduleItemModelFactory()
}