package se.kth.controller;

import se.kth.integration.InventorySystem;
import se.kth.model.ShoppingCart;
import se.kth.model.ItemDTO;

public class Controller {
    private ShoppingCart cart;
    private InventorySystem inventory;

    public Controller(InventorySystem inventory) {
        this.inventory = inventory;
        this.cart = new ShoppingCart(); // Initialize the shopping cart here or in initiateSale
    }

    public void initiateSale() {
        // Reset or prepare the shopping cart for a new sale
        this.cart = new ShoppingCart(); // Optionally create a new cart for each sale
        System.out.println("New sale has started.");
    }

    public void scanItems(int itemId, int quantity) {
        ItemDTO item = inventory.findItemById(itemId);
        if (item != null) {
            cart.addItem(item, quantity);
            System.out.println("Added " + quantity + " of " + item.getItemName() + " to the cart.");
        } else {
            System.out.println("Item with ID " + itemId + " not found.");
        }
    }

    public void endSale() {
        double total = cart.getTotalCost();
        System.out.println("Sale completed. Total due: $" + total);
        // Here you might also want to update inventory and log the sale details
    }
}
