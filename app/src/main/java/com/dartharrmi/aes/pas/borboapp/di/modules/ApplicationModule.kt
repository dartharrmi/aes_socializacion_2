package com.dartharrmi.aes.pas.borboapp.di.modules

import android.app.Application
import android.content.Context
import com.dartharrmi.aes.pas.borboapp.application.BorboApplication
import com.dartharrmi.aes.pas.borboapp.managers.FirebaseDatabaseManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Provides
    @Singleton
    fun provideApplication(application: BorboApplication): Application = application

    @Provides
    @Singleton
    fun provideContext(application: BorboApplication): Context = application

    @Provides
    @Singleton
    fun providesFirebaseDatabaseManager(): FirebaseDatabaseManager = FirebaseDatabaseManager()
}