package com.android.dars.base

import android.support.v4.app.Fragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class BaseInjectActivity : BaseActivity(), HasSupportFragmentInjector {

    @Inject
    @JvmField
    var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>? = null

    override fun supportFragmentInjector(): AndroidInjector<Fragment>? = fragmentDispatchingAndroidInjector


    override fun initialize() {
        super.initialize()
        AndroidInjection.inject(this)
    }

}