package com.example.petshop.Models
import kotlinx.serialization.Serializable

@Serializable
data class Producto(
    val id: Int,
    val name: String,
    val precio: Double,
    val descripcion: String,
    val imageUrl: Int
)