package com.dartharrmi.aes.pas.borboapp.presentation.base

import io.reactivex.disposables.CompositeDisposable

/**
 * Base implementation for Presenters.
 */
abstract class AbstractPresenter<T : BaseContract.BaseView> : BaseContract.BasePresenter<T> {

    protected var mView: T? = null
    protected val mCompositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun attachView(view: T) {
        mView = view
    }

    override fun detachView() {
        if (!mCompositeDisposable.isDisposed) {
            mCompositeDisposable.dispose()
        }

        mView = null
    }
}