package com.example.rockpaperscissor

fun main() {
    var computerChoice = ""
    var userChoice = ""
    println("Enter your choice :- ")
    println("rock, paper, or scissor")
    while (true) {
        computerChoice = when ((1..3).random()) {
            1 -> "rock"
            2 -> "paper"
            else -> "scissor"
        }
        var flag = 0
        while (flag == 0) {
            userChoice = readln().toString().lowercase()
            flag = when (userChoice) {
                "rock" -> 1
                "paper" -> 1
                "scissor" -> 1
                else -> 0
            }
            if(flag == 0) println("Enter choice correctly :-")
        }
        println(computerChoice)
        val winner = when {
            userChoice == computerChoice -> "Tie"
            userChoice == "rock" && computerChoice == "scissor" -> "user"
            userChoice == "paper" && computerChoice == "rock" -> "user"
            userChoice == "scissor" && computerChoice == "paper" -> "user"

            else -> "computer"
        }
        when (winner) {
            "Tie" -> println("It's a tie !!")
            "user" -> println("You Won ;)")
            else -> println("Computer won :(")
        }
    }
}