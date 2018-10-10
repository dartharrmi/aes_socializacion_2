package com.dartharrmi.aes.pas.borboapp.model

/**
 * @author miguel.arroyo (miguel.arroyo@wavy.global).
 */
data class ClientRequest(val id: Long = 0,
                         val idClient: Long = 0,
                         val products: List<Product> = emptyList(),
                         val status: Status = Status.CREATED) {

    enum class Status {
        CREATED,
        OFFERED,
        ACCEPTED,
        DECLINED
    }
}