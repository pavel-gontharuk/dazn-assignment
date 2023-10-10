package com.gontharuk.dazn.presentation.core.navigation.main

sealed class MainTarget(val route: String) {

    data object Main : MainTarget("main")

    data object Video : MainTarget("video/") {

        const val videoArg: String = "videoArg"
    }
}
