package com.android.dars.base

import android.content.Intent
import android.os.Bundle



class SplashActivity : BaseActivity() {


    override fun onViewCreated(savedInstanceState: Bundle?) {
        super.onViewCreated(savedInstanceState)

        startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        // close splash activity
        finish()
    }
}
