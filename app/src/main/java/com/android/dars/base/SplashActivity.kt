package com.android.dars.base

import android.content.Intent
import android.os.Bundle
import com.android.dars.base.modules.menu.MainActivity


class SplashActivity : BaseActivity() {

    override fun getActivityLayoutResId(): Int  = R.layout.activity_base


    override fun onViewCreated(savedInstanceState: Bundle?) {
        super.onViewCreated(savedInstanceState)

        startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        // close splash activity
        finish()
    }
}
