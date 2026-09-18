package com.example.petshop.Navigation

import androidx.navigation3.runtime.NavKey
import com.example.petshop.Models.Producto
import kotlinx.serialization.Serializable

sealed class Routes : NavKey {

    @Serializable
    data object HomeScreen : Routes()

    @Serializable
    data object ShopScreen : Routes()

    @Serializable
    data object CartScreen : Routes()

    @Serializable
    data object CompraScreen: Routes()

    @Serializable
    data class DetalleScreen(val producto: Producto) : Routes()

    @Serializable
    data object PerfilScreen: Routes()

    @Serializable
    data object LoginScreen: Routes()

}
