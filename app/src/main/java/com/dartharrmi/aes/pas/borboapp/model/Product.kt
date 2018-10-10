package com.dartharrmi.aes.pas.borboapp.model

/**
 * @author miguel.arroyo (miguel.arroyo@wavy.global).
 */
data class Product(val id: Long = 0,
                   val name: String = "",
                   val price: Double = 0.0,
                   val quantity: Long = 0,
                   val idCatalog: Long = 0,
                   val url: String = "",
                   val sku: Sku? = null) {

    constructor(hashMap: HashMap<*, *>) : this(
            hashMap["id"] as Long,
            hashMap["name"] as String,
            (hashMap["price"] as Double),
            (hashMap["quantity"] as Long),
            (hashMap["idCatalog"] as Long),
            (hashMap["url"] as String))
}