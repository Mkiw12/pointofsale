package se.kth.integration;



import se.kth.model.ShoppingCart;

import java.time.LocalTime;

import se.kth.model.Receipt;

public class Printer {
    public static void printReceipt(ShoppingCart cart) {
        LocalTime currentTime = LocalTime.now();
        Receipt receipt = new Receipt(cart, currentTime);
        String receiptText = receipt.createReceipt();

        System.out.println(receiptText); // Printing to console
        // Optionally, you could write this to a file instead.
    }
}
