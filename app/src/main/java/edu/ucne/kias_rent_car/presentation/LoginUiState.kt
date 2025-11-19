package edu.ucne.kias_rent_car.presentation

import edu.ucne.kias_rent_car.domain.model.Usuario

data class LoginUIState(
    val userName: String = "",
    val password: String = "",
    val passwordVisible: Boolean = false,
    val isLoading: Boolean = false,
    val error: String? = null,
    val loginExitoso: Usuario? = null,
    val mostrarDialogoRegistro: Boolean = false
) {
    fun esFormularioValido(): Boolean {
        return userName.isNotBlank() && password.isNotBlank()
    }
}