package com.example.profissionals_matule.domain.validator

import android.util.Patterns
import org.intellij.lang.annotations.Pattern

class EmailValidator: Validator<String>{
    override fun validate(input: String): ValidationResult{
        return if(input.isBlank())
            ValidationResult.Failure("Поле Email не должно быть пустым!")
        else if(!Patterns.EMAIL_ADDRESS.matcher(input).matches())
            ValidationResult.Failure("Неверный формат Email!")
        else
            ValidationResult.Success
    }
}

class PasswordValidator: Validator<String>{
    override fun validate(input: String): ValidationResult{
        return if(input.isBlank())
            ValidationResult.Failure("Поле Пароль не должно быть пустым!")
        else if(input.length < 8)
            ValidationResult.Failure("Пароль должен быть больше 8 символов!")
        else
            ValidationResult.Success
    }
}
