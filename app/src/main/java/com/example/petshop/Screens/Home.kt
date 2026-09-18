package com.example.petshop.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Storefront
import androidx.compose.material3.BottomAppBar
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
import androidx.compose.ui.unit.sp
import com.example.petshop.ui.theme.CremaFondo
import com.example.petshop.ui.theme.RojoTerracota

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){
    Scaffold(
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
            horizontalAlignment = Alignment.CenterHorizontally
        ){

        } // fin de la columna
    } // fin del scaffold
}// fin de la funcion principal