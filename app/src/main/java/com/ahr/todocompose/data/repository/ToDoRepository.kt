package com.ahr.todocompose.data.repository

import com.ahr.todocompose.data.entity.ToDoTaskEntity
import com.ahr.todocompose.data.entity.asDomain
import com.ahr.todocompose.data.room.ToDoDao
import com.ahr.todocompose.domain.ToDoTask
import com.ahr.todocompose.domain.asEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ToDoRepository @Inject constructor(private val toDoDao: ToDoDao) {

    val getAllTasks: Flow<List<ToDoTask>> = toDoDao.getAllTasks().map { it.asDomain() }
    val sortedByLowPriority: Flow<List<ToDoTask>> = toDoDao.sortByLowPriority().map { it.asDomain() }
    val sortedByHighPriority: Flow<List<ToDoTask>> = toDoDao.sortByHighPriority().map { it.asDomain() }

    fun getSelectedTask(taskId: Int): Flow<ToDoTask> {
        return toDoDao.getSelectedTask(taskId).map { it.asDomain() }
    }

    fun searchTask(searchQuery: String): Flow<List<ToDoTask>> {
        return toDoDao.searchTask(searchQuery).map { it.asDomain() }
    }

    suspend fun addTask(toDoTask: ToDoTask) {
        toDoDao.addTask(toDoTask.asEntity())
    }

    suspend fun updateTask(toDoTask: ToDoTask) {
        toDoDao.updateTask(toDoTask.asEntity())
    }

    suspend fun deleteTask(toDoTask: ToDoTask) {
        toDoDao.deleteTask(toDoTask.asEntity())
    }

    suspend fun deleteAllTasks() {
        toDoDao.deleteAllTasks()
    }
}