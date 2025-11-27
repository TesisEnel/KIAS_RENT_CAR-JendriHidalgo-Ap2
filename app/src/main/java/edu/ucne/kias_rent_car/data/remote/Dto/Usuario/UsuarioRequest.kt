package edu.ucne.kias_rent_car.data.remote.Dto.Usuario

data class UsuarioRequest(
    val usuarioId: Int? = null,
    val userName: String,
    val password: String
)