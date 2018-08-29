package com.android.dars.base.modules.toolbaractivity

import android.os.Bundle
import com.android.dars.base.BaseActivity
import com.android.dars.base.R

class ToolbarActivity : BaseActivity() {

    override fun getActivityLayoutResId() = R.layout.activity_toolbar

    override fun onViewCreated(savedInstanceState: Bundle?) {
        super.onViewCreated(savedInstanceState)
    }

}
