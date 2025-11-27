package edu.ucne.kias_rent_car.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import edu.ucne.kias_rent_car.data.dao.ReservationDao
import edu.ucne.kias_rent_car.data.dao.VehicleDao
import edu.ucne.kias_rent_car.data.entities.ReservationEntity
import edu.ucne.kias_rent_car.data.entities.VehicleEntity

@Database(
    entities = [VehicleEntity::class,
        ReservationEntity::class],
    version = 2,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun vehicleDao(): VehicleDao
    abstract fun reservationDao(): ReservationDao
}