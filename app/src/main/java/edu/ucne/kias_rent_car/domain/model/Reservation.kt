package edu.ucne.kias_rent_car.domain.model

import java.time.LocalDate
import java.time.LocalTime
import java.util.UUID

data class Reservation(
    val id: String = UUID.randomUUID().toString(),
    val remoteId: Int? = null,
    val vehiculo: Vehicle?,
    val vehiculoId: String,
    val usuarioId: String,
    val fechaRecogida: LocalDate,
    val horaRecogida: LocalTime,
    val fechaDevolucion: LocalDate,
    val horaDevolucion: LocalTime,
    val lugarRecogida: String,
    val lugarDevolucion: String,
    val estado: ReservationStatus,
    val subtotal: Double,
    val impuestos: Double,
    val total: Double,
    val codigoReserva: String? = null,
    val isPendingCreate: Boolean = false,
    val isPendingUpdate: Boolean = false,
    val isPendingDelete: Boolean = false
)

enum class ReservationStatus(val displayName: String) {
    CONFIRMADA("Confirmada"),
    PENDIENTE("Pendiente"),
    EN_PROCESO("En Proceso"),
    FINALIZADA("Finalizada"),
    CANCELADA("Cancelada")
}