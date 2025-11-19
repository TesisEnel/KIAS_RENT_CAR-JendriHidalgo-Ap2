package edu.ucne.kias_rent_car.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.ucne.kias_rent_car.data.remote.Resource
import edu.ucne.kias_rent_car.domain.usecase.RegistrarUsuarioUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistroViewModel @Inject constructor(
    private val registrarUsuarioUseCase: RegistrarUsuarioUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(RegistroUiState())
    val state: StateFlow<RegistroUiState> = _state.asStateFlow()

    fun updateUserName(userName: String) {
        _state.update { it.copy(userName = userName, error = null) }
    }

    fun updatePassword(password: String) {
        _state.update { it.copy(password = password, error = null) }
    }

    fun updateConfirmPassword(confirmPassword: String) {
        _state.update { it.copy(confirmPassword = confirmPassword, error = null) }
    }

    fun togglePasswordVisibility() {
        _state.update { it.copy(passwordVisible = !it.passwordVisible) }
    }

    fun registrar() {
        val currentState = _state.value

        if (!currentState.esFormularioValido()) {
            _state.update {
                it.copy(error = "Por favor completa todos los campos correctamente")
            }
            return
        }

        if (currentState.password != currentState.confirmPassword) {
            _state.update { it.copy(error = "Las contraseñas no coinciden") }
            return
        }

        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }

            val resultado = registrarUsuarioUseCase(
                userName = currentState.userName,
                password = currentState.password
            )

            _state.update {
                when (resultado) {
                    is Resource.Success -> {
                        it.copy(
                            isLoading = false,
                            registroExitoso = true,
                            error = null
                        )
                    }
                    is Resource.Error -> {
                        it.copy(
                            isLoading = false,
                            error = resultado.message
                        )
                    }
                    is Resource.Loading -> {
                        it.copy(isLoading = true)
                    }
                }
            }
        }
    }
}
