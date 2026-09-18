package com.example.petshop.Models

data class Coupon(
    val code: String,
    val discountAmount: Double,
    val minPurchaseAmount: Double
)

val sampleCoupons = listOf(
    Coupon("PET10", discountAmount = 10.0, minPurchaseAmount = 50.0),
    Coupon("PROMO5", discountAmount = 5.0, minPurchaseAmount = 20.0)
)