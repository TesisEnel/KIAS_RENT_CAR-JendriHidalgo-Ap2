package edu.ucne.kias_rent_car.presentation.LoginTareas

sealed class LoginUiEvent {

    data class UserNameChanged(val userName: String) : LoginUiEvent()

    data class PasswordChanged(val password: String) : LoginUiEvent()

    data object Login : LoginUiEvent()

    data object RegisterClick : LoginUiEvent()

    data object DismissRegisterDialog : LoginUiEvent()

    data object TogglePasswordVisibility : LoginUiEvent()

    data object ClearError : LoginUiEvent()
}