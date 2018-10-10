package com.dartharrmi.aes.pas.borboapp.model

/**
 * @author miguel.arroyo (miguel.arroyo@wavy.global).
 */
data class SupplierOffer(val id: Long = 0,
                         val idSupplier: Long = 0,
                         val idQuotation: Long = 0,
                         val detail: List<SupplierOfferDetail> = emptyList())