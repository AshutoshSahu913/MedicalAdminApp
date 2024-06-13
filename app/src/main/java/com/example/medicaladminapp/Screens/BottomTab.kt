package com.example.medicaladminapp.Screens

sealed class BottomTab(var route: String) {

    object DASHBOARD : BottomTab("DASHBOARD")
    object SALE : BottomTab("SALE")
    object PROFILE : BottomTab("PROFILE")
    object ORDERS : BottomTab("ORDERS")
    object VENDORS:BottomTab("VENDORS")
}