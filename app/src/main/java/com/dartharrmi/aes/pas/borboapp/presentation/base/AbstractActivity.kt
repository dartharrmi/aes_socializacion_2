package com.dartharrmi.aes.pas.borboapp.presentation.base

import android.app.Activity
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager
import com.dartharrmi.aes.pas.borboapp.presentation.dialogs.LoadingDialog
import dagger.android.AndroidInjection

/**
 * Base implementation for Activities.
 */
abstract class AbstractActivity<out T : BaseContract.BasePresenter<V>, in V : BaseContract.BaseView> : AppCompatActivity(), BaseContract.BaseView {

    abstract val mPresenter: T
    private lateinit var loadingDialog: LoadingDialog

    @Suppress("UNCHECKED_CAST")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)

        mPresenter.attachView(this as V)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }

    override fun showLoadingDialog(@StringRes stringId: Int) {
        val arguments = Bundle()
        arguments.putString(LoadingDialog.KEY_LABEL, getString(stringId))

        loadingDialog = LoadingDialog.newInstance(arguments)
        loadingDialog.isCancelable = false
        loadingDialog.show(this.supportFragmentManager, LoadingDialog.FRAGMENT_TAG)
    }

    override fun hideLoadingDialog() {
        loadingDialog.dismissAllowingStateLoss()
    }

    fun hideKeyboard() {
        if (currentFocus != null) {
            val imm = this.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager?
            imm?.hideSoftInputFromWindow(currentFocus.windowToken, 0)
        }
    }
}