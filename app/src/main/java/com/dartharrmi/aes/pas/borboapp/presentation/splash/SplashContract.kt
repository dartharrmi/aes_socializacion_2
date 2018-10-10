package com.dartharrmi.aes.pas.borboapp.presentation.splash

import com.dartharrmi.aes.pas.borboapp.model.Product
import com.dartharrmi.aes.pas.borboapp.presentation.base.BaseContract

/**
 * @author miguel.arroyo (miguel.arroyo@wavy.global).
 */
interface SplashContract {

    interface View: BaseContract.BaseView {

        fun showProducts(products: List<Product>)
    }

    interface Presenter: BaseContract.BasePresenter<View> {

        fun getProducts()
    }
}