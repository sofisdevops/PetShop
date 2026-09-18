package com.example.petshop.Screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.petshop.Models.Producto

@Composable
fun DetalleScreen(
    producto: Producto,
    onAddToCart: (Producto, Int) -> Unit,
    onBack: () -> Unit
){
    Text(text = "Pantalla de detalle")
}