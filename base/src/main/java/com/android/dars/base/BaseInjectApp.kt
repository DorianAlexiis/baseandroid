package com.android.dars.base

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

open class BaseInjectApp : Application(), HasActivityInjector{
    @Inject
    @JvmField
    var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>? = null

    override fun activityInjector(): AndroidInjector<Activity>? = activityDispatchingAndroidInjector
}