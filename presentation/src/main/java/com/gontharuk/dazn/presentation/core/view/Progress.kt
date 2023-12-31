package com.gontharuk.dazn.presentation.core.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gontharuk.dazn.presentation.core.dimensions.Dimens

@Composable
fun Progress() = Box(
    modifier = Modifier.fillMaxSize()
) {
    CircularProgressIndicator(
        modifier = Modifier
            .width(Dimens.Size.progress)
            .align(Alignment.Center),
        color = MaterialTheme.colorScheme.primary,
    )
}
