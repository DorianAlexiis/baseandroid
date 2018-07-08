package com.android.dars.base

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife

open class BaseDialog : DialogFragment(){

    private var activity: BaseActivity? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity = getActivity() as BaseActivity?

        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.MyDialogTheme)
    }

    open fun getDialogLayoutResId(): Int = R.layout.dialog_base

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        var view = inflater.inflate(getDialogLayoutResId(), container, false)
        ButterKnife.bind(this, view)
        return view
    }
}