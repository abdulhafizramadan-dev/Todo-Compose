package com.ahr.todocompose.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahr.todocompose.data.repository.ToDoRepository
import com.ahr.todocompose.domain.RequestState
import com.ahr.todocompose.domain.ToDoTask
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

}