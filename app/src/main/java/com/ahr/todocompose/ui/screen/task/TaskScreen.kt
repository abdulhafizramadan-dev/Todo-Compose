package com.ahr.todocompose.ui.screen.task

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import com.ahr.todocompose.data.entity.Priority
import com.ahr.todocompose.domain.ToDoTask
import com.ahr.todocompose.ui.viewmodel.SharedViewModel
import com.ahr.todocompose.util.Action

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TaskScreen(
    task: ToDoTask?,
    sharedViewModel: SharedViewModel,
    navigateToListScreen: (Action) -> Unit
) {

    LaunchedEffect(key1 = task) {
        sharedViewModel.updateTaskFields(task)
    }

    val title: String by sharedViewModel.title
    val description: String by sharedViewModel.description
    val priority: Priority by sharedViewModel.priority

    Scaffold(
        topBar = {
            TaskAppBar(
                task = task,
                navigateToListScreen = navigateToListScreen
            )
        }
    ) {
        TaskContent(
            title = title,
            onTitleChanged = { title -> sharedViewModel.title. value = title },
            description = description,
            onDescriptionChanged = { description -> sharedViewModel.description.value = description },
            priority = priority,
            onPriorityChanged = { priority -> sharedViewModel.priority.value = priority }
        )
    }
}
