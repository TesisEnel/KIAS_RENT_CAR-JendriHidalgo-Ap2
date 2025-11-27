package edu.ucne.kias_rent_car.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import edu.ucne.kias_rent_car.data.repository.VehicleRepositoryImpl
import edu.ucne.kias_rent_car.data.repository.UsuarioRepositoryImpl
import edu.ucne.kias_rent_car.domain.repository.VehicleRepository
import edu.ucne.kias_rent_car.domain.repository.UsuarioRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindVehicleRepository(
        impl: VehicleRepositoryImpl
    ): VehicleRepository

    @Binds
    @Singleton
    abstract fun bindUsuarioRepository(
        impl: UsuarioRepositoryImpl
    ): UsuarioRepository
}