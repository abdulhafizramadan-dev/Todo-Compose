package com.ahr.todocompose.data.entity

import androidx.compose.ui.graphics.Color
import com.ahr.todocompose.ui.theme.HighPriorityColor
import com.ahr.todocompose.ui.theme.LowPriorityColor
import com.ahr.todocompose.ui.theme.MediumPriorityColor
import com.ahr.todocompose.ui.theme.NonePriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}