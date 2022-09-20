package com.ahr.todocompose.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val LightGray = Color(0XFFFCFCFC)
val MediumGray = Color(0XFF9C9C9C)
val DarkGray = Color(0XFF141414)

val LowPriorityColor = Color(0XFF00C980)
val MediumPriorityColor = Color(0XFFFFC114)
val HighPriorityColor = Color(0XFFFF4646)
val NonePriorityColor = Color(0XFF9C9C9C)

val Colors.fabBackgroundColor: Color
    @Composable
    get() = if (isLight) Teal200 else Purple700

val Colors.appBarContentColor: Color
    @Composable
    get() = if (isLight) Color.White else LightGray