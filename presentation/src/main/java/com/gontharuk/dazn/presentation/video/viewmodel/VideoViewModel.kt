package com.gontharuk.dazn.presentation.video.viewmodel

import android.net.Uri
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.gontharuk.dazn.presentation.core.navigation.bottom.BottomTarget
import com.gontharuk.dazn.presentation.core.navigation.main.MainTarget
import com.gontharuk.dazn.presentation.video.entity.VideoState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class VideoViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val uri: String = checkNotNull(savedStateHandle[MainTarget.Video.videoArg])

    val state: StateFlow<VideoState> = MutableStateFlow(VideoState(Uri.parse(uri)))
}

