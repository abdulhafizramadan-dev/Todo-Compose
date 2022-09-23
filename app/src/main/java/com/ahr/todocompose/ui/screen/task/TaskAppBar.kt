package com.ahr.todocompose.ui.screen.task

import android.annotation.SuppressLint
import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.ahr.todocompose.R
import com.ahr.todocompose.data.entity.Priority
import com.ahr.todocompose.domain.ToDoTask
import com.ahr.todocompose.ui.theme.TodoComposeTheme
import com.ahr.todocompose.ui.theme.appBarContentColor
import com.ahr.todocompose.util.Action

@Composable
fun TaskAppBar() {

}

@Composable
fun NewTaskAppBar(navigateToListScreen: (Action) -> Unit) {
    TopAppBar(
        navigationIcon = {
            BackAction(onBackClicked = navigateToListScreen)
        },
        title = {
            Text(text = stringResource(id = R.string.add_task), color = MaterialTheme.colors.appBarContentColor)
        },
        actions = {
            AddAction(onAddClicked = navigateToListScreen)
        }
    )
}

@Composable
fun BackAction(onBackClicked: (Action) -> Unit) {
    IconButton(onClick = { onBackClicked(Action.NO_ACTION) }) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = stringResource(id = R.string.back),
            tint = MaterialTheme.colors.appBarContentColor
        )
    }
}

@Composable
fun AddAction(onAddClicked: (Action) -> Unit) {
    IconButton(onClick = { onAddClicked(Action.ADD) }) {
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = stringResource(R.string.save),
            tint = MaterialTheme.colors.appBarContentColor
        )
    }
}

@Composable
fun ExistingTaskAppBar(
    task: ToDoTask,
    navigateToListScreen: (Action) -> Unit
) {
    TopAppBar(
        navigationIcon = {
            CloseAction(onCloseClicked = navigateToListScreen)
        },
        title = {
            Text(
                text = task.title,
                color = MaterialTheme.colors.appBarContentColor,
                overflow = TextOverflow.Ellipsis
            )
        },
        actions = {
            DeleteAction(onDeleteClicked = navigateToListScreen)
            UpdateAction(onUpdateClicked = navigateToListScreen)
        }
    )
}

@Composable
fun CloseAction(onCloseClicked: (Action) -> Unit) {
    IconButton(onClick = { onCloseClicked(Action.NO_ACTION) }) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = stringResource(id = R.string.back),
            tint = MaterialTheme.colors.appBarContentColor
        )
    }
}

@Composable
fun DeleteAction(onDeleteClicked: (Action) -> Unit) {
    IconButton(onClick = { onDeleteClicked(Action.DELETE) }) {
        Icon(
            imageVector = Icons.Filled.Delete,
            contentDescription = stringResource(R.string.delete),
            tint = MaterialTheme.colors.appBarContentColor
        )
    }
}

@Composable
fun UpdateAction(onUpdateClicked: (Action) -> Unit) {
    IconButton(onClick = { onUpdateClicked(Action.UPDATE) }) {
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = stringResource(R.string.update),
            tint = MaterialTheme.colors.appBarContentColor
        )
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
@Preview(name = "Light Theme", uiMode = UI_MODE_NIGHT_NO)
@Preview(name = "Night Theme", uiMode = UI_MODE_NIGHT_YES)
fun NewTaskAppBarPreview() {
    TodoComposeTheme {
        Scaffold(topBar = {
            NewTaskAppBar(navigateToListScreen = {})
        }) {}
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
@Preview(name = "Light Theme", uiMode = UI_MODE_NIGHT_NO)
@Preview(name = "Night Theme", uiMode = UI_MODE_NIGHT_YES)
fun ExistingTaskAppBarPreview() {
    TodoComposeTheme {
        Scaffold(
            topBar = {
                ExistingTaskAppBar(
                    task = ToDoTask(
                        id = 1,
                        title = "Abdul Hafiz Ramadan",
                        description = "Some random text here...",
                        priority = Priority.HIGH
                    ),
                    navigateToListScreen = {}
                )
            }
        ) {}
    }
}