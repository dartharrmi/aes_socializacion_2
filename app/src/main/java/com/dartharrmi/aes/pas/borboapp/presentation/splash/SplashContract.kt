package com.dartharrmi.aes.pas.borboapp.presentation.splash

import android.support.annotation.StringRes
import com.dartharrmi.aes.pas.borboapp.model.ClientRequest
import com.dartharrmi.aes.pas.borboapp.model.Product
import com.dartharrmi.aes.pas.borboapp.presentation.base.BaseContract

/**
 * @author miguel.arroyo (miguel.arroyo@wavy.global).
 */
interface SplashContract {

    interface View: BaseContract.BaseView {

        fun showProducts(products: List<Product>)

        fun showRequestConfirmation(@StringRes stringId: Int)
    }

    interface Presenter: BaseContract.BasePresenter<View> {

        fun getProducts()

        fun createClientRequest(clientRequest: ClientRequest)
    }
}