package com.ahr.todocompose.di

import android.content.Context
import androidx.room.Room
import com.ahr.todocompose.data.room.ToDoDao
import com.ahr.todocompose.data.room.TodoDatabase
import com.ahr.todocompose.util.Constant.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideToDoDatabase(
        @ApplicationContext
        context: Context
    ): TodoDatabase =
        Room.databaseBuilder(
            context,
            TodoDatabase::class.java,
            DATABASE_NAME
        ).build()

    @Singleton
    @Provides
    fun provideToDoDao(
        todoDatabase: TodoDatabase
    ): ToDoDao = todoDatabase.toDoDao()
}