package com.android.dars.base

import dagger.android.support.AndroidSupportInjection

class BaseInjectFragment : BaseFragment(){

    override fun initialize() {
        super.initialize()
        AndroidSupportInjection.inject(this)
    }
}
