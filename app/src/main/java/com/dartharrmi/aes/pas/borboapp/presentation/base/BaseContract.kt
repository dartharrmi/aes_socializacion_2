package com.dartharrmi.aes.pas.borboapp.presentation.base

import android.support.annotation.StringRes

/**
 * Base contract between the view and the presenter.
 */
@Suppress("UNUSED")
interface BaseContract {

    interface BaseView {
        fun showLoadingDialog(@StringRes stringId: Int)

        fun hideLoadingDialog()
    }

    interface BasePresenter<in T : BaseView> {
        fun attachView(view: T)

        fun detachView()
    }
}