package com.ahr.todocompose.ui.component

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahr.todocompose.R
import com.ahr.todocompose.data.entity.Priority
import com.ahr.todocompose.ui.theme.PRIORITY_INDICATOR_SIZE
import com.ahr.todocompose.ui.theme.TodoComposeTheme

@Composable
fun PriorityDropDown(
    priority: Priority,
    onPrioritySelected: (Priority) -> Unit
) {

    var expanded by remember { mutableStateOf(false) }
    val listOfPriority = Priority.values()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .clickable { expanded = !expanded }
            .border(1.dp, MaterialTheme.colors.onSurface.copy(ContentAlpha.disabled)),
    verticalAlignment = Alignment.CenterVertically
    ) {
        Canvas(
            modifier = Modifier
                .size(PRIORITY_INDICATOR_SIZE)
                .weight(1f)
        ) {
            drawCircle(priority.color)
        }
        Text(
            modifier = Modifier.weight(8f),
            text = priority.name,
            style = MaterialTheme.typography.h5
        )
        Icon(
            modifier = Modifier.weight(1.5f),
            imageVector = Icons.Filled.ArrowDropDown,
            contentDescription = stringResource(R.string.arrow_drop_down)
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = !expanded },
            modifier = Modifier.fillMaxWidth()
        ) {
            listOfPriority.forEach { priority ->
                DropdownMenuItem(onClick = {
                    expanded = !expanded
                    onPrioritySelected(priority)
                }) {
                    PriorityItem(priority = priority)
                }
            }
        }

    }
}

@Composable
@Preview(name = "Light Theme", uiMode = UI_MODE_NIGHT_NO)
@Preview(name = "Night Theme", uiMode = UI_MODE_NIGHT_YES)
private fun PriorityDropDownPreview() {
    TodoComposeTheme {
        Surface {
            PriorityDropDown(priority = Priority.HIGH, onPrioritySelected = {})
        }
    }
}