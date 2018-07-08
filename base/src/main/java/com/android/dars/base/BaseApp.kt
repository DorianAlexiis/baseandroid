package com.android.dars.base

import android.app.Application
import com.crashlytics.android.Crashlytics
import com.crashlytics.android.core.CrashlyticsCore
import io.fabric.sdk.android.Fabric

open class BaseApp : Application(){

    override fun onCreate() {
        super.onCreate()
        setUseFabric()
    }

    open fun setUseFabric(enable:Boolean = false){
        Fabric.with(this, Crashlytics.Builder().core(CrashlyticsCore.Builder()
                .disabled(!enable).build()).build(), Crashlytics())
    }
}