package com.ahr.todocompose.navigation.destination

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.ahr.todocompose.util.Action
import com.ahr.todocompose.util.Constant.TASK_ARGUMENT_KEY
import com.ahr.todocompose.util.Constant.TASK_SCREEN

fun NavGraphBuilder.taskComposable(navigateToListScreen: (Action) -> Unit) {
    composable(
        route = TASK_SCREEN,
        arguments = listOf(
            navArgument(name = TASK_ARGUMENT_KEY) { type = NavType.IntType }
        )
    ) {

    }
}