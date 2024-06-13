package com.example.medicaladminapp.Navigation

import kotlinx.serialization.Serializable

class Route {

    @Serializable
    object Home

    @Serializable
    object AddProduct

    @Serializable
    data class Details(
    val address: String,
    val approved: Int,
    val block: Int,
    val dateOfAccountCreation: String,
    val email: String,
    val id: Int,
    val level: Int,
    val name: String,
    val password: String,
    val phone: String,
    val pincode: String,
    val user_id: String
    )

}