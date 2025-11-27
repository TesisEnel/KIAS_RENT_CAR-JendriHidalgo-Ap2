package edu.ucne.kias_rent_car.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import edu.ucne.kias_rent_car.data.entities.VehicleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface VehicleDao {
    @Query("SELECT * FROM vehiculos WHERE disponible = 1")
    fun observeAvailableVehicles(): Flow<List<VehicleEntity>>

    @Query("SELECT * FROM vehiculos")
    fun observeAllVehicles(): Flow<List<VehicleEntity>>

    @Query("SELECT * FROM vehiculos WHERE id = :id")
    suspend fun getVehicle(id: String): VehicleEntity?

    @Query("SELECT * FROM vehiculos WHERE categoria = :categoria AND disponible = 1")
    fun observeVehiclesByCategory(categoria: String): Flow<List<VehicleEntity>>

    @Query("SELECT * FROM vehiculos WHERE modelo LIKE '%' || :query || '%'")
    fun searchVehicles(query: String): Flow<List<VehicleEntity>>

    @Upsert
    suspend fun upsert(vehicle: VehicleEntity)

    @Upsert
    suspend fun upsertAll(vehicles: List<VehicleEntity>)

    @Query("DELETE FROM vehiculos WHERE id = :id")
    suspend fun delete(id: String)

    @Query("SELECT * FROM vehiculos WHERE isPendingSync = 1")
    suspend fun getPendingSyncVehicles(): List<VehicleEntity>
}