package com.gontharuk.dazn.di.schedule

import com.gontharuk.dazn.data.schedule.entity.ScheduleModelFactory
import com.gontharuk.dazn.data.schedule.repository.ScheduleRepository
import com.gontharuk.dazn.data.schedule.repository.ScheduleRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface ScheduleModule {

    companion object {
        @Provides
        @Singleton
        fun provideScheduleModelFactory(): ScheduleModelFactory = ScheduleModelFactory()
    }

    @Binds
    @Singleton
    fun provideScheduleRepository(
        repository: ScheduleRepositoryImpl
    ): ScheduleRepository
}