package com.ahr.todocompose.navigation.destination

import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.ahr.todocompose.ui.screen.list.ListScreen
import com.ahr.todocompose.ui.viewmodel.SharedViewModel
import com.ahr.todocompose.util.Constant.LIST_ARGUMENT_KEY
import com.ahr.todocompose.util.Constant.LIST_SCREEN

@ExperimentalMaterialApi
fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    composable(
        route = LIST_SCREEN,
        arguments = listOf(
            navArgument(name = LIST_ARGUMENT_KEY) { type = NavType.StringType }
        )
    ) {
        ListScreen(
            navigateToTaskScreen = navigateToTaskScreen,
            sharedViewModel = sharedViewModel
        )
    }
}