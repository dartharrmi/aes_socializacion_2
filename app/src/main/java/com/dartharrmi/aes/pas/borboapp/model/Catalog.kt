package com.dartharrmi.aes.pas.borboapp.model

/**
 * @author miguel.arroyo (miguel.arroyo@wavy.global).
 */
data class Catalog(val id: Long = 0,
                   val name: String = "",
                   val products: List<Product> = emptyList(),
                   val idSupplier: Long = 0)