package com.example.kotlinbasics

data class coffeeDetails(val name: String, val sugarCount: Int, val size: String,val creamAmount:
Int)

fun main(){
    /*
    // integer numbers
    val myAge : Byte = 20
    println("Heloo my nigga!! of $myAge")

    // decimal numbers
    val pi = 3.14f
    println(pi)

    // unsigned int
    var age : UByte = 45u
    println(age)

    // boolean
    val myTrue = true
    val myFalse = false
    println(myTrue || myFalse)  // ||   OR operator
    println(myTrue && myFalse)  // &&   AND operator
    println(!myTrue)            // !    NOT operator


    //character
    val mychar = '\u00AE'
    println(mychar)

    //string
    val str ="how are u doing ??"
    println(str.uppercase()+" Arya.")

    // comparison operators     >, <, >=, <=, ==
    println("Enter you age in number :-")
    age = readln().toUByte()
    if (age < 18u){
        //execute if condition is true
        println("u can't vote yet :(")
    }else{
        //executed when condition is false
        println("u can vote :)")
    }

     */

//    Day-3 started from here
/*
    println("Enter first number :-")
    val num1 = readln().toInt()
    println("Enter Second number :-")
    val num2 = readln().toInt()
    val result = add(num1,num2)
    println("Sum of two numbers is $result")
*/

//    Classes and objects
//    Creating an Object/Instance of a class Dog
    var Dyno = Dog("Dyno","German Shepherd",5)
    println("${Dyno.name} is a ${Dyno.breed} and is ${Dyno.age} yrs old")

    val coffeeForDyno = coffeeDetails("Dyno",2,"xl",5)
    makeCoffee(coffeeForDyno)



//    Day-4 started from here

}

//Define a function
fun add(num1 : Int,num2 : Int) :Int {
    return num1+num2
}

fun userDetail(){
    println("Who is this coffee is for ??")
    val name = readln()
    println("How many spoon/spoons of sugar do you want ??")
    val sugarCount = readln().toInt()
//    call a function
//    makeCoffee(name,sugarCount)

}

fun makeCoffee(coffeeDetails: coffeeDetails){
//    not returning any type
    when (coffeeDetails.sugarCount) {
        1 -> {
            println("Coffee with ${coffeeDetails.sugarCount} spoon of sugar for ${coffeeDetails.name};)")
        }
        0 -> {
            println("Coffee with no sugar for ${coffeeDetails.name} ;)")
        }
        else -> {
            println("Coffee with ${coffeeDetails.sugarCount} spoons of sugar for ${coffeeDetails
                .name} ;)")
        }
    }
}