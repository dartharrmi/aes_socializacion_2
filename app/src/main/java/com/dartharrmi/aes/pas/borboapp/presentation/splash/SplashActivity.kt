package com.dartharrmi.aes.pas.borboapp.presentation.splash

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.dartharrmi.aes.pas.borboapp.R
import com.dartharrmi.aes.pas.borboapp.model.Product
import com.dartharrmi.aes.pas.borboapp.presentation.base.AbstractActivity
import com.dartharrmi.aes.pas.borboapp.presentation.splash.adapter.ProductsAdapter
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject

class SplashActivity : AbstractActivity<SplashContract.Presenter, SplashActivity>(), SplashContract.View {

    @Inject
    override lateinit var mPresenter: SplashContract.Presenter

    private lateinit var mAdapter: ProductsAdapter
    private lateinit var mHistoryListManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        mHistoryListManager = LinearLayoutManager(this)
        historyListRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = mHistoryListManager
            adapter = mAdapter
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
}
