package com.example.profissionals_matule.data.repository

import com.example.profissionals_matule.data.models.UsersDto

interface AuthenticationRepository {
    suspend fun getUsers(): List<UsersDto>?
    suspend fun getUser(user_id: String): UsersDto
}