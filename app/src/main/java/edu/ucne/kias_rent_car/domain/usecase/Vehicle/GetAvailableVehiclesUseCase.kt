package edu.ucne.kias_rent_car.domain.usecase.Vehicle

import edu.ucne.kias_rent_car.domain.model.Vehicle
import edu.ucne.kias_rent_car.domain.repository.VehicleRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAvailableVehiclesUseCase @Inject constructor(
    private val repo: VehicleRepository
) {
    operator fun invoke(): Flow<List<Vehicle>> = repo.observeAvailableVehicles()
}