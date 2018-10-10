package com.dartharrmi.aes.pas.borboapp.model

/**
 * @author miguel.arroyo (miguel.arroyo@wavy.global).
 */
data class User(val id: Long = 0,
                val firstName: String = "",
                val lastName: String = "",
                val email: String = "",
                val userType: UserType = UserType.CLIENT) {

    enum class UserType {
        CLIENT,
        SUPPLIER
    }
}