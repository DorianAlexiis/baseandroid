package com.android.dars.base

import android.content.Context
import android.os.Bundle
import android.support.annotation.DrawableRes
import android.support.annotation.IdRes
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.ButterKnife

open class BaseFragment: Fragment(){

    open val TRANSACTION_WITHOUT_ANIMATION = 0
    private val HAVE_TOOLBAR = "haveToolbar"

    private var activity: BaseActivity? = null
    protected var haveToolbar:Boolean = false
    private var tvTitle: TextView? = null
    private var mToolbar: Toolbar? = null
    protected var mView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity = getActivity() as BaseActivity
        haveToolbar = savedInstanceState != null && savedInstanceState.getBoolean(HAVE_TOOLBAR)
    }

    open fun getFragmentLayoutResId(): Int = R.layout.fragment_base

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        mView = inflater.inflate(getFragmentLayoutResId(), container, false)
        ButterKnife.bind(this, mView!!)
        if(haveToolbar){
            onCreateToolbar(mView,R.id.toolbar, null)
        }
        return mView
    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        initialize()
    }

    open fun initialize(){

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(HAVE_TOOLBAR, haveToolbar)
    }

    open fun onCreateToolbar(view: View?, @IdRes idToolbar: Int?, toolbar: Toolbar?) : Toolbar? {
        if(view == null){
            return null
        }
        if (toolbar == null) {
            try {
                val id = idToolbar.let { R.id.toolbar }
                mToolbar = view.findViewById<View>(id) as Toolbar
                tvTitle = view.findViewById<View>(R.id.tvTitle) as TextView
                mToolbar?.post {
                    setToolBar(mToolbar)
                    activity?.hideToolbar()
                    haveToolbar = true
                }
            } catch (e: Exception) {
                Log.e(tag , "")
                haveToolbar = false
            }
        } else {
            mToolbar = toolbar
            haveToolbar = true
        }
        if (haveToolbar){
            setEnableBackToolbar(true)
        }
        return mToolbar
    }


    override fun onStart() {
        super.onStart()
        if (haveToolbar){
            activity?.hideToolbar()
        }
    }

    override fun onStop() {
        super.onStop()
        if (haveToolbar && !haveToolbarLastFragment()) {
            activity?.showToolbar()
        }
    }

    open fun setupImageToolbar(@DrawableRes resImage: Int, enable: Boolean) {
        activity?.setupImageToolbar(resImage, enable)
    }

    open fun setupTitleToolbar(title: String) {
        activity?.setTitle(title)
    }


    private fun haveToolbarLastFragment(): Boolean {
        val tag = getLastTagFragment()
        tag?.let {
            val baseFragment = activity?.findFragmentByTag(it)
            return !tag.isEmpty() && baseFragment?.haveToolbar ?: false
        }
        return false
    }

    open fun getLastTagFragment(): String? {
        return activity?.getLastTagFragment()
    }

    open fun setToolBar(toolBar: Toolbar?) {
        val baseActivity = getActivity() as BaseActivity?
        if (baseActivity != null) {
            mToolbar = toolBar
            haveToolbar = true
            (getActivity() as BaseActivity).setSupportActionBar(toolBar)
        }
    }

    open fun setEnableBackToolbar(enable: Boolean) {
        activity?.let {
            it.supportActionBar?.let {
                it.setDisplayHomeAsUpEnabled(enable)
                it.setDisplayShowHomeEnabled(enable)
                it.title = ""
                it.subtitle = ""
            }
        }
    }


    open fun onBackToolbar(): Boolean {
        return false
    }

    open fun onBackPressed(): Boolean {
        return false
    }

    protected fun setTitle(@StringRes resId: Int) {
        setTitle(context?.getString(resId))
    }

    protected fun setTitle(title: String?) {
        if(haveToolbar){
            mToolbar?.post {
                mToolbar?.title = ""
                mToolbar?.subtitle = ""
                tvTitle?.let {
                    it.text = title
                }
            }
        }else{
            title?.let {
                activity?.setTitle(it)
            }
        }
    }

    fun showProgressDialog() {
        activity?.showProgressDialog()
    }

    fun dismissDialog() {
        activity?.dismissProgressDialog()
    }


    open fun goBack(number: Int) {
        activity?.goBack(number)
    }

    open fun goBack() {
        activity?.goBack()
    }

    @JvmOverloads protected fun pushFragment(fragment: Fragment, container: Int= R.id.container,
                               addBackStack: Boolean = true) {
        activity?.pushFragment(fragment, container, addBackStack)
    }

    @JvmOverloads fun replaceFragment(fragment: Fragment, container: Int = R.id.container) {
        activity?.pushFragment(fragment,container = container, addBackStack =  false)
    }

}