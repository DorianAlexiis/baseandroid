package com.kitsu.android.anime.ui.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.dars.base.R

open class BaseFragment: Fragment(){

    private var activity: BaseActivity? = null
    protected var mView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity = getActivity() as BaseActivity
    }

    open fun getFragmentLayoutResId(): Int = R.layout.fragment_base

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        mView = inflater.inflate(getFragmentLayoutResId(), container, false)
        return mView
    }

    protected fun pushFragment(fragment: Fragment, container: Int= R.id.container,
                               addBackStack: Boolean = true) {
        activity?.pushFragment(fragment, container, addBackStack)
    }

    fun replaceFragment(fragment: Fragment, container: Int = R.id.container) {
        activity?.pushFragment(fragment,container = container, addBackStack =  false)
    }

}