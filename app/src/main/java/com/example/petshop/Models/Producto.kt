package com.example.petshop.Models
import kotlinx.serialization.Serializable

@Serializable
data class Producto(
    val id: Int,
    val name: String,
    val precio: Double,
    val descripcion: String,
    val imageUrl: Int,
    val categoria: String,
    val beneficio1: String,
    val beneficio2: String,
    val beneficio3: String
)