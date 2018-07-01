package com.android.dars.base

import android.os.Bundle

class MainActivity : BaseActivity() {

    override fun onViewCreated(savedInstanceState: Bundle?) {
        super.onViewCreated(savedInstanceState)
        savedInstanceState.let {
            pushFragment(OnBordingFragment.newInstance())
        }
    }

}
