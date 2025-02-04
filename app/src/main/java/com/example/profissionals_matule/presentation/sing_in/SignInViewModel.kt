package com.example.profissionals_matule.presentation.sing_in

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.profissionals_matule.data.repository.AuthenticationRepository
import com.example.profissionals_matule.domain.validator.EmailValidator
import com.example.profissionals_matule.domain.validator.PasswordValidator
import com.example.profissionals_matule.domain.validator.ValidationResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

@HiltViewModel
class SignInViewModel @Inject constructor(
    val emailValidator: EmailValidator,
    val passwordValidator: PasswordValidator,
    private val authenticationRepository: AuthenticationRepository
) : ViewModel() {

    private val _emailError = MutableStateFlow<String?>(null)
    val emailError = _emailError.asStateFlow()

    private val _passwordError = MutableStateFlow<String?>(null)
    val passwordError = _passwordError.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    private val _loginError = MutableStateFlow<String?>(null)
    val loginError = _loginError.asStateFlow()

    private val _isSignedIn = MutableStateFlow(false)
    val isSignedIn = _isSignedIn.asStateFlow()

    fun validate(email: String, password: String): Boolean {
        _emailError.value = (emailValidator.validate(email) as? ValidationResult.Failure)?.errorMessage
        _passwordError.value = (passwordValidator.validate(password) as? ValidationResult.Failure)?.errorMessage
        return _emailError.value == null && _passwordError.value == null
    }

    fun signIn(email: String, password: String) {
        if (!validate(email, password)) {
            _loginError.value = "Пожалуйста, исправьте ошибки!"
            return
        }

        viewModelScope.launch {
            _isLoading.value = true
            try {
                val users = authenticationRepository.getUsers() ?: emptyList()
                val user = users.find { it.email == email && it.password == password }

                if (user != null) {
                    _isLoading.value = false
                    _isSignedIn.value = true
                } else {
                    _isLoading.value = false
                    _loginError.value = "Не правильная почта или пароль!"
                }
            } catch (e: Exception) {
                _isLoading.value = false
                _loginError.value = "Ошибка соеденинения! Пожадуйста, проверьте подключение!"
            }
        }
    }
}
