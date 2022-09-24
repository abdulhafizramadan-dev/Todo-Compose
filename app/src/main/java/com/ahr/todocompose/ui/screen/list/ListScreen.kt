package com.ahr.todocompose.ui.screen.list

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.ahr.todocompose.R
import com.ahr.todocompose.domain.RequestState
import com.ahr.todocompose.domain.ToDoTask
import com.ahr.todocompose.ui.theme.fabBackgroundColor
import com.ahr.todocompose.ui.viewmodel.SharedViewModel
import com.ahr.todocompose.util.SearchAppBarState

@ExperimentalMaterialApi
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ListScreen(
    sharedViewModel: SharedViewModel,
    navigateToTaskScreen: (Int) -> Unit
) {

    val searchAppBarState: SearchAppBarState by sharedViewModel.searchAppBarState
    val allTasks: RequestState<List<ToDoTask>> by sharedViewModel.allTasks.collectAsState()
    val searchTextState: String by sharedViewModel.searchTextState

    Scaffold(
        topBar = {
            ListAppBar(
                sharedViewModel = sharedViewModel,
                searchAppBarState = searchAppBarState,
                searchTextState = searchTextState
            )
        },
        floatingActionButton = {
            ListFab(navigateToTaskScreen = navigateToTaskScreen)
        }
    ) {
        ListContent(
            tasks = allTasks,
            onNavigateToTaskScreen = navigateToTaskScreen
        )
    }
}

@Composable
fun ListFab(navigateToTaskScreen: (Int) -> Unit) {
    FloatingActionButton(
        onClick = { navigateToTaskScreen(-1) },
        backgroundColor = MaterialTheme.colors.fabBackgroundColor
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(R.string.add_task),
            tint = Color.White
        )
    }
}
