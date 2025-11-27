package edu.ucne.kias_rent_car.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import edu.ucne.kias_rent_car.data.entities.ReservationEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ReservationDao {
    @Query("SELECT * FROM reservaciones WHERE usuarioId = :userId ORDER BY fechaRecogida DESC")
    fun observeUserReservations(userId: String): Flow<List<ReservationEntity>>

    @Query("SELECT * FROM reservaciones WHERE usuarioId = :userId AND estado IN ('Confirmada', 'Pendiente')")
    fun observeActiveReservations(userId: String): Flow<List<ReservationEntity>>

    @Query("SELECT * FROM reservaciones WHERE usuarioId = :userId AND estado = 'Finalizada'")
    fun observePastReservations(userId: String): Flow<List<ReservationEntity>>

    @Query("SELECT * FROM reservaciones WHERE id = :id")
    suspend fun getReservation(id: String): ReservationEntity?

    @Upsert
    suspend fun upsert(reservation: ReservationEntity)

    @Query("DELETE FROM reservaciones WHERE id = :id")
    suspend fun delete(id: String)

    @Query("SELECT * FROM reservaciones WHERE isPendingCreate = 1")
    suspend fun getPendingCreateReservations(): List<ReservationEntity>

    @Query("SELECT * FROM reservaciones WHERE isPendingUpdate = 1")
    suspend fun getPendingUpdateReservations(): List<ReservationEntity>

    @Query("SELECT * FROM reservaciones WHERE isPendingDelete = 1")
    suspend fun getPendingDeleteReservations(): List<ReservationEntity>
}