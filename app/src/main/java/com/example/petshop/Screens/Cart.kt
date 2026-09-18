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
import com.example.petshop.Components.AppBottomBar
import com.example.petshop.Components.CartItemCard
import com.example.petshop.Components.PrimaryButton
import com.example.petshop.Models.CartItem
import com.example.petshop.Navigation.Routes
import com.example.petshop.ui.theme.CremaFondo
import com.example.petshop.ui.theme.GrisClaro
import com.example.petshop.ui.theme.RojoTerracota

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(
    cartItems: List<CartItem>,
    onQuantityChange: (CartItem, Int) -> Unit,
    onRemoveItem: (CartItem) -> Unit,
    onBack: () -> Unit,
    navToHome: () -> Unit,
    navToShop: () -> Unit,
    navToCart: () -> Unit,
    navToPerfil: () -> Unit,
    onProcesarPago: () -> Unit,
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
        }, // fin del topbar
        bottomBar = {
            AppBottomBar(
                navToCart = navToCart,
                navToHome = navToHome,
                navToShop = navToShop,
                navToPerfil = navToPerfil,
                currentScreen = "cart"
            )
        } // fin del bottom bar
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

            Card(
                shape = RoundedCornerShape(30.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.ConfirmationNumber,
                        contentDescription = "Cupón",
                        tint = Color.Gray,
                        modifier = Modifier.size(24.dp)
                    )

                    TextField(
                        value = couponCode,
                        onValueChange = { couponCode = it },
                        placeholder = { Text("Cupón de descuento", color = Color.Gray) },
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        modifier = Modifier.weight(1f)
                    )

                    PrimaryButton(
                        text = "Aplicar",
                        onClick = {
                            if (couponCode.uppercase() == "DESCUENTO10" && subtotal >= 30.0) {
                                descuentoAplicado = 10.0
                            }
                        },
                        backgroundColor = Color(0xFF00695C),
                        contentColor = Color.White
                    )
                } // row de cupon
            } // fin de la card de compra

            Spacer(modifier = Modifier.height(20.dp))

            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Resumen",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Subtotal", color = Color.Gray)
                        Text(text = "$${"%.2f".format(subtotal)}", fontWeight = FontWeight.SemiBold)
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Envío", color = Color.Gray)
                        Text(text = "$${"%.2f".format(envio)}", fontWeight = FontWeight.SemiBold)
                    }

                    if (descuentoAplicado > 0) {
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = "Descuento", color = Color(0xFF00695C))
                            Text(text = "-$${"%.2f".format(descuentoAplicado)}", fontWeight = FontWeight.SemiBold, color = Color(0xFF00695C))
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))
                    HorizontalDivider(color = Color(0xFFEEEEEE))
                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Total",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "$${"%.2f".format(total)}",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = RojoTerracota
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    PrimaryButton(
                        text = "Procesar Pago",
                        onClick = onProcesarPago,
                        backgroundColor = RojoTerracota,
                        contentColor = Color.White,
                        modifier = Modifier.fillMaxWidth()
                    )
                } //columna contennedora
            } // fin de la card del pago

        } // fin de la columna contenedora
    } // fin del scaffond
} // fin de la funcion principal