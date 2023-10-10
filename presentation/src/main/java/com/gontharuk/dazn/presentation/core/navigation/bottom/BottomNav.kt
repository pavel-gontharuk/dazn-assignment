package com.gontharuk.dazn.presentation.core.navigation.bottom

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.gontharuk.dazn.presentation.core.navigation.main.MainTarget
import com.gontharuk.dazn.presentation.events.ui.EventsScreen
import com.gontharuk.dazn.presentation.schedule.ui.ScheduleScreen
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun BottomNav(
    mainController: NavHostController
) {
    val navController = rememberNavController()
    val targets: List<BottomTarget> = remember {
        listOf(BottomTarget.Events, BottomTarget.Schedule)
    }

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                targets.forEach { target ->
                    val selected = currentDestination?.hierarchy?.any {
                        it.route == target.route
                    } == true
                    NavigationBarItem(
                        selected = selected,
                        label = {
                            Text(text = stringResource(target.labelRes))
                        },
                        onClick = {
                            navController.navigate(target.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = ImageVector.vectorResource(target.iconRes),
                                contentDescription = target.route,
                            )
                        },
                    )
                }
            }
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = targets.first().route,
            modifier = Modifier.padding(padding)
        ) {
            composable(BottomTarget.Events.route) {
                EventsScreen {
                    val encodedUri = URLEncoder.encode(it.toString(), StandardCharsets.UTF_8.toString())
                    mainController.navigate("${MainTarget.Video.route}$encodedUri")
                }
            }
            composable(BottomTarget.Schedule.route) { ScheduleScreen() }
        }
    }
}