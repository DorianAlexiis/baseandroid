package com.android.dars.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import java.util.*

open class BaseActivity : AppCompatActivity() {

    protected lateinit var mTagFragments: ArrayList<String>

    open fun getActivityLayoutResId(): Int = R.layout.activity_base

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mTagFragments = ArrayList<String>()
        setContentView(getActivityLayoutResId())
        onViewCreated(savedInstanceState)
    }

    open fun onViewCreated(savedInstanceState: Bundle?) {

    }

    fun replaceFragment(fragment: Fragment) {
        pushFragment(fragment, addBackStack = false)
    }

    fun pushFragment(fragment: Fragment, container: Int = R.id.container, addBackStack: Boolean = true,
                     vararg animations: Int = intArrayOf()) {
        val transaction = supportFragmentManager.beginTransaction()
        val tag = fragment.tag
        if (BuildConfig.DEBUG) {
            Log.d("FLOW", "Activity: " + tag + " -> " +
                    "Fragment: " + fragment.tag)
        }
        if (addBackStack) {
            transaction.addToBackStack(tag)
        }

        when (animations.size) {
            0 -> transaction.setCustomAnimations(
                    R.anim.push_show_in_simple,
                    R.anim.push_hidden_out_simple,
                    0,
                    0)
            1 -> {
            }
            2 -> transaction.setCustomAnimations(animations[0], animations[1], 0, 0)
            4 -> transaction.setCustomAnimations(animations[0], animations[1], animations[2], animations[3])
            else -> throw RuntimeException("Error with animations transaction")
        }


        transaction.replace(container, fragment, tag)
        try {
            transaction.commit()
        } catch (e: Exception) {
            return
        }

        tag?.let {
            if(mTagFragments.size == 0 || addBackStack){
                mTagFragments.add(it)
            }else if(mTagFragments.size > 0){
                mTagFragments.set(mTagFragments.size - 1, it)
            } else{

            }
        }
    }
}