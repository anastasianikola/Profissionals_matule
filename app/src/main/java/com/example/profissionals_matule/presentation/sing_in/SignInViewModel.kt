package com.example.profissionals_matule.presentation.sing_in

import androidx.lifecycle.ViewModel
import com.example.profissionals_matule.domain.validator.EmailValidator
import com.example.profissionals_matule.domain.validator.PasswordValidator
import com.example.profissionals_matule.domain.validator.ValidationResult
import com.example.profissionals_matule.domain.validator.Validator
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val emailValidator: EmailValidator,
    private val passwordValidator: PasswordValidator
): ViewModel() {
     var emailError: String? = null
    var passwordError: String? = null

    fun validate(email: String, password: String): Boolean {
        when (emailValidator.validate(email)) {
            is ValidationResult.Success -> emailError = null
            is ValidationResult.Failure -> {
                emailError =
                    (emailValidator.validate(email) as ValidationResult.Failure).errorMessage
                return false
            }
        }
        when (passwordValidator.validate(password)) {
            is ValidationResult.Success -> passwordError = null
            is ValidationResult.Failure -> {
                passwordError =
                    (passwordValidator.validate(password) as ValidationResult.Failure).errorMessage
                return false
            }
        }
        return true
    }
}