package com.ahr.todocompose.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahr.todocompose.data.entity.Priority
import com.ahr.todocompose.data.repository.ToDoRepository
import com.ahr.todocompose.domain.RequestState
import com.ahr.todocompose.domain.ToDoTask
import com.ahr.todocompose.util.Constant.MAX_TITLE_LIMIT
import com.ahr.todocompose.util.SearchAppBarState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val toDoRepository: ToDoRepository
) : ViewModel() {

    val id: MutableState<Int> = mutableStateOf(0)
    val title: MutableState<String> = mutableStateOf("")
    val description: MutableState<String> = mutableStateOf("")
    val priority: MutableState<Priority> = mutableStateOf(Priority.LOW)

    private val _allTasks = MutableStateFlow<RequestState<List<ToDoTask>>>(RequestState.Idle)
    val allTasks get() = _allTasks.asStateFlow()

    val searchAppBarState: MutableState<SearchAppBarState> =
        mutableStateOf(SearchAppBarState.CLOSED)
    val searchTextState: MutableState<String> = mutableStateOf("")

    init {
        _allTasks.value = RequestState.Loading
        viewModelScope.launch {
            toDoRepository.getAllTasks
                .catch { error ->
                    _allTasks.value = RequestState.Error(error)
                }
                .collect { tasks ->
                    _allTasks.value = RequestState.Success(tasks)
                }
        }
    }

    private val _selectedTask = MutableStateFlow<ToDoTask?>(null)
    val selectedTask get() = _selectedTask.asStateFlow()

    fun getSelectedTask(taskId: Int) {
        viewModelScope.launch {
            toDoRepository.getSelectedTask(taskId).collect { task ->
                _selectedTask.value = task
            }
        }
    }

    fun updateTaskFields(task: ToDoTask?) {
        if (task != null) {
            id.value = task.id
            title.value = task.title
            description.value = task.description
            priority.value = task.priority
        } else {
            id.value = 0
            title.value = ""
            description.value = ""
            priority.value = Priority.LOW
        }
    }

    fun updateTitleWithLimit(newTitle: String) {
        if (newTitle.length < MAX_TITLE_LIMIT) {
            title.value = newTitle
        }
    }

    fun validateFields(): Boolean {
        return title.value.isNotEmpty() && description.value.isNotEmpty()
    }
}