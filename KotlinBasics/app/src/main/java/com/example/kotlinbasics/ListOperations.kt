package com.example.kotlinbasics

fun main(){
    val fruitsList = mutableListOf("Apple","Mango","Guava","Banana","Dragon fruit")
    println(fruitsList)
    fruitsList.add("Pineapple")
    println(fruitsList)
    fruitsList.remove("Guava")
    println(fruitsList)
    val checks = fruitsList.contains("Guava")
    if (checks) println("Fruit presents :)")
    else println("fruit not present :(")
}