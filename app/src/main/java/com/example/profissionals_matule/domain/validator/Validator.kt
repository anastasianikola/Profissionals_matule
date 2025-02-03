package com.example.profissionals_matule.domain.validator

sealed class ValidationResult {
    object Success : ValidationResult()
    data class Failure(val errorMessage: String) : ValidationResult()
}

interface Validator<T> {
    fun validate(input: T, ): ValidationResult
}