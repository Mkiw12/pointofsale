package se.kth.model;

import java.util.ArrayList;
import java.util.List;
import se.kth.integration.*;


public class ShoppingCart {
    private List<ItemAndQuantity> items;
    private InventorySystem inventory; // Dependency on InventorySystem

    public ShoppingCart() {
        this.items = new ArrayList<>();
        
    }

    // Adds an item to the shopping cart by item ID and quantity
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

    public double getTotalCost() 
    {
        double totalCost = 0.0;
        for (ItemAndQuantity itemAndQuantity : items) {
            totalCost += itemAndQuantity.getItem().getPrice() * itemAndQuantity.getItem().getVAT() * itemAndQuantity.getQuantity();
        }
        return totalCost;
    }



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

    public double changeAmount() {
        double change = 0;

       // change = 

    }
}

