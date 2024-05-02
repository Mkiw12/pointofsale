
package se.kth.integration;

import java.time.LocalTime;

import se.kth.model.Receipt;
import se.kth.model.ShoppingCart;
import se.kth.model.Payment;

/**
 * Handles the printing of receipts for transactions processed within the system.
 * This class is responsible for generating a textual representation of a receipt based on the contents of a shopping cart.
 */
public class Printer {

    /**
     * Prints a receipt for the current transaction encapsulated by the provided ShoppingCart.
     * The receipt includes details such as the time of the transaction and the items purchased.
     *
     * @param cart the ShoppingCart containing the items and quantities purchased
     */
    public void printReceipt(ShoppingCart cart, double amountP, Payment paid) {
        LocalTime currentTime = LocalTime.now();
        Receipt receipt = new Receipt(cart, currentTime, paid);
        String receiptText = receipt.createReceipt(amountP);

        System.out.println(receiptText); 
        
    }
}

