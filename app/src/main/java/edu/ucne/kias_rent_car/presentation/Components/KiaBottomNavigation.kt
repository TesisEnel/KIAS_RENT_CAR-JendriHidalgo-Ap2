package edu.ucne.kias_rent_car.presentation.Components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import edu.ucne.kias_rent_car.presentation.LoginTareas.onErrorDark
import edu.ucne.kias_rent_car.ui.theme.scrimDark
import edu.ucne.kias_rent_car.ui.theme.scrimDarkHighContrast
import edu.ucne.kias_rent_car.ui.theme.scrimLight
import edu.ucne.kias_rent_car.ui.theme.surfaceBrightDark

@Composable
fun KiaBottomNavigation(
    currentRoute: String,
    onNavigate: (String) -> Unit
) {
    NavigationBar(
        containerColor = scrimDark
    ) {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Home") },
            selected = currentRoute == "home",
            onClick = { onNavigate("home") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = onErrorDark,
                selectedTextColor = onErrorDark,
                unselectedIconColor = surfaceBrightDark,
                unselectedTextColor = surfaceBrightDark,
                indicatorColor = scrimDark
            )
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.DateRange, contentDescription = "Bookings") },
            label = { Text("Bookings") },
            selected = currentRoute == "bookings",
            onClick = { onNavigate("bookings") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = onErrorDark,
                selectedTextColor = onErrorDark,
                unselectedIconColor = surfaceBrightDark,
                unselectedTextColor = surfaceBrightDark,
                indicatorColor = scrimDark
            )
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Phone, contentDescription = "Support") },
            label = { Text("Support") },
            selected = currentRoute == "support",
            onClick = { onNavigate("support") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = onErrorDark,
                selectedTextColor = onErrorDark,
                unselectedIconColor = surfaceBrightDark,
                unselectedTextColor = surfaceBrightDark,
                indicatorColor = scrimDark
            )
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
            label = { Text("Profile") },
            selected = currentRoute == "profile",
            onClick = { onNavigate("profile") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = onErrorDark,
                selectedTextColor = onErrorDark,
                unselectedIconColor = surfaceBrightDark,
                unselectedTextColor = surfaceBrightDark,
                indicatorColor = scrimDark
            )
        )
    }
}