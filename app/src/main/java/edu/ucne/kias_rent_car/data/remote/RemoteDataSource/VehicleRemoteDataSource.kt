package edu.ucne.kias_rent_car.data.remote.RemoteDataSource

import edu.ucne.kias_rent_car.data.remote.ApiService
import edu.ucne.kias_rent_car.data.remote.Dto.Vehicle.VehicleResponse
import edu.ucne.kias_rent_car.data.remote.Resource
import javax.inject.Inject

class VehicleRemoteDataSource @Inject constructor(
    private val api: ApiService
) {
    suspend fun getVehicles(): Resource<List<VehicleResponse>> {
        return try {
            val response = api.getVehicles()
            if (response.isSuccessful) {
                response.body()?.let { Resource.Success(it) }
                    ?: Resource.Error("Respuesta vacía del servidor")
            } else {
                Resource.Error("HTTP ${response.code()} ${response.message()}")
            }
        } catch (e: Exception) {
            Resource.Error(e.localizedMessage ?: "Error de red")
        }
    }

    suspend fun getVehicle(id: Int): Resource<VehicleResponse> {
        return try {
            val response = api.getVehicle(id)
            if (response.isSuccessful) {
                response.body()?.let { Resource.Success(it) }
                    ?: Resource.Error("Vehículo no encontrado")
            } else {
                Resource.Error("HTTP ${response.code()} ${response.message()}")
            }
        } catch (e: Exception) {
            Resource.Error(e.localizedMessage ?: "Error de red")
        }
    }

    suspend fun getVehiclesByCategory(category: String): Resource<List<VehicleResponse>> {
        return try {
            val response = api.getVehiclesByCategory(category)
            if (response.isSuccessful) {
                response.body()?.let { Resource.Success(it) }
                    ?: Resource.Error("Respuesta vacía del servidor")
            } else {
                Resource.Error("HTTP ${response.code()} ${response.message()}")
            }
        } catch (e: Exception) {
            Resource.Error(e.localizedMessage ?: "Error de red")
        }
    }
}