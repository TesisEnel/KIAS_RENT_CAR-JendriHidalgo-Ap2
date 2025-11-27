package edu.ucne.kias_rent_car.data.remote

import edu.ucne.kias_rent_car.data.remote.Dto.Reservation.ReservationRequest
import edu.ucne.kias_rent_car.data.remote.Dto.Reservation.ReservationResponse
import edu.ucne.kias_rent_car.data.remote.Dto.Usuario.UsuarioRequest
import edu.ucne.kias_rent_car.data.remote.Dto.Usuario.UsuarioResponse
import edu.ucne.kias_rent_car.data.remote.Dto.Vehicle.VehicleResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {
    // Vehicles
    @GET("api/vehicles")
    suspend fun getVehicles(): Response<List<VehicleResponse>>

    @GET("api/vehicles/{id}")
    suspend fun getVehicle(@Path("id") id: Int): Response<VehicleResponse>

    @GET("api/vehicles/category/{category}")
    suspend fun getVehiclesByCategory(@Path("category") category: String): Response<List<VehicleResponse>>

    // Reservations
    @POST("api/reservations")
    suspend fun createReservation(@Body request: ReservationRequest): Response<ReservationResponse>

    @PUT("api/reservations/{id}")
    suspend fun updateReservation(@Path("id") id: Int, @Body request: ReservationRequest): Response<ReservationResponse>

    @DELETE("api/reservations/{id}")
    suspend fun cancelReservation(@Path("id") id: Int): Response<Unit>

    @GET("api/reservations/user/{userId}")
    suspend fun getUserReservations(@Path("userId") userId: String): Response<List<ReservationResponse>>
}