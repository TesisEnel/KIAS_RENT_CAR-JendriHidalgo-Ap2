package edu.ucne.kias_rent_car.data.remote.Dto.Reservation

data class ReservationRequest(
    val vehiculoId: Int,
    val usuarioId: String,
    val fechaRecogida: String,
    val horaRecogida: String,
    val fechaDevolucion: String,
    val horaDevolucion: String,
    val lugarRecogida: String,
    val lugarDevolucion: String
)