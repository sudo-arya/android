package com.example.bankaccountprogram

class BankAccount(var accountHolder: String,var balance: Double) {
    init {

    }
    private val transactionHistory = mutableListOf<String>()
    fun deposit(amount: Double){
        balance+=amount
        transactionHistory.add("$accountHolder deposited $$amount")
    }
    fun withdraw(amount: Double){
        if(amount <= balance) {
            balance -= amount
            transactionHistory.add("$accountHolder withdraws $$amount")
        }else{
            println("!! Insufficient funds for this transactions !!")
        }
    }
    fun balanceCheck(){
        println("Balance in $accountHolder account is $$balance")
    }
    fun displayTransactionHistory(){
        println("Transaction history for $accountHolder")
        for (transaction in transactionHistory){
            println(transaction)
        }
    }
}