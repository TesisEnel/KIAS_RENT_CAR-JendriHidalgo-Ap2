package edu.ucne.kias_rent_car.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "Reservaciones")
data class ReservationEntity(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val remoteId: Int? = null,
    val vishuloId: String,
    val usuarioId: String,
    val fechaRecogida: Long,
    val horaRecogida: String,
    val fechaDevolucion: Long,
    val horaDevolucion: String,
    val lugarRecogida: String,
    val lugarDevolucion: String,
    val estado: String, // Confirmada, Pendiente, Cancelada, Finalizada
    val subtotal: Double,
    val impuestos: Double,
    val total: Double,
    val codigoReserva: String? = null,
    val isPendingCreate: Boolean = false,
    val isPendingUpdate: Boolean = false,
    val isPendingDelete: Boolean = false
)