package com.ahr.todocompose.navigation.destination

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.ahr.todocompose.util.Constant.LIST_ARGUMENT_KEY
import com.ahr.todocompose.util.Constant.LIST_SCREEN

fun NavGraphBuilder.listComposable(navigateToTaskScreen: (Int) -> Unit) {
    composable(
        route = LIST_SCREEN,
        arguments = listOf(
            navArgument(name = LIST_ARGUMENT_KEY) { type = NavType.StringType }
        )
    ) {

    }
}