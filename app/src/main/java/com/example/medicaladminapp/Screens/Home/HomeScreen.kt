package com.example.medicaladminapp.Screens.Home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.Money
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Sell
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Verified
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.medicaladminapp.Screens.BottomTab
import com.example.medicaladminapp.Screens.Dashboard.DashboardScreen
import com.example.medicaladminapp.Screens.Orders.OrderScreen
import com.example.medicaladminapp.Screens.Orders.OrderViewModel
import com.example.medicaladminapp.Screens.Profile.ProfileScreen
import com.example.medicaladminapp.Screens.Sale.SaleScreen
import com.example.medicaladminapp.Screens.Vendors.Vendors
import com.example.medicaladminapp.Screens.Vendors.VendorsViewModel
import com.example.medicaladminapp.ui.theme.AppColor

@Composable
fun HomeScreen(navHostController: NavHostController, viewModel: HomeViewModel) {
    val bottomTabs = remember { mutableStateOf(BottomTab.DASHBOARD.route) }
    Scaffold(content = {
        it

        when (bottomTabs.value) {
            BottomTab.DASHBOARD.route -> {
                DashboardScreen()
            }
            BottomTab.SALE.route -> {
                SaleScreen()
            }

            BottomTab.ORDERS.route -> {
                OrderScreen(viewModel = OrderViewModel(), navHostController = navHostController)
            }

            BottomTab.PROFILE.route -> {
                ProfileScreen()
            }
            BottomTab.VENDORS.route -> {
                Vendors(navHostController = navHostController, viewModel = VendorsViewModel())
            }

        }
    }, bottomBar = {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {
            Card(
                modifier = Modifier.height(60.dp), shape = RoundedCornerShape(5.dp),
                elevation = CardDefaults.cardElevation(5.dp),
                colors = CardDefaults.cardColors(AppColor)
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 10.dp)
                        .background(color = AppColor)
                        .fillMaxWidth()
                        .fillMaxHeight(1f)
                        .padding(horizontal = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Icon(
                        imageVector = Icons.Default.Dashboard,
                        contentDescription = "Dashboard Icon",
                        modifier = Modifier
                            .padding(5.dp)
                            .size(30.dp)
                            .clickable {
                                bottomTabs.value = BottomTab.DASHBOARD.route
                            },
                        tint = Color.White
                    )
                    Icon(
                        imageVector = Icons.Default.Money, contentDescription = "Money Icon",
                        modifier = Modifier.size(30.dp).clickable {
                            bottomTabs.value = BottomTab.SALE.route
                        }, tint = Color.White
                    )
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "ShoppingCart Icon",
                        modifier = Modifier.size(30.dp).clickable {
                            bottomTabs.value = BottomTab.ORDERS.route
                        },
                        tint = Color.White
                    )
                    Icon(
                        imageVector = Icons.Default.Sell,
                        contentDescription = "Sell Icon",
                        modifier = Modifier
                            .padding(5.dp)
                            .size(30.dp)
                            .clickable {
                                bottomTabs.value = BottomTab.VENDORS.route
                            },
                        tint = Color.White
                    )
                    Icon(
                        imageVector = Icons.Default.Person, contentDescription = "Person Icon",
                        modifier = Modifier.size(30.dp).clickable {
                            bottomTabs.value = BottomTab.PROFILE.route
                        }, tint = Color.White

                    )
                }
            }
        }
    })
}
