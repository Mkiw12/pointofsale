/*package se.kth.controller;

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
        //this.currentSale = new Sale();  // Create a new sale for each transaction
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
*/
package se.kth.controller;

import java.util.List;

import se.kth.integration.*;
import se.kth.model.*;

import se.kth.model.payment;

/**
 * The Controller class manages interactions between the UI and the system's core functionalities,
 * including inventory, accounting, sales logging, and receipt printing. It handles the lifecycle
 * of a sale from initiation to completion.
 */
public class Controller {
    private ShoppingCart cart;
    private InventorySystem inventory;
    private AccountingSystem accounting;
    private SalesLog log;
    private Sale currentSale; // Instance variable to keep track of the current sale
    private Printer print;
    private Payment payment;

    /**
     * Constructs a new Controller object with specified systems and utilities.
     *
     * @param inventory the inventory system to be used for item data and updates
     * @param accounting the accounting system to manage financial transactions
     * @param log the sales log to record transactions
     * @param print the printer system to output receipts
     */
    public Controller(InventorySystem inventory, AccountingSystem accounting, SalesLog log, Printer print, Payment payment) {
        this.inventory = inventory;
        this.accounting = accounting;
        this.log = log;
        this.print = print;
        this.payment = payment;
    }

    /**
     * Initiates a new sale, preparing the shopping cart and setting up necessary state.
     */
    public void initiateSale() {
        this.cart = new ShoppingCart();
    }

    /**
     * Returns the current sale instance.
     *
     * @return the current ongoing sale
     */
    public Sale getCurrentSale() {
        return currentSale;
    }

    /**
     * Registers items into the current sale based on item ID and quantity.
     * Updates the shopping cart and checks inventory for item existence.
     *
     * @param itemId   the ID of the item to be added
     * @param quantity the quantity of the item to be added
     * @return the name of the item added, or null if the item does not exist
     */
    public String regItems(int itemId, int quantity) {
        ItemDTO item = inventory.findItemById(itemId);
        if (item != null) {
            cart.addItem(item, quantity);
            return item.getItemName();
        } else {
            return null;
        }
    }

    /**
     * Completes the current sale, handles financial transactions, updates inventory,
     * logs the sale information, and prints the receipt.
     */
    public void endSale() {
        accounting.updateRev();
        inventory.updateInventory();
        log.saveSaleInfo();
        print.printReceipt(cart);
    }

    /**
     * Validates if an item ID exists in the inventory.
     *
     * @param itemID the item ID to be checked
     * @return true if the item exists in inventory, false otherwise
     */
    public boolean validateItemID(int itemID) {
        return inventory.findItemById(itemID) != null;
    }

    /**
     * Retrieves a list of all available items in the inventory.
     *
     * @return a list of items available for sale
     */
    public List<ItemDTO> getAvailableItems() {
        return inventory.getAllItems();
    }
}
