package com.dartharrmi.aes.pas.borboapp.di.builder

import com.dartharrmi.aes.pas.borboapp.di.modules.ActivitiesModule
import com.dartharrmi.aes.pas.borboapp.presentation.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 */
@Module
@Suppress("UNUSED")
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [ActivitiesModule::class])
    internal abstract fun bindSplashActivity(): SplashActivity
}