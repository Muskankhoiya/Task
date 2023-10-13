package com.bankingsystem.bank;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.bankingsystem.accounts.*;
import com.bankingsystem.customer.*;

public class Bank {
    private List<Customer> customers;
    private List<Account> accounts;
    private Map<Integer, Integer> customerToAccountMap;
    private int customerCounter = 1;
    private int accountCounter = 901;

    public Bank() {
        customers = new ArrayList<>();
        accounts = new ArrayList<>();
        customerToAccountMap = new HashMap<>();
    }

    // Method to create a new customer
    public void createCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your contact information: ");
        String contactInfo = scanner.nextLine();
        System.out.println("---------------------------------------------------------");
        Customer customer = new Customer(customerCounter, name, contactInfo);
        customers.add(customer);
        System.out.println("Customer account created with ID: " + customer.getCustomerId());
        System.out.println("---------------------------------------------------------");
        System.out.println("");
        System.out.println("");
        customerCounter++;
    }

    // Method to create a new bank account
    public void createAccount(int customerId, double initialBalance) {
        if (!customerToAccountMap.containsKey(customerId)) {
            Customer customer = findCustomerById(customerId);
            if (customer != null) {
                Account account = new Account(accountCounter, customer, initialBalance);
                accounts.add(account);
                customerToAccountMap.put(customerId, accountCounter);
                System.out.println("Account created with number: " + accountCounter);
                System.out.println("");
                System.out.println("");
                accountCounter++;
            } else {
                System.out.println("Customer not found.");
            }
        } else {
            System.out.println("An account already exists with this customer ID.");
        }
    }

    // Method to perform a transaction (transfer money between accounts)
    public void performTransaction(int fromAccountId, int toAccountId, double amount) {
        Account fromAccount = findAccountById(fromAccountId);
        Account toAccount = findAccountById(toAccountId);

        if (fromAccount != null && toAccount != null) {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
        }
    }

    // Method to display account details
    public void displayAccountDetails(int accountNumber) {
        Account account = findAccountById(accountNumber);
        if (account != null) {
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Account Holder Name: " + account.getAccountHolder().getName());
            System.out.println("Balance: $" + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    // Method to find a customer by their ID
    public Customer findCustomerById(int customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId() == customerId) {
                return customer;
            }
        }
        return null;
    }

    // Method to find an account by its number
    public Account findAccountById(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }
}
