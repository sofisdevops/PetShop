package com.example.petshop.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Cake
import androidx.compose.material.icons.filled.DirectionsRun
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.Scale
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petshop.Components.AppBottomBar
import com.example.petshop.Components.ChipItem
import com.example.petshop.Components.PedidoItemCard
import com.example.petshop.Components.PedidosRecientesSection
import com.example.petshop.Models.Producto
import com.example.petshop.Models.sampleProducts
import com.example.petshop.R
import com.example.petshop.ui.theme.CremaFondo
import com.example.petshop.ui.theme.RojoTerracota

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    navToHome: () -> Unit,
    navToShop: () -> Unit,
    navToCart: () -> Unit,
    navToPerfil: () -> Unit,
    navToDetail: (Producto) -> Unit = {},
    onBack: () -> Unit = {},
    onEdit: () -> Unit = {},

    ) {
    Scaffold(
        containerColor = CremaFondo,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent
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
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "PetSnack",
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            color = RojoTerracota
                        )
                    } // fin del box del titulo
                },
                actions = {
                    IconButton(onClick = onEdit) {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "Editar",
                            tint = Color.Black
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
                currentScreen = "perfil"
            )
        } // fin del bottom bar
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 20.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(10.dp))

            Box(
                contentAlignment = Alignment.BottomEnd,
                modifier = Modifier.size(120.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.oreo),
                    contentDescription = "Mascota",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(110.dp)
                        .clip(CircleShape)
                        .border(3.dp, RojoTerracota, CircleShape)
                )

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                        .background(RojoTerracota)
                ) {
                    Icon(
                        imageVector = Icons.Default.Pets,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(18.dp)
                    )
                } // fin del badge de la huella
            } // fin del box de la foto de perfil

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Oreo",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = RojoTerracota
            )

            Spacer(modifier = Modifier.height(6.dp))

            ChipItem(
                text = "Raza Perro :D",
                icon = Icons.Default.Pets,
                backgroundColor = Color(0xFFFFE082),
                textColor = Color(0xFF5D4037)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Información General",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = RojoTerracota,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFF7F7F7)),
                    modifier = Modifier.weight(1f)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Default.Cake,
                            contentDescription = null,
                            tint = Color(0xFF00897B)
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "EDAD",
                            fontSize = 10.sp,
                            color = Color.Gray,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "11 meses",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    } // fin de la columna de edad
                } // fin de la card de edad

                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFF7F7F7)),
                    modifier = Modifier.weight(1f)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(
                            imageVector = Icons.Default.Scale,
                            contentDescription = null,
                            tint = Color(0xFF00897B)
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "PESO",
                            fontSize = 10.sp,
                            color = Color.Gray,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "3kl",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    } // fin de la columna de peso
                } // fin de la card de peso
            } // fin de la fila de edad y peso

            Spacer(modifier = Modifier.height(12.dp))

            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF7F7F7)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.DirectionsRun,
                        contentDescription = null,
                        tint = Color(0xFF00897B)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "NIVEL DE ACTIVIDAD",
                        fontSize = 10.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Alta (2+ horas/día)",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = RojoTerracota
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    LinearProgressIndicator(
                        progress = { 0.75f },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(8.dp)
                            .clip(CircleShape),
                        color = RojoTerracota,
                        trackColor = Color(0xFF80DEEA)
                    )
                } // fin de la columna de actividad
            } // fin de la card de nivel de actividad

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Preferencias Alimenticias",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = RojoTerracota,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            Card(
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFF7F7F7)),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Warning,
                            contentDescription = null,
                            tint = Color.Gray,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "ALERGIAS",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Gray
                        )
                    } // fin de la fila encabezado alergias

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        ChipItem(
                            text = "Pollo",
                            backgroundColor = Color(0xFFFFD8D8),
                            textColor = Color(0xFFA24751)
                        )
                        ChipItem(
                            text = "Lácteos",
                            backgroundColor = Color(0xFFFFD8D8),
                            textColor = Color(0xFFA24751)
                        )
                    } // fin de los chips alergias

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.FavoriteBorder,
                            contentDescription = null,
                            tint = Color.Gray,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            "SABOR FAVORITO",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Gray
                        )
                    } // fin de la fila encabezado favoritos

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        ChipItem(
                            text = "Salmón",
                            backgroundColor = Color(0xFFFD8966),
                            textColor = Color(0xFFAC441C)
                        )
                        ChipItem(
                            text = "Pavo",
                            backgroundColor = Color(0xFFFD8966),
                            textColor = Color(0xFFAC441C)
                        )
                    } // fin de los chips favoritos
                } // fin de la columna dentro de la card de preferencias
            } // fin de la card de preferencias alimenticias

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Pedidos Recientes",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = RojoTerracota
                )
                Text(
                    text = "Ver todos",
                    fontSize = 12.sp,
                    color = Color(0xFF00897B),
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            PedidosRecientesSection(
                productos = sampleProducts.take(2),
                onPedidoClick = { producto ->
                    navToDetail(producto)
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

        } // fin de la columna principal
    } // fin del scaffold
} // fin de la funcion principal