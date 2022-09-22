package com.ahr.todocompose.ui.screen.list

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahr.todocompose.R
import com.ahr.todocompose.ui.theme.TodoComposeTheme

@Composable
fun EmptyListContent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier.size(120.dp),
            painter = painterResource(id = R.drawable.ic_sad_face),
            contentDescription = stringResource(id = R.string.no_tasks_found),
            tint = Color.DarkGray
        )
        Text(
            text = stringResource(id = R.string.no_tasks_found),
            fontStyle = MaterialTheme.typography.subtitle1.fontStyle,
            color = Color.DarkGray
        )
    }
}

@Composable
@Preview(name = "Light Theme", uiMode = UI_MODE_NIGHT_NO)
@Preview(name = "Night Theme", uiMode = UI_MODE_NIGHT_YES)
private fun EmptyListContentPreview() {
    TodoComposeTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            EmptyListContent()
        }
    }
}