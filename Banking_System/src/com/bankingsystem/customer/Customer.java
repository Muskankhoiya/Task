package com.bankingsystem.customer;

public class Customer {
    private int customerId;
    private String name;
    private String contactInfo;

    // Constructor to initialize a customer
    public Customer(int customerId, String name, String contactInfo) {
        this.customerId = customerId;
        this.name = name;
        this.contactInfo = contactInfo;
    }

    // Getter method to retrieve the customer's ID
    public int getCustomerId() {
        return customerId;
    }

    // Getter method to retrieve the customer's name
    public String getName() {
        return name;
    }

    // Getter method to retrieve the customer's contact information
    public String getContactInfo() {
        return contactInfo;
    }
}
