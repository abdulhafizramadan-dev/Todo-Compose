package com.ahr.todocompose.domain

sealed interface RequestState<out T> {
    object Idle : RequestState<Nothing>
    object Loading : RequestState<Nothing>
    data class Success<out T>(val data: T): RequestState<T>
    data class Error(val error: Throwable): RequestState<Nothing>
}