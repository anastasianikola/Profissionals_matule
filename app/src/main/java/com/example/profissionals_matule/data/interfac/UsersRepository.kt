package com.example.profissionals_matule.data.interfac

import com.example.profissionals_matule.data.models.UsersDto

interface UsersRepository {
    suspend fun getUsers(): List<UsersDto>?
    suspend fun getUser(user_id: String): UsersDto
}