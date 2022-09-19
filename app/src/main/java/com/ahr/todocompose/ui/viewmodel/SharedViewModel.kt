package com.ahr.todocompose.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahr.todocompose.data.repository.ToDoRepository
import com.ahr.todocompose.domain.ToDoTask
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val toDoRepository: ToDoRepository
) : ViewModel() {

    private val _allTasks = MutableStateFlow<List<ToDoTask>>(emptyList())
    val allTasks get() = _allTasks.asStateFlow()

    init {
        viewModelScope.launch {
            toDoRepository.getAllTasks.collect {
                _allTasks.value = it
            }
        }
    }

}