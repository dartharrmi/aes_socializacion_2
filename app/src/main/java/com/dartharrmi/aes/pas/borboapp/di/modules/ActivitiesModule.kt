package com.dartharrmi.aes.pas.borboapp.di.modules

import com.dartharrmi.aes.pas.borboapp.presentation.splash.SplashContract
import com.dartharrmi.aes.pas.borboapp.presentation.splash.SplashPresenter
import dagger.Module
import dagger.Provides

/**
 * @author Guillermo Varela (guillermo.varela@wavy.global)
 */
@Module
class ActivitiesModule {

    @Provides
    fun provideSplashPresenter(splashPresenter: SplashPresenter): SplashContract.Presenter = splashPresenter
}