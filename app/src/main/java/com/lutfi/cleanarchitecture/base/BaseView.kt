package com.lutfi.cleanarchitecture.base

import androidx.appcompat.widget.Toolbar

/**
 *created by Lutfi Rizky Ramadhan on 09/05/20
 */

interface BaseView {

    fun setupToolbar(toolbar: Toolbar?, title: String, isChild: Boolean)

    fun showMessage(message: String)

}