package com.ahr.todocompose.navigation.destination

import androidx.compose.runtime.LaunchedEffect
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

        val taskId = navBackStackEntry.arguments?.getInt(TASK_ARGUMENT_KEY) ?: -1
        sharedViewModel.getSelectedTask(taskId)
        val selectedTask by sharedViewModel.selectedTask.collectAsState()

        LaunchedEffect(key1 = selectedTask) {
            sharedViewModel.updateTaskFields(selectedTask)
        }

        TaskScreen(
            task = selectedTask,
            sharedViewModel = sharedViewModel,
            navigateToListScreen = navigateToListScreen
        )
    }
}