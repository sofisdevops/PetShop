package com.example.petshop.Models

import com.example.petshop.R

val sampleProducts = listOf(
    Producto(
        id = 1,
        name = "Areneros",
        precio = 50.000,
        descripcion = "Areneros para gatos.",
        imageUrl = R.drawable.areneros,
        categoria = "Gatos",
        beneficio1 = "Facil limpieza y control de olores",
        beneficio2 = "Material resistente e higienico",
        beneficio3 = "Espacio amplio para mayor comodidad"
    ),
    Producto(
        id = 2,
        name = "Comida para gatos",
        precio = 25.000,
        descripcion = "Nutritiva comida para gatos.",
        imageUrl = R.drawable.comida_de_gatos,
        categoria = "Gatos",
        beneficio1 = "Rica en proteina y nutrientes esenciales",
        beneficio2 = "Favorece la digestion de tu mascota",
        beneficio3 = "Sin conservantes artificiales"
    ),
    Producto(
        id = 3,
        name = "Comida para perros",
        precio = 75.000,
        descripcion = "Comida premium para perros.",
        imageUrl = R.drawable.comida_de_perros,
        categoria = "Perros",
        beneficio1 = "Alto contenido de proteina magra",
        beneficio2 = "Refuerza el sistema inmunologico",
        beneficio3 = "Pelaje mas brillante y saludable"
    ),
    Producto(
        id = 4,
        name = "Pelotas de juguete para perros",
        precio = 10.000,
        descripcion = "Perfectos para ir de paseo.",
        imageUrl = R.drawable.pelotas_para_perro,
        categoria = "Perros",
        beneficio1 = "Material no toxico y ultra resistente",
        beneficio2 = "Estimula la actividad fisica",
        beneficio3 = "Diseno seguro para la dentadura"
    ),
    Producto(
        id = 5,
        name = "Camas para mascotas",
        precio = 18.000,
        descripcion = "Comodas camas para tus mascotas.",
        imageUrl = R.drawable.camas_para_mascotas,
        categoria = "Mascotas",
        beneficio1 = "Relleno acolchado para mayor confort",
        beneficio2 = "Tela lavable y de facil mantenimiento",
        beneficio3 = "Base antideslizante para seguridad"
    ),
    Producto(
        id = 6,
        name = "Cepillos para mascotas",
        precio = 15.000,
        descripcion = "Cepillos de cerdas suaves para cabellos largos",
        imageUrl = R.drawable.cepillos_para_mascotas,
        categoria = "Mascotas",
        beneficio1 = "Cerdas suaves que no danan la piel",
        beneficio2 = "Remueve pelo suelto eficazmente",
        beneficio3 = "Mango ergonomico antideslizante"
    ),
    Producto(
        id = 7,
        name = "Collares para mascotas",
        precio = 10.000,
        descripcion = "Hermosos collares de mascotas",
        imageUrl = R.drawable.collares_de_mascotas,
        categoria = "Mascotas",
        beneficio1 = "Ajuste seguro y comodo para el cuello",
        beneficio2 = "Material duradero e impermeable",
        beneficio3 = "Broche de alta resistencia"
    )
)