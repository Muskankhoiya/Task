package com.bankingsystem.accounts;
import com.bankingsystem.customer.Customer;

public class Account {
    private int accountNumber;
    private Customer accountHolder;
    private double balance;

    // Constructor to initialize the account
    public Account(int accountNumber, Customer accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    // Getters to retrieve account information
    public int getAccountNumber() {
        return accountNumber;
    }

    public Customer getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    // Deposit method to add money to the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("---------------------------------------------------------");
            System.out.println("Deposited $" + amount + " to Account " + accountNumber);
        }
    }

    // Withdraw method to subtract money from the account
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("---------------------------------------------------------");
            System.out.println("Withdrawn $" + amount + " from Account " + accountNumber);
        } else {
            System.out.println("Insufficient funds in Account " + accountNumber);
        }
    }
}
