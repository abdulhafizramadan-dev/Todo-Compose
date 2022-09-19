package com.ahr.todocompose.navigation

import androidx.navigation.NavHostController
import com.ahr.todocompose.util.Action
import com.ahr.todocompose.util.Constant.LIST_SCREEN

class Screens(private val navController: NavHostController) {

    val list: (Action) -> Unit = { action: Action ->
        navController.navigate(route = "list/${action.name}") {
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }

    val task: (Int) -> Unit = { taskId ->
        navController.navigate(route = "task/$taskId")
    }
}