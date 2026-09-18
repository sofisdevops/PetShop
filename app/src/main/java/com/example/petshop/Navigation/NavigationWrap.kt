package com.example.petshop.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.petshop.Models.CartItem
import com.example.petshop.Screens.CartScreen
import com.example.petshop.Screens.ShopScreen

@Composable
fun NavigationWrapp() {
    val backStack = rememberNavBackStack(Routes.ShopScreen)
    val cartItems = remember { mutableStateListOf<CartItem>() }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {

            entry<Routes.ShopScreen> {
                ShopScreen(
                    onAddToCart = { producto ->
                        val itemExistente = cartItems.find { it.producto.id == producto.id }
                        if (itemExistente != null) {
                            val index = cartItems.indexOf(itemExistente)
                            cartItems[index] = itemExistente.copy(cantidad = itemExistente.cantidad + 1)
                        } else {
                            cartItems.add(CartItem(producto = producto, cantidad = 1))
                        }
                    },
                    onNavigateToCart = {
                        backStack.add(Routes.CartScreen)
                    }
                )
            }

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
                    onNavigateToShop = {
                        backStack.add(Routes.ShopScreen)
                    },
                    onBack = {
                        backStack.removeLastOrNull()
                    }
                )
            }
        }
    )
}