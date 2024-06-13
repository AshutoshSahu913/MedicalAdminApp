package com.example.medicalvendorapp.DataModel

data class ProductResponseItem(
    val isActive: String,
    val productCategory: String,
    val productId: Int,
    val productName: String,
    val productPrice: Double,
    val productStock: Int
)