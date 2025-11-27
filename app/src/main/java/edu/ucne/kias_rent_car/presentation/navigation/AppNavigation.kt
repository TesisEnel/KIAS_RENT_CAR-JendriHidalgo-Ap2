package edu.ucne.kias_rent_car.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import edu.ucne.kias_rent_car.presentation.LoginTareas.LoginScreen
import edu.ucne.kias_rent_car.presentation.LoginTareas.RegistroScreen
import edu.ucne.kias_rent_car.presentation.HomeClienteTareas.HomeScreen
import edu.ucne.kias_rent_car.presentation.navigation.*

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = LoginRoute
    ) {
        // ==================== AUTH ====================
        composable<LoginRoute> {
            LoginScreen(
                onLoginExitoso = {
                    navController.navigate(HomeRoute) {
                        popUpTo(LoginRoute) { inclusive = true }
                    }
                },
                onNavigateToRegistro = {
                    navController.navigate(RegistroRoute)
                }
            )
        }

        composable<RegistroRoute> {
            RegistroScreen(
                onRegistroExitoso = {
                    navController.popBackStack()
                },
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }

        // ==================== HOME ====================
        composable<HomeRoute> {
            HomeScreen(
                onNavigateToVehicleDetail = { vehicleId ->
                    navController.navigate(VehicleDetailRoute(vehicleId))
                }
            )
        }
    }
}