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
    val rating: Double = 4.8,
    val resenas: Int = 128,
    val beneficio1: String,
    val beneficio2: String,
    val beneficio3: String
)