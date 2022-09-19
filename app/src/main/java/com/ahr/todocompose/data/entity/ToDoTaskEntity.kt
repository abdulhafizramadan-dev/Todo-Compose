package com.ahr.todocompose.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ahr.todocompose.util.Constant.DATABASE_TABLE

@Entity(tableName = DATABASE_TABLE)
data class ToDoTaskEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val priority: Priority
)
