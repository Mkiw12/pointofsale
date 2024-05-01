
package se.kth.startup;

import se.kth.controller.Controller;
import se.kth.view.*;
import se.kth.integration.*;
import se.kth.model.Payment;

/**
 * Main class for starting the application. This class initializes all necessary components of the system,
 * including the inventory, accounting, sales log, and the controller, and then starts the user interface.
 */
public class Main {
    private InventorySystem inventory;
    private AccountingSystem accounting;
    private SalesLog log;
    private Payment pay;

    /**
     * The main method that serves as the entry point of the application. Initializes the system components
     * and starts the user interface.
     *
     * @param args the command line arguments; not used in this application
     */
    public static void main(String[] args) {
        // Initialize the systems needed for the application
        InventorySystem inventory = new InventorySystem();  // Setup inventory system
        AccountingSystem accounting = new AccountingSystem();
        SalesLog log = new SalesLog();
        Printer print = new Printer();
        Payment pay = new Payment();

        // Create the controller, passing in initialized systems
        Controller controller = new Controller(inventory, accounting, log, print, pay);
        
        // Setup and start the view component that handles user interaction
        View view = new View(controller);
        view.runFakeExe(); // Simulate execution, real method name should be updated
    }
}
