package com.gontharuk.dazn.presentation.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.gontharuk.dazn.presentation.core.theme.DAZNAssignmentTheme
import com.gontharuk.dazn.presentation.events.ui.EventsScreen
import com.gontharuk.dazn.presentation.schedule.ui.ScheduleScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DAZNAssignmentTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
//                    EventsScreen()
                    ScheduleScreen()
                }
            }
        }
    }
}