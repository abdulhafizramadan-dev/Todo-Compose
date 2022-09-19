package com.ahr.todocompose.domain

import com.ahr.todocompose.data.entity.Priority
import com.ahr.todocompose.data.entity.ToDoTaskEntity

data class ToDoTask(
    val id: Int = 0,
    val title: String,
    val description: String,
    val priority: Priority
)

fun ToDoTask.asEntity(): ToDoTaskEntity =
    ToDoTaskEntity(
        id, title, description, priority
    )