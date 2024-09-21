package com.example.countermvvm

// modal
data class CounterModel (var count : UInt)

//API or repository
class CounterRepository{
    private var _counter = CounterModel(count = 0u)
    fun getCounter() = _counter

    fun incrementCounter(){
        _counter.count++
    }
    fun decrementCounter(){
        _counter.count--
    }
}