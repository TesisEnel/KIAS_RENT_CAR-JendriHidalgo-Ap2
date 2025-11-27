package edu.ucne.kias_rent_car.data.mappers

import edu.ucne.kias_rent_car.data.entities.VehicleEntity
import edu.ucne.kias_rent_car.data.remote.Dto.Vehicle.VehicleResponse
import edu.ucne.kias_rent_car.domain.model.TransmisionType
import edu.ucne.kias_rent_car.domain.model.Vehicle
import edu.ucne.kias_rent_car.domain.model.VehicleCategory
import java.util.UUID

fun VehicleEntity.toDomain(): Vehicle = Vehicle(
    id = id,
    remoteId = remoteId,
    modelo = modelo,
    descripcion = descripcion,
    categoria = VehicleCategory.valueOf(categoria),
    asientos = asientos,
    transmision = TransmisionType.valueOf(transmision),
    precioPorDia = precioPorDia,
    imagenUrl = imagenUrl,
    disponible = disponible,
    isPendingSync = isPendingSync
)

fun VehicleResponse.toEntity(): VehicleEntity = VehicleEntity(
    id = UUID.randomUUID().toString(),
    remoteId = vehiculoId,
    modelo = modelo,
    descripcion = descripcion,
    categoria = categoria,
    asientos = asientos,
    transmision = transmision,
    precioPorDia = precioPorDia,
    imagenUrl = imagenUrl,
    disponible = disponible
)