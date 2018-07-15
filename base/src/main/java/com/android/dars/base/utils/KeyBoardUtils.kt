package com.android.dars.base.utils

import android.app.Activity
import android.content.Context.INPUT_METHOD_SERVICE
import android.view.View
import android.view.inputmethod.InputMethodManager

object KeyBoardUtils{


    fun hideKeyboard(activity: Activity, view: View?) {
        if (view == null) {
            return
        }
        val imm = activity.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        view.requestFocus()
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun hideKeyboardWithDelay(activity: Activity, view: View) {
        val handler = android.os.Handler()
        handler.postDelayed({ hideKeyboard(activity, view) }, 50)
    }
}
