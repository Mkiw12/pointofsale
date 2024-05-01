
package se.kth.model;

import java.time.LocalTime;
import java.util.List;

/**
 * Handles the creation of a receipt for a transaction. The receipt includes details about the items purchased,
 * the time of sale, prices, taxes, and total cost.
 */
public class Receipt {

    private ShoppingCart cart;      // The shopping cart containing the purchased items
    private LocalTime saleTime;     // The time when the sale was completed

    /**
     * Constructs a Receipt with the specified shopping cart and sale time.
     *
     * @param cart the ShoppingCart containing the items and their quantities
     * @param saleTime the time when the sale was finalized
     */
    public Receipt(ShoppingCart cart, LocalTime saleTime) {
        this.cart = cart;
        this.saleTime = saleTime;
    }

    /**
     * Generates a formatted receipt string based on the shopping cart contents and sale time.
     * The receipt includes a list of items, their quantities, prices, and the total cost, including tax.
     *
     * @return the formatted receipt string
     */
    public String createReceipt() {
        StringBuilder receipt = new StringBuilder();
        receipt.append("RECEIPT\n");
        receipt.append("--------------------------------------------------\n");

        List<ItemAndQuantity> items = cart.getItems();
        receipt.append("Time => ").append(saleTime.toString()).append("\n");
        for (ItemAndQuantity item : items) {
            receipt.append(item.getItem().getItemName())
                   .append(" - Qty: ")
                   .append(item.getQuantity())
                   .append(" - Price: $")
                   .append(item.getItem().getPrice())
                   .append(" - Subtotal: $")
                   .append(item.getQuantity() * item.getItem().getPrice())
                   .append(" - Taxrate ")
                   .append(item.getItem().getVAT()-1)
                   .append("\n");
        }

        receipt.append("--------------------------------------------------\n");
        receipt.append("Total: $").append(cart.getTotalCost()).append("\n");
        receipt.append("Thank you for your purchase!\n");

        return receipt.toString();
    }
}



