package com.example.petshop.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Store
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petshop.Models.sampleProducts
import com.example.petshop.Components.PrimaryButton
import com.example.petshop.ui.theme.CremaFondo
import com.example.petshop.ui.theme.GrisClaro
import com.example.petshop.ui.theme.GrisOscuro
import com.example.petshop.ui.theme.Mostasa
import com.example.petshop.ui.theme.RojoTerracota

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShopScreen() {
    var categoriaSeleccionada by remember { mutableStateOf("Seco") }
    val subcategorias = listOf("Seco", "Húmedo", "Snacks", "Dieta Especial")

    Scaffold(
        containerColor = CremaFondo,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = CremaFondo,
                    titleContentColor = RojoTerracota
                ),
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Pets,
                            contentDescription = null,
                            modifier = Modifier.size(32.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "PetSnack",
                            fontWeight = FontWeight.Bold,
                            fontSize = 32.sp
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* TODO: Búsqueda */ }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Buscar",
                            modifier = Modifier.size(28.dp)
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
                        IconButton(onClick = { /* Navegar a Home */ }) {
                            Icon(Icons.Default.Home, contentDescription = "Home")
                        }
                        IconButton(onClick = { /* Pantalla actual */ }) {
                            Icon(Icons.Default.Store, contentDescription = "Shop", tint = RojoTerracota)
                        }
                        IconButton(onClick = { /* Favoritos */ }) {
                            Icon(Icons.Default.Favorite, contentDescription = "Favorites")
                        }
                        IconButton(onClick = { /* Carrito */ }) {
                            Icon(Icons.Default.ShoppingCart, contentDescription = "Cart")
                        }
                        IconButton(onClick = { /* Perfil */ }) {
                            Icon(Icons.Default.Pets, contentDescription = "Perfil")
                        }
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* TODO */ },
                containerColor = Mostasa,
                contentColor = Color.White,
                shape = RoundedCornerShape(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.FilterList,
                    contentDescription = "Filtros"
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.padding(vertical = 12.dp)
            ) {
                items(subcategorias.size) { index ->
                    val categoria = subcategorias[index]
                    val isSelected = categoria == categoriaSeleccionada

                    PrimaryButton(
                        text = categoria,
                        onClick = { categoriaSeleccionada = categoria },
                        backgroundColor = if (isSelected) RojoTerracota else Color(0xFFE0E0E0),
                        contentColor = if (isSelected) Color.White else GrisOscuro
                    )
                }
            } // fin del lazyRow

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(14.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp),
                contentPadding = PaddingValues(bottom = 16.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(sampleProducts) { producto ->
                    Card(
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {

                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(130.dp)
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(Color(0xFFF7F7F7))
                            ) {
                                Image(
                                    painter = painterResource(id = producto.imageUrl),
                                    contentDescription = producto.name,
                                    contentScale = ContentScale.Fit,
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(8.dp)
                                )

                                IconButton(
                                    onClick = { /* TODO */ },
                                    modifier = Modifier
                                        .align(Alignment.TopEnd)
                                        .padding(4.dp)
                                        .size(28.dp)
                                        .clip(CircleShape)
                                        .background(Color.White)
                                ) {
                                    Icon(
                                        imageVector = Icons.Outlined.FavoriteBorder,
                                        contentDescription = "Favorito",
                                        tint = Color.Gray,
                                        modifier = Modifier.size(16.dp)
                                    )
                                } // fin iconbutton de favoritos
                            } // fin de la caja de los productos

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = producto.name,
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp,
                                color = Color.Black,
                                maxLines = 1
                            )

                            Text(
                                text = producto.descripcion,
                                fontSize = 12.sp,
                                color = Color.Gray,
                                maxLines = 1
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "$${producto.precio}",
                                fontWeight = FontWeight.ExtraBold,
                                fontSize = 16.sp,
                                color = RojoTerracota
                                )

                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier
                                        .size(32.dp)
                                        .clip(CircleShape)
                                        .background(RojoTerracota)
                                        .clickable { /* TODO */ }
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.ShoppingCart,
                                        contentDescription = "Comprar",
                                        tint = Color.White,
                                        modifier = Modifier.size(16.dp)
                                    )
                                } // fin caja del carrito
                            } // fin fila de info de los productos
                        } // fin columna
                    } // fin de card
                } // fin de items
            } // fin del LazyVerticalGrid
        } // fin de la columna principal contenedora
    } // fin del scaffold
} // fin de la funcion principal