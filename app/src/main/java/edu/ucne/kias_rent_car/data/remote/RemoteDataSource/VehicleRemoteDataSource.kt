package edu.ucne.kias_rent_car.data.remote.datasource

import edu.ucne.kias_rent_car.data.remote.ApiService
import edu.ucne.kias_rent_car.data.remote.Dto.VehicleDtos.VehiculoDto
import edu.ucne.kias_rent_car.data.remote.Dto.VehicleDtos.VehiculoRequest
import javax.inject.Inject

class VehiculoRemoteDataSource @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getVehiculosDisponibles(): List<VehiculoDto>? {
        return try {
            val response = apiService.getVehiculosDisponibles()
            if (response.isSuccessful) response.body() else null
        } catch (e: Exception) {
            null
        }
    }

    suspend fun getAllVehiculos(): List<VehiculoDto>? {
        return try {
            val response = apiService.getAllVehiculos()
            if (response.isSuccessful) response.body() else null
        } catch (e: Exception) {
            null
        }
    }
    suspend fun getVehiculoById(id: Int): VehiculoDto? {
        return try {
            val response = apiService.getVehiculoById(id)
            if (response.isSuccessful) response.body() else null
        } catch (e: Exception) {
            null
        }
    }
    suspend fun createVehiculo(
        modelo: String,
        descripcion: String,
        precioPorDia: Double,
        imagenUrl: String
    ): VehiculoDto? {
        return try {
            val request = VehiculoRequest(
                modelo = modelo,
                descripcion = descripcion,
                categoria = "SUV",
                asientos = 5,
                transmision = "Automatic",
                precioPorDia = precioPorDia,
                imagenUrl = imagenUrl
            )
            val response = apiService.createVehiculo(request)
            if (response.isSuccessful) response.body() else null
        } catch (e: Exception) {
            null
        }
    }
    suspend fun updateVehiculo(
        id: Int,
        modelo: String,
        descripcion: String,
        precioPorDia: Double,
        imagenUrl: String
    ): Boolean {
        return try {
            val request = VehiculoRequest(
                modelo = modelo,
                descripcion = descripcion,
                categoria = "SUV",
                asientos = 5,
                transmision = "Automatic",
                precioPorDia = precioPorDia,
                imagenUrl = imagenUrl
            )
            val response = apiService.updateVehiculo(id, request)
            response.isSuccessful
        } catch (e: Exception) {
            false
        }
    }
    suspend fun deleteVehiculo(id: Int): Boolean {
        return try {
            val response = apiService.deleteVehiculo(id)
            response.isSuccessful
        } catch (e: Exception) {
            false
        }
    }
}