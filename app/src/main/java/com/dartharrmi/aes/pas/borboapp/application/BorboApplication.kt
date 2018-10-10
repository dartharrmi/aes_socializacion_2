package com.dartharrmi.aes.pas.borboapp.application

import android.app.Activity
import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import com.dartharrmi.aes.pas.borboapp.di.components.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * @author miguel.arroyo (miguel.arroyo@wavy.global).
 */
class BorboApplication: Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()

        DaggerApplicationComponent
                .builder()
                .create(this)
                .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }
}
