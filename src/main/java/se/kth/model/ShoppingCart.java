
package se.kth.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a shopping cart used in a retail transaction.
 * The cart manages a collection of items and their quantities, allowing items to be added or modified.
 */
public class ShoppingCart {
    private List<ItemAndQuantity> items; // List to hold items along with their quantities

    /**
     * Constructs an empty shopping cart.
     */
    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    /**
     * Adds an item to the shopping cart or updates the quantity of an existing item.
     * If the item is already present in the cart, it increases the quantity. Otherwise, it adds a new entry.
     *
     * @param item     the item to add to the cart
     * @param quantity the quantity of the item to be added
     * @return the updated list of items and quantities in the cart
     */
    public List<ItemAndQuantity> addItem(ItemDTO item, int quantity) {
        int itemId = item.getItemId();
        boolean itemAlreadyRegistered = false;
        
        for (ItemAndQuantity currentIterationItem : items) {
            if (currentIterationItem.getItem().getItemId() == itemId) {
                // Update existing item's quantity
                currentIterationItem.setQuantity(currentIterationItem.getQuantity() + quantity);
                itemAlreadyRegistered = true;
                System.out.println("Added " + quantity + " of " + item.getItemName() + " to the cart.");
                break; // Break as we've found and updated the item
            }
        }

        if (!itemAlreadyRegistered) {
            // If the item was not found in the list, add it as a new entry
            items.add(new ItemAndQuantity(item, quantity));
        }

        return items;
    }

    /**
     * Calculates the total cost of all items in the cart, including applicable taxes.
     *
     * @return the total cost of items in the cart
     */
    public double getTotalCost() {
        double totalCost = 0.0;
        for (ItemAndQuantity itemAndQuantity : items) {
            totalCost += itemAndQuantity.getItem().getPrice() * itemAndQuantity.getItem().getVAT() * itemAndQuantity.getQuantity();
        }
        return totalCost;
    }

    /**
     * Retrieves a copy of the list of items and quantities in the shopping cart.
     * This prevents the original list from being modified externally.
     *
     * @return a copy of the list of items and their quantities
     */
    public List<ItemAndQuantity> getItems() {
        return new ArrayList<>(this.items); // Return a copy of the list to prevent external modifications
    }

    public double getVatTotal() {
        double totVat = 0;

        for (ItemAndQuantity itemQuantity : items) {
            ItemDTO item = itemQuantity.getItem();
            int quantity = itemQuantity.getQuantity();
            double price = item.getPrice();
            double VATRate = item.getVAT(); // Assuming getVAT returns a decimal representing the VAT rate (e.g., 1.20 for 20% VAT)
            totVat += (price * VATRate - price) * quantity; // Calculate VAT for each item
        }
        return totVat;
    }

    /*public double calculateChange(double amountPaid, double totalCost) 
    {
        return Math.max(0, amountPaid - totalCost); // Ensure that the change is not negative
    }*/
}

