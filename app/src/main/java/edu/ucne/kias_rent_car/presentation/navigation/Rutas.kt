package edu.ucne.kias_rent_car.presentation.navigation

import kotlinx.serialization.Serializable

// ========== AUTH ==========
@Serializable
object LoginRoute

@Serializable
object RegistroRoute

// ========== CLIENTE ==========
@Serializable
object HomeRoute

@Serializable
data class VehicleDetailRoute(val vehicleId: String)

@Serializable
object BookingsRoute

@Serializable
data class BookingDetailRoute(val bookingId: String)

@Serializable
data class ReservationConfigRoute(val vehicleId: String)

@Serializable
data class PaymentRoute(
    val vehicleId: String,
    val pickupDate: String,
    val pickupTime: String,
    val returnDate: String,
    val returnTime: String,
    val pickupLocation: String,
    val returnLocation: String,
    val total: Double
)

@Serializable
data class ReservationConfirmationRoute(val reservationId: String)

@Serializable
object ReservationSuccessRoute

@Serializable
object SupportRoute

@Serializable
object ProfileRoute