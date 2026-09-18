package com.example.petshop.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.petshop.Models.CartItem
import com.example.petshop.Screens.CartScreen
import com.example.petshop.Screens.HomeScreen
import com.example.petshop.Screens.ShopScreen
import com.example.petshop.Screens.CompraScreen
import com.example.petshop.Screens.DetalleScreen

@Composable
fun NavigationWrapp() {
    val backStack = rememberNavBackStack(Routes.ShopScreen)
    val cartItems = remember { mutableStateListOf<CartItem>() }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {

            entry<Routes.HomeScreen> {
                HomeScreen(
                    navToHome = {
                        backStack.clear()
                        backStack.add(Routes.HomeScreen)
                    },
                    navToShop = {
                        backStack.clear()
                        backStack.add(Routes.ShopScreen)
                    },
                    navToCart = {
                        backStack.clear()
                        backStack.add(Routes.CartScreen)
                    }
                )
            } // entry de home

            entry<Routes.ShopScreen> {
                ShopScreen(
                    onProductClick = { producto ->
                        backStack.add(Routes.DetalleScreen(producto))
                    },
                    onAddToCart = { producto ->
                        val existingItem = cartItems.find { it.producto.id == producto.id }
                        if (existingItem != null) {
                            val index = cartItems.indexOf(existingItem)
                            cartItems[index] = existingItem.copy(cantidad = existingItem.cantidad + 1)
                        } else {
                            cartItems.add(CartItem(producto, 1))
                        }
                    },
                    navToHome = { backStack.add(Routes.HomeScreen) },
                    navToShop = { backStack.add(Routes.ShopScreen) },
                    navToCart = { backStack.add(Routes.CartScreen) }
                )
            }// entry de shop

            entry<Routes.CartScreen> {
                CartScreen(
                    cartItems = cartItems,
                    onQuantityChange = { cartItem, nuevaCantidad ->
                        val index = cartItems.indexOf(cartItem)
                        if (index != -1) {
                            if (nuevaCantidad > 0) {
                                cartItems[index] = cartItem.copy(cantidad = nuevaCantidad)
                            } else {
                                cartItems.removeAt(index)
                            }
                        }
                    },
                    onRemoveItem = { cartItem ->
                        cartItems.remove(cartItem)
                    },
                    navToHome = {
                        backStack.add(Routes.HomeScreen)
                    },
                    navToShop = {
                        backStack.add(Routes.ShopScreen)
                    },
                    navToCart = {
                    },
                    onProcesarPago = {
                        cartItems.clear()
                        backStack.add(Routes.CompraScreen)
                    },
                    onBack = {
                        backStack.removeLastOrNull()
                    }
                )
            } // entry de cart

            entry<Routes.CompraScreen> {
                CompraScreen (
                    onReturnToHome = {
                        backStack.clear()
                        backStack.add(Routes.ShopScreen)
                    }
                )
            }// entry de compra

            entry<Routes.DetalleScreen> { key ->
                DetalleScreen(
                    producto = key.producto,
                    onAddToCart = { producto, cantidad ->
                        val existingItem = cartItems.find { it.producto.id == producto.id }
                        if (existingItem != null) {
                            val index = cartItems.indexOf(existingItem)
                            cartItems[index] = existingItem.copy(cantidad = existingItem.cantidad + cantidad)
                        } else {
                            cartItems.add(CartItem(producto, cantidad))
                        }
                        backStack.add(Routes.CartScreen)
                    },
                    onBack = {
                        backStack.removeLastOrNull()
                    }
                )
            } // entru de detalle


        }// fin entryProvider
    ) // fin NavDisplay
} // fin funcion principal