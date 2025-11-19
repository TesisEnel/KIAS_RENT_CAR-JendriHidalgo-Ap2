package edu.ucne.kias_rent_car.domain.usecase

import edu.ucne.kias_rent_car.data.remote.Resource
import edu.ucne.kias_rent_car.domain.model.Usuario
import edu.ucne.kias_rent_car.domain.repository.UsuarioRepository
import javax.inject.Inject

class RegistrarUsuarioUseCase @Inject constructor(
    private val usuarioRepository: UsuarioRepository
) {
    suspend operator fun invoke(userName: String, password: String): Resource<Usuario> {
        return usuarioRepository.registrarUsuario(userName.trim(), password)
    }
}