package edu.ucne.kias_rent_car.domain.repository

import edu.ucne.kias_rent_car.data.remote.Resource
import edu.ucne.kias_rent_car.domain.model.Usuario

interface UsuarioRepository {

    suspend fun login(userName: String, password: String): Resource<Usuario>

    suspend fun registrarUsuario(userName: String, password: String): Resource<Usuario>

    suspend fun verificarUserNameExistente(userName: String): Boolean

    suspend fun obtenerUsuarioPorId(id: Int): Resource<Usuario>
}