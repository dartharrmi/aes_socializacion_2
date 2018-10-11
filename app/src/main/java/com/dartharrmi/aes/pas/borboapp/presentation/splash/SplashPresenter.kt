package com.dartharrmi.aes.pas.borboapp.presentation.splash

import android.annotation.SuppressLint
import com.dartharrmi.aes.pas.borboapp.R
import com.dartharrmi.aes.pas.borboapp.managers.FirebaseDatabaseManager
import com.dartharrmi.aes.pas.borboapp.model.ClientRequest
import com.dartharrmi.aes.pas.borboapp.presentation.base.AbstractPresenter
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author miguel.arroyo (miguel.arroyo@wavy.global).
 */
@Singleton
@SuppressLint("CheckResult")
class SplashPresenter @Inject constructor(private val firebaseDatabaseManager: FirebaseDatabaseManager) :
        AbstractPresenter<SplashContract.View>(), SplashContract.Presenter {

    override fun getProducts() {
        mView?.showLoadingDialog(R.string.app_name)
        firebaseDatabaseManager.fetchProducts().subscribe({
            if (it.isNotEmpty()) {
                mView?.hideLoadingDialog()
                mView?.showProducts(it)
            }
        }, {
        })
    }

    override fun createClientRequest(clientRequest: ClientRequest) {
        mView?.showLoadingDialog(R.string.app_name)

        firebaseDatabaseManager.createClientRequest(clientRequest).subscribe({
            mView?.hideLoadingDialog()
            if (it) {
                mView?.showRequestConfirmation(R.string.app_name)
            }
        }, {

        })
    }
}