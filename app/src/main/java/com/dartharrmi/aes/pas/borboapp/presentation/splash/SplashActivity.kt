package com.dartharrmi.aes.pas.borboapp.presentation.splash

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.dartharrmi.aes.pas.borboapp.R
import com.dartharrmi.aes.pas.borboapp.model.ClientRequest
import com.dartharrmi.aes.pas.borboapp.model.Product
import com.dartharrmi.aes.pas.borboapp.presentation.base.AbstractActivity
import com.dartharrmi.aes.pas.borboapp.presentation.splash.SplashContract.View
import com.dartharrmi.aes.pas.borboapp.presentation.splash.adapter.ProductsAdapter
import com.dartharrmi.aes.pas.borboapp.presentation.splash.adapter.ProductsAdapter.ProductOperations
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class SplashActivity : AbstractActivity<SplashContract.Presenter, SplashActivity>(), View, ProductOperations {

    @Inject
    override lateinit var mPresenter: SplashContract.Presenter

    private lateinit var mAdapter: ProductsAdapter
    private lateinit var mHistoryListManager: RecyclerView.LayoutManager

    private val selectedProducts: MutableList<Product> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        mAdapter = ProductsAdapter(this, productOperations = this)
        mHistoryListManager = LinearLayoutManager(this)
        productListRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = mHistoryListManager
            adapter = mAdapter
        }

        productListSave.setOnClickListener {
            mPresenter.createClientRequest(ClientRequest(System.currentTimeMillis(), 100, selectedProducts))
        }
    }

    override fun onResume() {
        super.onResume()
        if (mAdapter.itemCount == 0) {
            mPresenter.getProducts()
        }
    }

    override fun showProducts(products: List<Product>) {
        mAdapter.addSessions(products)
    }

    override fun onProductSelected(isChecked: Boolean, product: Product) {
        if (isChecked) {
            selectedProducts.add(product)
        } else {
            selectedProducts.remove(product)
        }

        if (selectedProducts.isEmpty()) {
            productListSave.hide()
        } else {
            productListSave.show()
        }
    }

    override fun showRequestConfirmation(stringId: Int) {
        Snackbar.make(productListRecyclerView, stringId, Snackbar.LENGTH_LONG).show()
    }
}
