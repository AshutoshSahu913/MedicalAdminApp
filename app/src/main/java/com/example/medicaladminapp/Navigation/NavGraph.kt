package com.example.medicaladminapp.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.medicaladminapp.Screens.Details.DetailsScreen
import com.example.medicaladminapp.Screens.Details.DetailsViewModel
import com.example.medicaladminapp.Screens.Home.HomeScreen
import com.example.medicaladminapp.Screens.Home.HomeViewModel

@Composable
fun NavGraph(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Route.Home) {
        composable<Route.Home> {
            HomeScreen(navHostController = navHostController,viewModel=HomeViewModel())
        }

        composable<Route.Details> {
            val args=it.toRoute<Route.Details>()
            DetailsScreen(args=args,navController=navHostController,viewModel=DetailsViewModel())
        }
    }
}