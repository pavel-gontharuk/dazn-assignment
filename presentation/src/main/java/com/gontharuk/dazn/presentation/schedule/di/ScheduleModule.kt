package com.gontharuk.dazn.presentation.schedule.di

import android.content.Context
import com.gontharuk.dazn.presentation.schedule.entity.ScheduleItemModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object ScheduleModule {

    @Provides
    @ViewModelScoped
    fun provideScheduleItemModelFactory(
        @ApplicationContext context: Context
    ): ScheduleItemModelFactory = ScheduleItemModelFactory(context.resources)
}