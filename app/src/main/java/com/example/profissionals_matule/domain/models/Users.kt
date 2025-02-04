package com.example.profissionals_matule.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Users(
    val user_id: String,
    val email: String,
    val password: String
)
