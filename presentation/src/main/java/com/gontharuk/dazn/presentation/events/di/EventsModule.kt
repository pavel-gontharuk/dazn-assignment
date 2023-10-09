package com.gontharuk.dazn.presentation.events.di

import android.content.Context
import com.gontharuk.dazn.presentation.events.enity.EventItemModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object EventsModule {

    @Provides
    @ViewModelScoped
    fun provideEventItemModelFactory(
        @ApplicationContext context: Context
    ): EventItemModelFactory = EventItemModelFactory(context.resources)
}