package com.ahr.todocompose.ui.component

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahr.todocompose.data.entity.Priority
import com.ahr.todocompose.ui.theme.TodoComposeTheme

@Composable
fun PriorityItem(priority: Priority) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(horizontal = 4.dp)) {
        Canvas(
            modifier = Modifier
                .size(20.dp)
                .padding(end = 8.dp)
        ) {
            drawCircle(priority.color)
        }
        Text(text = priority.name.capitalize(Locale.current))
    }
}

@Composable
@Preview(name = "Light Mode", uiMode = UI_MODE_NIGHT_NO)
@Preview(name = "Night Mode", uiMode = UI_MODE_NIGHT_YES)
private fun PriorityItemPreview() {
    TodoComposeTheme {
        Surface {
            PriorityItem(priority = Priority.HIGH)

        }
    }
}