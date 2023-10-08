package com.gontharuk.dazn.presentation.core.navigation.bottom

import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.gontharuk.dazn.presentation.events.ui.EventsScreen
import com.gontharuk.dazn.presentation.schedule.ui.ScheduleScreen

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val targets: List<BottomTarget> = remember {
        listOf(BottomTarget.Events, BottomTarget.Schedule)
    }

    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                targets.forEach { target ->
                    val selected = currentDestination?.hierarchy?.any {
                        it.route == target.route
                    } == true
                    BottomNavigationItem(
                        selected = selected,
                        label = {
                            Text(
                                text = stringResource(target.labelId),
                                color = if (selected) Color.White else Color.Black // todo color
                            )
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
                        icon = {},
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
            composable(BottomTarget.Events.route) { EventsScreen() }
            composable(BottomTarget.Schedule.route) { ScheduleScreen() }
        }
    }
}