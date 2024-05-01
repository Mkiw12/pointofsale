package se.kth.controller;

import java.util.List;

import se.kth.integration.*;
import se.kth.model.*;

public class Controller {
    private ShoppingCart cart;
    private InventorySystem inventory;
    private AccountingSystem accounting;
    private SalesLog log;
    private Sale currentSale;  // Instance variable to keep track of the current sale
    private Printer print;


    public Controller(InventorySystem inventory, AccountingSystem accounting, SalesLog log, Printer print) {
        this.inventory = inventory;
        this.accounting = accounting;
        this.log = log;
        this.print = print;
        //this.cart = new ShoppingCart(); // Initialize the shopping cart here or in initiateSale
        
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
    


    public String regItems(int itemId, int quantity) {
        ItemDTO item = inventory.findItemById(itemId);
        if (item != null) {
            cart.addItem(item, quantity);
            return item.getItemName();
        } else {
            return null;
        }
    }

    public void endSale() {
        //double total = cart.getTotalCost();
        //System.out.println("Sale completed. Total due: $" + total);
        // Here you might also want to update inventory and log the sale details
        //return total;
        // Example usage in the View or Controller
        accounting.updateRev();
        inventory.updateInventory();
        log.saveSaleInfo();
        print.printReceipt(cart);

    }

    public boolean validateItemID(int itemID) {
        return inventory.findItemById(itemID) != null;
    }

    public List<ItemDTO> getAvailableItems() {
        return inventory.getAllItems();
    }

}
