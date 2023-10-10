package com.gontharuk.dazn.presentation.core.navigation.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.gontharuk.dazn.presentation.core.navigation.bottom.BottomNav
import com.gontharuk.dazn.presentation.video.ui.VideoScreen

@Composable
fun MainNav() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = MainTarget.Main.route) {
        composable(MainTarget.Main.route) { BottomNav(navController) }
        composable(
            route = "${MainTarget.Video.route}{${MainTarget.Video.videoArg}}",
            arguments = listOf(navArgument(MainTarget.Video.videoArg) { type = NavType.StringType })
        ) { VideoScreen() }
    }
}