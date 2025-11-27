package edu.ucne.kias_rent_car.data.repository

import edu.ucne.kias_rent_car.data.dao.VehicleDao
import edu.ucne.kias_rent_car.data.mappers.toDomain
import edu.ucne.kias_rent_car.data.mappers.toEntity
import edu.ucne.kias_rent_car.data.remote.RemoteDataSource.VehicleRemoteDataSource
import edu.ucne.kias_rent_car.data.remote.Resource
import edu.ucne.kias_rent_car.domain.model.Vehicle
import edu.ucne.kias_rent_car.domain.model.VehicleCategory
import edu.ucne.kias_rent_car.domain.repository.VehicleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class VehicleRepositoryImpl @Inject constructor(
    private val localDataSource: VehicleDao,
    private val remoteDataSource: VehicleRemoteDataSource
) : VehicleRepository {

    override fun observeAvailableVehicles(): Flow<List<Vehicle>> {
        return localDataSource.observeAvailableVehicles().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override fun observeVehiclesByCategory(category: VehicleCategory): Flow<List<Vehicle>> {
        return if (category == VehicleCategory.ALL) {
            observeAvailableVehicles()
        } else {
            localDataSource.observeVehiclesByCategory(category.name).map { entities ->
                entities.map { it.toDomain() }
            }
        }
    }

    override fun searchVehicles(query: String): Flow<List<Vehicle>> {
        return localDataSource.searchVehicles(query).map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun getVehicle(id: String): Vehicle? {
        return localDataSource.getVehicle(id)?.toDomain()
    }

    override suspend fun refreshVehicles(): Resource<Unit> {
        return when (val result = remoteDataSource.getVehicles()) {
            is Resource.Success -> {
                result.data.let { vehicles ->
                    val entities = vehicles.map { it.toEntity() }
                    localDataSource.upsertAll(entities)
                }
                Resource.Success(Unit)
            }
            is Resource.Error -> Resource.Error(result.message)
            Resource.Loading -> Resource.Loading
        }
    }
}