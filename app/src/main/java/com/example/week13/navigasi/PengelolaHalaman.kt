package com.example.week13.navigasi

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.week13.ui.view.HomeScreen
import com.example.week13.ui.view.InsertMahasiswaView

@Composable
fun PengelolaHalaman(
    modifier: Modifier,
    navController: NavHostController = rememberNavController()
){
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = Modifier
    ){
        composable(DestinasiHome.route){
            HomeScreen(
                navigateToItemEntry = {
                    navController.navigate(DestinasiInsert.route)
                },
            )
        }
        composable(DestinasiInsert.route){
            InsertMahasiswaView(
                onBack = {
                    navController.popBackStack()
                },
                onNavigate = {
                    navController.navigate(DestinasiHome.route)
                },
            )
        }
    }
}