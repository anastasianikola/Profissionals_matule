package com.example.profissionals_matule.data.repository

import com.example.profissionals_matule.data.models.UsersDto
import com.example.profissionals_matule.domain.models.Users
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.query.Columns
import io.github.jan.supabase.postgrest.query.filter.FilterOperator
import io.github.jan.supabase.storage.Storage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthenticationRepositoryImpl @Inject constructor(
    private val postgrest: Postgrest
) : AuthenticationRepository {

    override suspend fun getUsers(): List<UsersDto>? {
        return withContext(Dispatchers.IO){
            val result = postgrest.from("users")
                .select().decodeList<UsersDto>()
            result
        }
    }

    override suspend fun getUser(user_id: String): UsersDto{
        return withContext(Dispatchers.IO){
            postgrest.from("users").select {
                filter {
                    eq("user_id", user_id)
                }
            }.decodeSingle<UsersDto>()
        }
    }
}