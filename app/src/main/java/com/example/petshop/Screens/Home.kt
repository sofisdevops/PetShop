package com.example.petshop.Screens

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Storefront
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.petshop.ui.theme.GrisClaro
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.sp
import com.example.petshop.ui.theme.CremaFondo
import com.example.petshop.ui.theme.RojoTerracota
import com.example.petshop.Components.CategoryItem
import com.example.petshop.ui.theme.Mostasa
import com.example.petshop.ui.theme.NaranjaClaro
import com.example.petshop.ui.theme.Turquesa
import com.example.petshop.Components.PrimaryButton
import androidx.compose.ui.res.painterResource
import com.example.petshop.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.draw.clip
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){
    Scaffold(
        containerColor = CremaFondo,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = CremaFondo,
                    titleContentColor = RojoTerracota
                ),
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Pets,
                            contentDescription = null,
                            modifier = Modifier.size(36.dp)
                        )
                        Text(
                            text = "PetSnack",
                            fontWeight = FontWeight.Bold,
                            fontSize = 36.sp
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* TODO */ }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Acción de Busqueda",
                            modifier = Modifier.size(36.dp)
                        )
                    }
                }
            )
        }, // fin del topBar
        bottomBar = {
            BottomAppBar(
                containerColor = GrisClaro,
                contentColor = RojoTerracota,
                actions = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly) {

                        IconButton(onClick = { /* Nada */ }) {
                            Icon(Icons.Default.Home, contentDescription = "Home")
                        }

                        IconButton(onClick = {  /* Nada */ }) {
                            Icon(Icons.Default.Storefront, contentDescription = "Shop")
                        }

                        IconButton(onClick = {  /* Nada */}) {
                            Icon(Icons.Default.Favorite, contentDescription = "Favorites")
                        }

                        IconButton(onClick = {  /* Nada */}) {
                            Icon(Icons.Default.ShoppingCart , contentDescription = "Cart")
                        }
                        IconButton(onClick = {  /* Nada */}) {
                            Icon(Icons.Default.Pets, contentDescription = "Perfil")
                        }
                    }
                }
            )
        }, // fin del bottomBar
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(paddingValues = innerPadding)
                .fillMaxSize()
                .padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally,

        ){

            Column(modifier = Modifier.fillMaxWidth()) {

                Text(
                    text = "Categorias",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly) {
                    CategoryItem(
                        titulo = "Perros",
                        backgroundColor = NaranjaClaro,
                        onClick = { /* TODO*/ }
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    CategoryItem(
                        titulo = "Gatos",
                        backgroundColor = Turquesa,
                        onClick = { /* TODO */ }
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    CategoryItem(
                        titulo = "Aves",
                        backgroundColor = Mostasa,
                        onClick = { /* TODO */ }
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    CategoryItem(
                        titulo = "Peces",
                        backgroundColor = GrisClaro,
                        onClick = { /* TODO */ }
                    )

                } // fila de categorias

            } // fin de la columna categorias

            Spacer(modifier = Modifier.height(8.dp))

            Card(
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                Box(modifier = Modifier.fillMaxSize()) {

                    Image(
                        painter = painterResource(id = R.drawable.banner_perrito),
                        contentDescription = "Promoción de alimentos",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                brush = Brush.horizontalGradient(
                                    0.0f to Color.White.copy(alpha = 0.95f),
                                    0.4f to Color.White.copy(alpha = 0.80f),
                                    0.7f to Color.White.copy(alpha = 0.30f),
                                    1.0f to Color.Transparent
                                )
                            )
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(0.65f)
                            .padding(16.dp),
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.Start
                    ) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(12.dp))
                                .background(RojoTerracota)
                                .padding(horizontal = 10.dp, vertical = 4.dp)
                        ) {
                            Text(
                                text = "Promo Especial",
                                color = Color.White,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Text(
                            text = "20% OFF",
                            fontSize = 26.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.Black
                        )

                        Text(
                            text = "En alimento premium para tu mejor amigo.",
                            fontSize = 12.sp,
                            color = Color.DarkGray,
                            lineHeight = 16.sp
                        )

                        PrimaryButton(
                            text = "Comprar Ahora",
                            onClick = { /* TODO */ }
                        )
                    }
                }
            } // fin del banner

            Spacer(modifier = Modifier.height(8.dp))

        } // fin de la columna contenedorea principal
    } // fin del scaffold
}// fin de la funcion principal