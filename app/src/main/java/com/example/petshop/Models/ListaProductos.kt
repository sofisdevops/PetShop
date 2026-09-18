package com.example.petshop.Models
import com.example.petshop.R
import com.example.petshop.Models.Producto

val sampleProducts = listOf(
    Producto(
        id = 1,
        name = "Areneros",
        precio = 50.000,
        descripcion = "Areneros para gatos.",
        imageUrl = R.drawable.areneros
    ),
    Producto(
        id = 2,
        name = "Comida para gatos",
        precio = 25.000,
        descripcion = "Nutritiva comida para gatos.",
        imageUrl = R.drawable.comida_de_gatos
    ),
    Producto(
        id = 3,
        name = "Comida para perros",
        precio = 75.00,
        descripcion = "Comida premium para perros.",
        imageUrl = R.drawable.comida_de_perros
    ),
    Producto(
        id = 4,
        name = "Pelotas de juguete para perros",
        precio = 10.000,
        descripcion = "Perfectos para ir de paseo.",
        imageUrl = R.drawable.pelotas_para_perro
    ),
    Producto(
        id = 5,
        name = "Camas para mascotas",
        precio = 18.000,
        descripcion = "Comodas camas para tus mascotas.",
        imageUrl = R.drawable.camas_para_mascotas
    ),
    Producto(
        id = 6,
        name = "Cepillos para mascotas",
        precio = 15.000,
        descripcion = "Cepillos de cerdas suaves para cabellos largos",
        imageUrl = R.drawable.cepillos_para_mascotas
    ),
    Producto(
        id = 7,
        name = "Collares para mascotas",
        precio = 10.000,
        descripcion = "Hermosos collares de mascotas",
        imageUrl = R.drawable.collares_de_mascotas
    )
)