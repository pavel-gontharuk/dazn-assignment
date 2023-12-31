package com.gontharuk.dazn.presentation.video.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.gontharuk.dazn.presentation.core.view.VideoPlayer
import com.gontharuk.dazn.presentation.video.entity.VideoState
import com.gontharuk.dazn.presentation.video.viewmodel.VideoViewModel

@Composable
fun VideoScreen(
    viewModel: VideoViewModel = hiltViewModel()
) {
    val state: VideoState by viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primary)
    ) {
        VideoPlayer(state.uri)
    }
}