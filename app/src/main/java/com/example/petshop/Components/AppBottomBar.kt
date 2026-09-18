package com.example.petshop.Components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Storefront
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.petshop.ui.theme.CremaFondo
import com.example.petshop.ui.theme.RojoTerracota

@Composable
fun AppBottomBar(
    navToHome: () -> Unit,
    navToShop: () -> Unit,
    navToCart: () -> Unit,
    navToPerfil: () -> Unit,
    currentScreen: String = ""
) {
    NavigationBar(
        containerColor = Color.White
    ) {
        NavigationBarItem(
            selected = currentScreen == "home",
            onClick = navToHome,
            icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
            label = { Text("Inicio") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = RojoTerracota,
                selectedTextColor = RojoTerracota,
                indicatorColor = CremaFondo
            )
        )

        NavigationBarItem(
            selected = currentScreen == "shop",
            onClick = navToShop,
            icon = { Icon(Icons.Default.Storefront, contentDescription = "Shop") },
            label = { Text("Tienda") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = RojoTerracota,
                selectedTextColor = RojoTerracota,
                indicatorColor = CremaFondo
            )
        )

        NavigationBarItem(
            selected = currentScreen == "cart",
            onClick = navToCart,
            icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Cart") },
            label = { Text("Carrito") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = RojoTerracota,
                selectedTextColor = RojoTerracota,
                indicatorColor = CremaFondo
            )
        )

        NavigationBarItem(
            selected = currentScreen == "perfil",
            onClick = navToPerfil,
            icon = { Icon(Icons.Default.Pets, contentDescription = "Perfil") },
            label = { Text("Perfil") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = RojoTerracota,
                selectedTextColor = RojoTerracota,
                indicatorColor = CremaFondo
            )
        )

    } //fin del navigationBottomBar
} // fin de la funcion principal