package com.dartharrmi.aes.pas.borboapp.di.modules

import com.dartharrmi.aes.pas.borboapp.presentation.splash.SplashContract
import com.dartharrmi.aes.pas.borboapp.presentation.splash.SplashPresenter
import dagger.Module
import dagger.Provides

/**
 */
@Module
class ActivitiesModule {

    @Provides
    fun provideSplashPresenter(splashPresenter: SplashPresenter): SplashContract.Presenter = splashPresenter
}