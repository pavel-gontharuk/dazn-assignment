package com.gontharuk.dazn.presentation.core.view

import android.net.Uri
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.datasource.DefaultDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.source.ProgressiveMediaSource
import androidx.media3.ui.PlayerView

@Composable
@androidx.annotation.OptIn(androidx.media3.common.util.UnstableApi::class)
fun VideoPlayer(uri: Uri) {
    val context = LocalContext.current
    val exoPlayer = remember {
        ExoPlayer.Builder(context).build()
            .apply {
                val sourceFactory = DefaultDataSource.Factory(context)
                val source = ProgressiveMediaSource.Factory(sourceFactory)
                    .createMediaSource(MediaItem.fromUri(uri))
                setMediaSource(source)
                playWhenReady = true
                repeatMode = Player.REPEAT_MODE_OFF
                prepare()
            }
    }

    AndroidView(
        factory = {
            PlayerView(it).apply {
                player = exoPlayer
                layoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            }
        }
    )
    DisposableEffect(Unit) {
        onDispose { exoPlayer.release() }
    }
}