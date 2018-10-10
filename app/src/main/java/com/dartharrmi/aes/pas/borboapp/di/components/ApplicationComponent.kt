package com.dartharrmi.aes.pas.borboapp.di.components

import com.dartharrmi.aes.pas.borboapp.application.BorboApplication
import com.dartharrmi.aes.pas.borboapp.di.builder.ActivityBuilder
import com.dartharrmi.aes.pas.borboapp.di.modules.ApplicationModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

/**
 * @author Guillermo Varela (guillermo.varela@wavy.global)
 */
@Singleton
@Suppress("UNUSED")
@Component(modules = [AndroidInjectionModule::class, ApplicationModule::class, ActivityBuilder::class])
interface ApplicationComponent : AndroidInjector<BorboApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<BorboApplication>()

    override fun inject(application: BorboApplication)
}