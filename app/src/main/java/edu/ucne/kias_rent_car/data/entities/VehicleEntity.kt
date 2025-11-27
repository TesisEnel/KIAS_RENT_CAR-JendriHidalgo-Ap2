package edu.ucne.kias_rent_car.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "Vehiculos")
data class VehicleEntity(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val remoteId: Int? = null,
    val modelo: String,
    val descripcion: String,
    val categoria: String, // SUV, Sedan, Compact, Luxury
    val asientos: Int,
    val transmision: String, // Automatic, Manual
    val precioPorDia: Double,
    val imagenUrl: String,
    val disponible: Boolean = true,
    val isPendingSync: Boolean = false
)