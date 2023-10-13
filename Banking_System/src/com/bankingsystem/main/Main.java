package com.bankingsystem.main;
import com.bankingsystem.accounts.Account;
import com.bankingsystem.bank.Bank;
import com.bankingsystem.customer.Customer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("");
            System.out.println("");
            System.out.print("---------------------------------------------------------");
            System.out.println("\nWelcome to the User-Friendly Banking System!");
            System.out.println("---------------------------------------------------------");
            System.out.println(" ");
            System.out.println("1. Create Customer Account");
            System.out.println("2. Create Bank Account");
            System.out.println("3. Perform Transaction");
            System.out.println("4. Display Account Details");
            System.out.println("5. Find Customer by ID");
            System.out.println("6. Find Account by ID");
            System.out.println("7. Exit");
            System.out.print("Please choose an option (1-7): ");
            System.out.print(" ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            
            switch (option) {
                case 1:
                    System.out.print("---------------------------------------------------------");
                    System.out.println("\nCreate Customer Account:");
                    System.out.println("---------------------------------------------------------");
                    bank.createCustomer();
                    break;
                case 2:
                    System.out.print("---------------------------------------------------------");
                    System.out.println("\nCreate Bank Account:");
                    System.out.println("---------------------------------------------------------");
                    System.out.print("Enter customer ID: ");
                    int customerId = scanner.nextInt();
                    System.out.print("Enter initial balance: $");
                    double initialBalance = scanner.nextDouble();
                    System.out.println("---------------------------------------------------------");
                    bank.createAccount(customerId, initialBalance);
                    break;
                case 3:
                    System.out.print("---------------------------------------------------------");
                    System.out.println("\nPerform Transaction:");
                    System.out.println("---------------------------------------------------------");
                    System.out.print("Enter account number from which you want to transfer: ");
                    int fromAccountId = scanner.nextInt();
                    System.out.print("Enter account number to which you want to transfer: ");
                    int toAccountId = scanner.nextInt();
                    System.out.print("Enter the amount to transfer: $");
                    double amount = scanner.nextDouble();
                    bank.performTransaction(fromAccountId, toAccountId, amount);
                    break;
                case 4:
                    System.out.print("---------------------------------------------------------");
                    System.out.println("\nDisplay Account Details:");
                    System.out.println("---------------------------------------------------------");
                    System.out.print("Enter Account number: ");
                    int accountNumber = scanner.nextInt();
                    bank.displayAccountDetails(accountNumber);
                    break;
                case 5:
                    System.out.print("---------------------------------------------------------");
                    System.out.println("\nFind Customer by ID:");
                    System.out.println("---------------------------------------------------------");
                    System.out.print("Enter customer ID: ");
                    int findCustomerId = scanner.nextInt();
                    Customer foundCustomer = bank.findCustomerById(findCustomerId);
                    if (foundCustomer != null) {
                        System.out.println("Customer found:");
                        System.out.println("ID: " + foundCustomer.getCustomerId());
                        System.out.println("Name: " + foundCustomer.getName());
                        System.out.println("Contact Info: " + foundCustomer.getContactInfo());
                        System.out.print("");
                        System.out.print("");
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;
                case 6:
                    System.out.print("---------------------------------------------------------");
                    System.out.println("\nFind Account by ID:");
                    System.out.println("---------------------------------------------------------");
                    System.out.print("Enter account number: ");
                    int findAccountNumber = scanner.nextInt();
                    Account foundAccount = bank.findAccountById(findAccountNumber);
                    if (foundAccount != null) {
                        System.out.println("Account found:");
                        System.out.println("Account Number: " + foundAccount.getAccountNumber());
                        System.out.println("Account Holder: " + foundAccount.getAccountHolder().getName());
                        System.out.println("Balance: $" + foundAccount.getBalance());
                        System.out.print("---------------------------------------------------------");
                        System.out.print("");
                        System.out.print("");
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 7:
                    System.out.println("\nThank you for using the User-Friendly Banking System!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
