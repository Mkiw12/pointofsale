package se.kth.controller;

import java.util.List;
import se.kth.integration.*;
import se.kth.model.*;

/**
 * Manages the coordination between user interface and back-end system components, facilitating
 * the entire sales process from initiation to conclusion. This class integrates systems such as 
 * inventory management, accounting, sales logging, and receipt printing, ensuring seamless transaction
 * processing and data consistency.
 */
public class Controller {
    private ShoppingCart cart;
    private InventorySystem inventory;
    private AccountingSystem accounting;
    private SalesLog log;
    private Printer print;
    private Payment payment;

    /**
     * Initializes a new Controller instance, configuring all necessary components for operation.
     * This setup includes systems for managing inventory, financial transactions, sales logging,
     * and receipt printing, each essential for running the sales operations smoothly.
     */
    public Controller() {
        this.inventory = new InventorySystem();
        this.accounting = new AccountingSystem();
        this.log = new SalesLog();
        this.print = new Printer();
        this.payment = new Payment();
    }

    /**
     * Initiates a new sale by preparing a new shopping cart to collect items.
     * This method sets up a fresh state for handling a new customer transaction.
     */
    public void initiateSale() {
        this.cart = new ShoppingCart();
    }

    /**
     * Adds an item to the current sale based on its ID and specified quantity.
     * It checks inventory availability and updates the cart accordingly.
     *
     * @param itemId   the unique identifier of the item to be added
     * @param quantity the number of units of the item to add
     * @return the name of the item added if found and added successfully, otherwise null
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
     * Calculates the change to be returned to the customer given the amount paid.
     *
     * @param paidAmount the amount of money given by the customer
     * @return the amount of change to be returned
     */
    public double Change(double paidAmount) {
        return payment.calculateChange(paidAmount, getFinalCost());
    }

    /**
     * Finalizes the current sale by processing payment, updating relevant systems,
     * and printing the receipt with details of the transaction, including the total amount
     * and change due.
     *
     * @param amountP the total amount paid by the customer
     */
    public void endSale(double amountP) {
        accounting.updateRev();
        inventory.updateInventory();
        log.saveSaleInfo(cart);
        print.printReceipt(cart, amountP, payment);
    }

    /**
     * Checks whether a specified item ID exists within the inventory.
     *
     * @param itemID the ID of the item to validate
     * @return true if the item exists in the inventory, false otherwise
     */
    public boolean validateItemID(int itemID) {
        return inventory.findItemById(itemID) != null;
    }

    /**
     * Retrieves all items currently available for sale from the inventory.
     *
     * @return a list of all available items
     */
    public List<ItemDTO> getAvailableItems() {
        return inventory.getAllItems();
    }

    /**
     * Calculates the total cost of all items currently in the shopping cart.
     *
     * @return the total cost to be paid for the items in the cart
     */
    public double getFinalCost() {
        return cart.getTotalCost();
    }
}
