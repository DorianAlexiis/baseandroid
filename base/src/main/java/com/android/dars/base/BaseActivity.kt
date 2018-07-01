package com.android.dars.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.View
import android.widget.TextView
import uk.co.chrisjenx.calligraphy.CalligraphyConfig
import java.util.*

open class BaseActivity : AppCompatActivity() {

    private lateinit var mTagFragments: ArrayList<String>
    private var haveToolbar: Boolean = false
    private var mToolbar: Toolbar? = null
    private var tvTitle: TextView? = null

    open fun getActivityLayoutResId(): Int = R.layout.activity_base

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CalligraphyConfig.initDefault(CalligraphyConfig.Builder()
                .setDefaultFontPath(getTypeDefault())
                .setFontAttrId(R.attr.fontPath)
                .build()
        )
        mTagFragments = ArrayList<String>()
        setContentView(getActivityLayoutResId())
        onViewCreated(savedInstanceState)
    }

    private fun getTypeDefault(): String = "fonts/roboto-light.ttf"

    open fun onViewCreated(savedInstanceState: Bundle?) {

    }

    fun findFragmentByTag(tag: String): BaseFragment? {
        return fragmentManager?.findFragmentByTag(tag) as BaseFragment
    }

    fun getLastTagFragment(): String {
        return if (mTagFragments.size == 0) {
            ""
        } else {
            mTagFragments[mTagFragments.size - 1]
        }
    }

    fun setToolbar(toolBar: Toolbar?) {
        if (toolBar != null) {
            setSupportActionBar(toolBar)
            mToolbar = toolBar
            haveToolbar = true
            tvTitle = findViewById(R.id.tvTitle)
        }
    }

    fun showToolbar() {
        if (supportActionBar != null && haveToolbar) {
            setToolbar(mToolbar)
            mToolbar?.visibility = View.VISIBLE
        }
    }

    fun hideToolbar() {
        if (supportActionBar != null && haveToolbar) {
            mToolbar?.visibility = View.GONE
        }
    }

    override fun setTitle(title: CharSequence) {
        supportActionBar?.let {
            it.title = ""
            it.subtitle = ""
            tvTitle?.let {
                it.text = title
            }
        }
    }


    fun replaceFragment(fragment: Fragment) {
        pushFragment(fragment, addBackStack = false)
    }

    @JvmOverloads
    fun pushFragment(fragment: Fragment, container: Int = R.id.container, addBackStack: Boolean = true,
                     vararg animations: Int = intArrayOf()) {
        val transaction = supportFragmentManager.beginTransaction()
        val tag = fragment.javaClass.simpleName
        if (BuildConfig.DEBUG) {
            Log.d("FLOW", "Activity: ${javaClass.simpleName} -> Fragment:  ${tag}")
        }
        if (addBackStack && (fragmentManager.backStackEntryCount > 0)) {
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
            if (mTagFragments.size == 0 || addBackStack) {
                mTagFragments.add(it)
            } else if (mTagFragments.size > 0) {
                mTagFragments.set(mTagFragments.size - 1, it)
            } else {

            }
        }
    }
}