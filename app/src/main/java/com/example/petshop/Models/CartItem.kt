package com.example.petshop.Models

data class CartItem(
    val producto: Producto,
    var cantidad: Int = 1
)