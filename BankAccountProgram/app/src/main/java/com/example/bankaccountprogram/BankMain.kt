package com.example.bankaccountprogram

fun main(){
    val dobyBankAccount = BankAccount("Doby Arya",5000.00)

    dobyBankAccount.deposit(5200.00)
    dobyBankAccount.withdraw(4849.50)
    dobyBankAccount.deposit(52.00)
    dobyBankAccount.displayTransactionHistory()
    dobyBankAccount.balanceCheck()

    val sarahBankAccount = BankAccount("Sarah",0.0)
    sarahBankAccount.deposit(100.0)
    sarahBankAccount.withdraw(10.0)
    sarahBankAccount.deposit(300.0)
    sarahBankAccount.displayTransactionHistory()
    sarahBankAccount.balanceCheck()


}