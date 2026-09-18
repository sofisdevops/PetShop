package com.example.petshop.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ConfirmationNumber
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Store
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petshop.Components.CartItemCard
import com.example.petshop.Components.PrimaryButton
import com.example.petshop.Models.CartItem
import com.example.petshop.ui.theme.CremaFondo
import com.example.petshop.ui.theme.GrisClaro
import com.example.petshop.ui.theme.RojoTerracota

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(
    cartItems: List<CartItem>,
    onQuantityChange: (CartItem, Int) -> Unit,
    onRemoveItem: (CartItem) -> Unit,
    onNavigateToShop: () -> Unit,
    onBack: () -> Unit
) {
    var couponCode by remember { mutableStateOf("") }
    var descuentoAplicado by remember { mutableDoubleStateOf(0.0) }

    val subtotal = cartItems.sumOf { it.producto.precio * it.cantidad }
    val envio = if (subtotal > 0.0) 5.0 else 0.0
    val total = (subtotal + envio - descuentoAplicado).coerceAtLeast(0.0)

    Scaffold(
        containerColor = CremaFondo,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = CremaFondo,
                    titleContentColor = RojoTerracota
                ),
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Atrás",
                            tint = Color.Black
                        )
                    }
                },
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "PetSnack",
                            fontWeight = FontWeight.Bold,
                            fontSize = 30.sp,
                            color = RojoTerracota,
                            modifier = Modifier.padding(end = 48.dp)
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = GrisClaro,
                contentColor = RojoTerracota,
                actions = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        IconButton(onClick = { /* Home */ }) {
                            Icon(Icons.Default.Home, contentDescription = "Home")
                        }
                        IconButton(onClick = onNavigateToShop) {
                            Icon(Icons.Default.Store, contentDescription = "Shop")
                        }
                        IconButton(onClick = { /* Favorites */ }) {
                            Icon(Icons.Default.Favorite, contentDescription = "Favorites")
                        }
                        IconButton(onClick = { /* Current */ }) {
                            Icon(Icons.Default.ShoppingCart, contentDescription = "Cart", tint = RojoTerracota)
                        }
                        IconButton(onClick = { /* Perfil */ }) {
                            Icon(Icons.Default.Pets, contentDescription = "Perfil")
                        }
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Text(
                text = "Tu Carrito",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = "${cartItems.sumOf { it.cantidad }} artículos seleccionados",
                fontSize = 14.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(16.dp))

            cartItems.forEach { item ->
                CartItemCard(
                    imageRes = item.producto.imageUrl,
                    titulo = item.producto.name,
                    subtitulo = item.producto.descripcion,
                    precio = "$${item.producto.precio * item.cantidad}",
                    cantidad = item.cantidad,
                    siCantidadCambia = { nuevaCant -> onQuantityChange(item, nuevaCant) },
                    siSeRemueve = { onRemoveItem(item) }
                )
                Spacer(modifier = Modifier.height(12.dp))
            } // fin cartItems


        } // fin de la columna contenedora
    } // fin del scaffond
} // fin de la funcion principal