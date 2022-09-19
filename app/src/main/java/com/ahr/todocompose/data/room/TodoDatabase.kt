package com.ahr.todocompose.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ahr.todocompose.data.entity.ToDoTaskEntity

@Database(entities = [ToDoTaskEntity::class], version = 1, exportSchema = false)
abstract class TodoDatabase : RoomDatabase() {

    abstract fun toDoDao(): ToDoDao

}