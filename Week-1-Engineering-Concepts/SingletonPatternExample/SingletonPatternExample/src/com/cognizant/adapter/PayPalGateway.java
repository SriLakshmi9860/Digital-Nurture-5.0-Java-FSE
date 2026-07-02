package com.cognizant.adapter;

public class PayPalGateway {

    public void makePayment(double amount) {
        System.out.println("Payment of ₹" + amount + " processed using PayPal.");
    }
}