package com.ahr.todocompose.ui.screen.task

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import com.ahr.todocompose.R
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

    val title: String by sharedViewModel.title
    val description: String by sharedViewModel.description
    val priority: Priority by sharedViewModel.priority

    val context = LocalContext.current

    Scaffold(
        topBar = {
            TaskAppBar(
                task = task,
                navigateToListScreen = { action ->  
                    if (action == Action.NO_ACTION) {
                        navigateToListScreen(action)
                    } else {
                        if (sharedViewModel.validateFields()) {
                            navigateToListScreen(action)
                        } else {
                            displayToast(context)
                        }
                    }
                }
            )
        }
    ) {
        TaskContent(
            title = title,
            onTitleChanged = { title -> sharedViewModel.updateTitleWithLimit(title) },
            description = description,
            onDescriptionChanged = { description -> sharedViewModel.description.value = description },
            priority = priority,
            onPriorityChanged = { priority -> sharedViewModel.priority.value = priority }
        )
    }
}

private fun displayToast(context: Context) {
    Toast.makeText(
        context,
        context.getString(R.string.empty_error_message),
        Toast.LENGTH_SHORT
    ).show()
}
