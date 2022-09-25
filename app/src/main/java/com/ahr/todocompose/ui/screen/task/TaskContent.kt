package com.ahr.todocompose.ui.screen.task

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.ahr.todocompose.R
import com.ahr.todocompose.data.entity.Priority
import com.ahr.todocompose.ui.component.PriorityDropDown
import com.ahr.todocompose.ui.theme.LARGE_PADDING
import com.ahr.todocompose.ui.theme.MEDIUM_PADDING
import com.ahr.todocompose.ui.theme.TodoComposeTheme

@Composable
fun TaskContent(
    title: String,
    onTitleChanged: (String) -> Unit,
    description: String,
    onDescriptionChanged: (String) -> Unit,
    priority: Priority,
    onPriorityChanged: (Priority) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = LARGE_PADDING)
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth().padding(bottom = MEDIUM_PADDING),
            value = title,
            onValueChange = onTitleChanged,
            singleLine = true,
            textStyle = MaterialTheme.typography.body1,
            placeholder = {
                Text(text = stringResource(R.string.title))
            }
        )
        PriorityDropDown(priority = priority, onPrioritySelected = onPriorityChanged)
        OutlinedTextField(
            modifier = Modifier.fillMaxSize().padding(top = MEDIUM_PADDING),
            value = description,
            onValueChange = onDescriptionChanged,
            textStyle = MaterialTheme.typography.body1,
            placeholder = {
                Text(text = stringResource(R.string.description))
            }
        )
    }
}

@Composable
@Preview(name = "Light Mode", uiMode = UI_MODE_NIGHT_NO)
@Preview(name = "Night Mode", uiMode = UI_MODE_NIGHT_YES)
private fun TaskContentPreview() {
    TodoComposeTheme {
        Surface {
            TaskContent(
                title = "",
                onTitleChanged = {},
                description = "",
                onDescriptionChanged = {},
                priority = Priority.LOW,
                onPriorityChanged = {}
            )
        }
    }
}