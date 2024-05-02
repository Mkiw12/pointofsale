
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
        


        
        Controller controller = new Controller();
        
        
        View view = new View(controller);
        view.runFakeExe();
    }
}
