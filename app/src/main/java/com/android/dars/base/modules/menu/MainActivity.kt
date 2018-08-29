package com.android.dars.base.modules.menu

import android.os.Bundle
import com.android.dars.base.BaseActivity
import com.android.dars.base.modules.main.MainFragment

class MainActivity : BaseActivity() {

    /*override fun getActivityLayoutResId() = R.layout.activity_main*/

    override fun onViewCreated(savedInstanceState: Bundle?) {
        super.onViewCreated(savedInstanceState)

        if(savedInstanceState == null){
            pushFragment(MainFragment.newInstance())
        }
    }

}
