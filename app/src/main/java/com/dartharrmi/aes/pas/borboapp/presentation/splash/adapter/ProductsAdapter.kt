package com.dartharrmi.aes.pas.borboapp.presentation.splash.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.dartharrmi.aes.pas.borboapp.R
import com.dartharrmi.aes.pas.borboapp.model.Product
import kotlinx.android.synthetic.main.layout_product_item.view.*

/**
 * @author miguel.arroyo (miguel.arroyo@wavy.global).
 */
class ProductsAdapter(private val context: Context,
                      private val productOperations: ProductOperations? = null,
                      private val sessionsList: MutableList<Product> = mutableListOf()) : RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {

    interface ProductOperations {

        fun onProductSelected(isChecked: Boolean, product: Product)
    }

    override fun getItemCount(): Int {
        return sessionsList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_product_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = sessionsList[position]

        holder.productItemTextView.text = product.name
        Glide.with(context)
                .load(product.url)
                .into(holder.productItemImageView)
        holder.productItemCheckBox.setOnCheckedChangeListener { _, isChecked ->
            productOperations?.onProductSelected(isChecked, product)
        }
    }

    fun addSessions(list: List<Product>) {
        var changed = false
        // This manual check instead of a Set to have a better performance getting the elements for the ViewHolder
        list.forEach {
            if (!sessionsList.contains(it)) {
                sessionsList.add(it)
                changed = true
            }
        }
        if (changed) {
            notifyDataSetChanged()
        }
    }

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val productItemImageView: ImageView = item.itemProductImage
        val productItemTextView: TextView = item.itemProductName
        val productItemCheckBox: CheckBox = item.itemProductSelected
    }
}