package com.ahr.todocompose.navigation.destination

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.ahr.todocompose.ui.screen.task.TaskScreen
import com.ahr.todocompose.ui.viewmodel.SharedViewModel
import com.ahr.todocompose.util.Action
import com.ahr.todocompose.util.Constant.TASK_ARGUMENT_KEY
import com.ahr.todocompose.util.Constant.TASK_SCREEN

fun NavGraphBuilder.taskComposable(
    navigateToListScreen: (Action) -> Unit,
    sharedViewModel: SharedViewModel
) {
    composable(
        route = TASK_SCREEN,
        arguments = listOf(
            navArgument(name = TASK_ARGUMENT_KEY) { type = NavType.IntType }
        )
    ) { navBackStackEntry ->

        val taskId = navBackStackEntry.arguments?.getInt(TASK_ARGUMENT_KEY)
        val task by sharedViewModel.selectedTask.collectAsState()

        if (taskId != null) {
            sharedViewModel.getSelectedTask(taskId)
        }

        TaskScreen(
            task = task,
            navigateToListScreen = navigateToListScreen
        )
    }
}