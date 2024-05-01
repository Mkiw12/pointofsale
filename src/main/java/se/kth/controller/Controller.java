package se.kth.controller;

import se.kth.integration.*;
import se.kth.model.*;

public class Controller {
    private ShoppingCart cart;
    private InventorySystem inventory;
    private Sale currentSale;  // Instance variable to keep track of the current sale


    public Controller(InventorySystem inventory) {
        this.inventory = inventory;
        this.cart = new ShoppingCart(); // Initialize the shopping cart here or in initiateSale
        
    }

    public void initiateSale() {
        // Reset or prepare the shopping cart for a new sale
        this.currentSale = new Sale();  // Create a new sale for each transaction
        this.cart = new ShoppingCart(); // Optionally create a new cart for each sale
        //System.out.println("New sale has started.");
    }

    public Sale getCurrentSale()
    {
        return currentSale;
    }
    

    /*public void scanItems(int itemId, int quantity) {
        ItemDTO item = inventory.findItemById(itemId);
        if (item != null) {
            cart.addItem(item, quantity);
            //System.out.println("Added " + quantity + " of " + item.getItemName() + " to the cart.");
        } else {
            //System.out.println("Item with ID " + itemId + " not found.");
        }
    }*/
    public boolean regItems(int itemId, int quantity) {
        ItemDTO item = inventory.findItemById(itemId);
        if (item != null) {
            cart.addItem(item, quantity);
            return true;
        } else {
            return false;
        }
    }

    public void endSale() {
        //double total = cart.getTotalCost();
        //System.out.println("Sale completed. Total due: $" + total);
        // Here you might also want to update inventory and log the sale details
        //return total;
        // Example usage in the View or Controller
        Printer.printReceipt(cart);

    }

    public boolean validateItemID(int itemID) {
        return inventory.findItemById(itemID) != null;
    }

}
