package com.example.profissionals_matule.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UsersDto (
    @SerialName("user_id")
    val user_is: Int,
    @SerialName("email")
    val email: String,
    @SerialName("password")
    val password: String,
)