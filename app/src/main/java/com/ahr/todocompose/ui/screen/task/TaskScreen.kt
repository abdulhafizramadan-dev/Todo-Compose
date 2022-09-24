package com.ahr.todocompose.ui.screen.task

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.ahr.todocompose.domain.ToDoTask
import com.ahr.todocompose.util.Action

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TaskScreen(
    task: ToDoTask?,
    navigateToListScreen: (Action) -> Unit
) {
    Scaffold(
        topBar = {
            TaskAppBar(
                task = task,
                navigateToListScreen = navigateToListScreen
            )
        }
    ) { }
}