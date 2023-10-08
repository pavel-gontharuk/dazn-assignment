@file:OptIn(ExperimentalGlideComposeApi::class)

package com.gontharuk.dazn.presentation.core.view

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@Composable
@OptIn(ExperimentalGlideComposeApi::class)
fun ImageViewUri(
    modifier: Modifier = Modifier,
    uri: Uri,
    contentDescription: String? = null
) = GlideImage(
    modifier = modifier,
    model = uri,
    contentDescription = contentDescription
)
