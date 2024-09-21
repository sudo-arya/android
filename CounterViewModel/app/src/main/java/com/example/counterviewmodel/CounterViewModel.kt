package com.example.counterviewmodel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class CounterViewModel() : ViewModel(){
    private val _count = mutableIntStateOf(0)
    val count: MutableState<Int> = _count
    fun increment() {
        _count.intValue += 1
    }
    fun decrement() {
        _count.intValue -= 1
    }
}