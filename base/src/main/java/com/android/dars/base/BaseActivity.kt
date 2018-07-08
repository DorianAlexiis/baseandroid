package com.android.dars.base

import android.content.Intent
import android.os.Bundle
import android.support.annotation.DrawableRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import dmax.dialog.SpotsDialog
import java.util.*

open class BaseActivity : AppCompatActivity() {

    private lateinit var mTagFragments: ArrayList<String>
    private var haveToolbar: Boolean = false
    private var mToolbar: Toolbar? = null
    private var tvTitle: TextView? = null

    private var progressDialog: SpotsDialog? = null

    open fun getActivityLayoutResId(): Int = R.layout.activity_base

    open fun initialize() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        initialize()
        super.onCreate(savedInstanceState)
        mTagFragments = ArrayList<String>()
        setContentView(getActivityLayoutResId())
        onViewCreated(savedInstanceState)
    }

    open fun onViewCreated(savedInstanceState: Bundle?) {

    }

    fun findFragmentByTag(tag: String): BaseFragment? {
        val fragment = fragmentManager?.findFragmentByTag(tag)
        if(fragment != null){
            return fragment as BaseFragment
        }
        return null
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        val fragment = fragmentManager.findFragmentByTag(getLastTagFragment())
        if (fragment != null && fragment is BaseFragment) {
            val base = fragment as BaseFragment
            base.onActivityResult(requestCode, resultCode, data)
        }
    }

    override fun onOptionsItemSelected(menuItem: MenuItem): Boolean {
        if (menuItem.itemId == android.R.id.home) {
            if (mTagFragments.size > 1) {
                val fragment = fragmentManager.findFragmentByTag(mTagFragments[mTagFragments.size - 1])
                if (fragment is BaseFragment) {
                    val base = fragment as BaseFragment
                    if (base.onBackToolbar()) {
                        return true
                    }
                }
                goBack()
            } else {
                finish()
            }
        }
        return super.onOptionsItemSelected(menuItem)
    }

    override fun onBackPressed() {
        if (mTagFragments.size > 1) {
            val fragment = fragmentManager.findFragmentByTag(mTagFragments[mTagFragments.size - 1])
            if (fragment is BaseFragment) {
                val base = fragment as BaseFragment
                if (base.onBackPressed()) {
                    return
                }
            }
            mTagFragments.removeAt(mTagFragments.size - 1)
            super.onBackPressed()
        } else {
            finish()
        }
    }

    open fun setupImageToolbar(@DrawableRes resImage: Int, enable: Boolean) {
        supportActionBar?.let {
            it.setHomeAsUpIndicator(resImage)
            it.setDisplayHomeAsUpEnabled(enable)
        }
    }

    open fun setEnableBackToolbar(enable: Boolean) {
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(enable)
            it.setDisplayShowHomeEnabled(enable)
        }
    }

    open fun replaceFragment(fragment: Fragment) {
        pushFragment(fragment, addBackStack = false)
    }

    @JvmOverloads
    open fun pushFragment(fragment: Fragment, container: Int = R.id.container, addBackStack: Boolean = true,
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

    open fun goBack(number: Int) {
        if (number < 1) {
            Log.w("Base", "Invalid number back")
            return
        }
        for (i in 0 until number) {
            goBack()
        }
    }

    open fun goBack() {
        if (mTagFragments.size > 0) {
            mTagFragments.removeAt(mTagFragments.size - 1)
            fragmentManager.popBackStackImmediate()
        }
    }

    open fun showProgressDialog() {
        progressDialog.let {
            progressDialog = SpotsDialog(this, getString(R.string.loading))
            progressDialog?.show()
        }
    }

    open fun dismissProgressDialog() {
        progressDialog?.let {
            it.dismiss()
            progressDialog = null
        }
    }

}