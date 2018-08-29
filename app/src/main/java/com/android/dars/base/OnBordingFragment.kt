package com.android.dars.base

import android.os.Bundle
import android.view.View
import com.android.dars.base.modules.BlankFragment
import kotlinx.android.synthetic.main.fragment_on_bording.*


class OnBordingFragment : BaseFragment() {

    companion object {
        @JvmStatic fun newInstance(): OnBordingFragment {
            return OnBordingFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        haveToolbar = true
    }

    override fun getFragmentLayoutResId(): Int {
        return R.layout.fragment_on_bording
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTitle(R.string.main_toolbarctivity)
        setupImageToolbar(R.mipmap.ic_launcher_round, true)

        textview.setOnClickListener{
            pushFragment(BlankFragment.newInstance("",""))
        }
    }

}
