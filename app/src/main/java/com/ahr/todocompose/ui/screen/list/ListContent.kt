package com.ahr.todocompose.ui.screen.list

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.ahr.todocompose.data.entity.Priority
import com.ahr.todocompose.domain.ToDoTask
import com.ahr.todocompose.ui.theme.MEDIUM_PADDING
import com.ahr.todocompose.ui.theme.PRIORITY_INDICATOR_SIZE
import com.ahr.todocompose.ui.theme.SMALL_PADDING
import com.ahr.todocompose.ui.theme.TASK_ITEM_ELEVATION

@Composable
fun ListContent() {

}

@ExperimentalMaterialApi
@Composable
fun TaskItem(
    toDoTask: ToDoTask,
    navigateToTaskScreen: (Int) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colors.surface,
        shape = RectangleShape,
        elevation = TASK_ITEM_ELEVATION,
        onClick = {
            navigateToTaskScreen(toDoTask.id)
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(MEDIUM_PADDING)
        ) {
            Row {
                Text(
                    text = toDoTask.title,
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(9F)
                )
                Box(contentAlignment = Alignment.TopEnd, modifier = Modifier.weight(1F)) {

                }
                Canvas(modifier = Modifier.size(PRIORITY_INDICATOR_SIZE)) {
                    drawCircle(toDoTask.priority.color)
                }
            }
            Text(
                text = toDoTask.description,
                style = MaterialTheme.typography.subtitle1,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.fillMaxWidth().padding(top = SMALL_PADDING)
            )
        }
    }
}

@ExperimentalMaterialApi
@Composable
@Preview
private fun TaskItemPreview() {
    TaskItem(
        toDoTask = ToDoTask(id = 1, "Title", "Description", Priority.HIGH),
        navigateToTaskScreen = {}
    )
}