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
            }

            entry<Routes.ShopScreen> {
                ShopScreen(
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
                    },
                    onAddToCart = { producto ->
                        val existingItem = cartItems.find { it.producto == producto }
                        if (existingItem != null) {
                            val index = cartItems.indexOf(existingItem)
                            cartItems[index] = existingItem.copy(cantidad = existingItem.cantidad + 1)
                        } else {
                            cartItems.add(CartItem(producto, 1))
                        }
                    }
                )
            }

            entry<Routes.CartScreen> {
                CartScreen(
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
                    },
                    cartItems = cartItems,
                    onQuantityChange = { item, newQuantity ->
                        val index = cartItems.indexOf(item)
                        if (index != -1) {
                            if (newQuantity > 0) {
                                cartItems[index] = item.copy(cantidad = newQuantity)
                            } else {
                                cartItems.removeAt(index)
                            }
                        }
                    },
                    onRemoveItem = { item ->
                        cartItems.remove(item)
                    },
                    onBack = {
                        backStack.removeLastOrNull()
                    }
                )
            }
        }
    )
}