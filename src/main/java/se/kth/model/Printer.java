package se.kth.model;



import java.time.LocalTime;

public class Printer {
    public void printReceipt(ShoppingCart cart) {
        LocalTime currentTime = LocalTime.now();
        Receipt receipt = new Receipt(cart, currentTime);
        String receiptText = receipt.createReceipt();

        System.out.println(receiptText); // Printing to console
        // Optionally, you could write this to a file instead.
    }
}
