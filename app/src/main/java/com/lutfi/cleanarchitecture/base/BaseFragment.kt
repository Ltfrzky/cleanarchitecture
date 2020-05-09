package com.lutfi.cleanarchitecture.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

/**
 *created by Lutfi Rizky Ramadhan on 09/05/20
 */

abstract class BaseFragment(private val layoutResource: Int): Fragment(), BaseView {

    private var baseActivity: BaseActivity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutResource, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initIntent(savedInstanceState)
        initUI()
        initAction()
        initProcess()
        initObserver()
    }

    override fun setupToolbar(toolbar: Toolbar?, title: String, isChild: Boolean) {
        baseActivity?.setupToolbar(toolbar, title, isChild)
    }

    override fun showMessage(message: String) {
        baseActivity?.showMessage(message)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity) {
            val activity = context as BaseActivity?
            this.baseActivity = activity
        }
    }

    protected abstract fun initObserver()

    protected abstract fun initIntent(savedInstanceState: Bundle?)

    protected abstract fun initUI()

    protected abstract fun initAction()

    protected abstract fun initProcess()
}