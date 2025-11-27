package edu.ucne.kias_rent_car.domain.model

import java.util.UUID

data class Vehicle(
    val id: String = UUID.randomUUID().toString(),
    val remoteId: Int? = null,
    val modelo: String,
    val descripcion: String,
    val categoria: VehicleCategory,
    val asientos: Int,
    val transmision: TransmisionType,
    val precioPorDia: Double,
    val imagenUrl: String,
    val disponible: Boolean = true,
    val isPendingSync: Boolean = false
)

enum class VehicleCategory(val displayName: String) {
    ALL("All"),
    SUV("SUV"),
    SEDAN("Sedan"),
    COMPACT("Compact"),
    LUXURY("Luxury")
}

enum class TransmisionType(val displayName: String) {
    AUTOMATIC("Automatic"),
    MANUAL("Manual")
}