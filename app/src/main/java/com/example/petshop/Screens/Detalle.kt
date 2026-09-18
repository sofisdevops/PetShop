package com.example.petshop.Screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petshop.Components.PrimaryButton
import com.example.petshop.Components.SelectorCantidad
import com.example.petshop.Models.Producto
import com.example.petshop.ui.theme.CremaFondo
import com.example.petshop.ui.theme.RojoTerracota
import com.example.petshop.Components.BeneficioRow
import com.example.petshop.Components.ChipItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetalleScreen(
    producto: Producto,
    onAddToCart: (Producto, Int) -> Unit,
    onBack: () -> Unit
) {
    var cantidad by remember { mutableIntStateOf(1) }
    var infoNutricionalExpandida by remember { mutableStateOf(false) }

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
                    } // fin de la fila del titulo
                }
            )
        }, // fin del topbar
        bottomBar = {

            Surface(
                color = Color.White,
                shadowElevation = 8.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SelectorCantidad(
                        cantidad = cantidad,
                        onDecrease = { if (cantidad > 1) cantidad-- },
                        onIncrease = { cantidad++ }
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    PrimaryButton(
                        text = "Agregar al Carrito",
                        onClick = { onAddToCart(producto, cantidad) },
                        backgroundColor = RojoTerracota,
                        contentColor = Color.White,
                        modifier = Modifier.weight(1f)
                    )
                } // fin de la fila de la barra inferior
            } // fin del surface
        } // fin del bottombar
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            ) {
                Image(
                    painter = painterResource(id = producto.imageUrl),
                    contentDescription = producto.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            } // fin del box de la imagen

            Card(
                shape = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 0.dp)
            ) {
                Column(modifier = Modifier.padding(20.dp)) {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Top
                    ) {
                        Text(
                            text = producto.name,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            modifier = Modifier.weight(1f)
                        )

                        Text(
                            text = "$${"%.2f".format(producto.precio)}",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = RojoTerracota
                        )
                    } // fin de la fila del nombre y precio

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        repeat(5) { index ->
                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = null,
                                tint = if (index < 4) Color(0xFFFFB300) else Color(0xFFFFD54F),
                                modifier = Modifier.size(18.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "(${producto.resenas} reseñas)",
                            fontSize = 13.sp,
                            color = Color.Gray
                        )
                    } // fin de la fila de calificacion

                    Spacer(modifier = Modifier.height(14.dp))

                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        ChipItem(text = producto.categoria, icon = Icons.Default.Pets, backgroundColor = Color(0xFFB2EBF2), textColor = Color(0xFF00838F))
                        ChipItem(text = "Sin Granos", backgroundColor = Color(0xFFE0E0E0), textColor = Color.DarkGray)
                        ChipItem(text = "Omega 3", backgroundColor = Color(0xFFE0E0E0), textColor = Color.DarkGray)
                    } // fin de la fila de chips

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "Beneficios Clave",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    BeneficioRow(texto = producto.beneficio1)
                    BeneficioRow(texto = producto.beneficio2)
                    BeneficioRow(texto = producto.beneficio3)

                    Spacer(modifier = Modifier.height(20.dp))

                    Card(
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { infoNutricionalExpandida = !infoNutricionalExpandida }
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color(0xFFF7F7F7), shape = RoundedCornerShape(12.dp))
                                .padding(16.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Informacion Nutricional",
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Black
                                )

                                Icon(
                                    imageVector = if (infoNutricionalExpandida) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                                    contentDescription = "Desplegar",
                                    tint = Color.Black
                                )
                            } // fin de la fila del encabezado de la card

                            AnimatedVisibility(visible = infoNutricionalExpandida) {
                                Column(modifier = Modifier.padding(top = 12.dp)) {
                                    Text(
                                        text = "Proteina Bruta (Min): 30%\nGrasa Bruta (Min): 12%\nFibra Bruta (Max): 4%\nHumedad (Max): 10%",
                                        fontSize = 13.sp,
                                        color = Color.DarkGray,
                                        lineHeight = 20.sp
                                    )
                                } // fin de la columna del contenido desplegable
                            } // fin de la visibilidad animada
                        } // fin de la columna dentro de la card nutricional
                    } // fin de la card nutricional
                } // fin de la columna interna de la card principal
            } // fin de la card del detalle del producto
        } // fin de la columna principal contenedora
    } // fin del scaffold
} // fin de la funcion principal