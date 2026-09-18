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

    data object CompraScreen: Routes()

}