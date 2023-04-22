package com.simcodic.pincodegenerator.di

import android.content.Context
import androidx.room.Room
import com.simcodic.pincodegenerator.data.repositories.local.database.PinCodeDatabase
import com.simcodic.pincodegenerator.presentation.MainActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DBModule {

    @Provides
    @Singleton
    fun provideDB(@ApplicationContext applicationContext: Context) =
        Room.databaseBuilder(applicationContext, PinCodeDatabase::class.java, "database-name").build()
}