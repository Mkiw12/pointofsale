package se.kth.startup;

import java.util.List;

import se.kth.controller.Controller;
import se.kth.view.*;
import se.kth.integration.*;
import se.kth.model.ItemDTO;
import se.kth.model.ShoppingCart;


/**
 * Starts the entire application, contains the main method used to start the application.
 */
public class Main
{
    private InventorySystem inventorySystem;
/**
 * The main method used to start the entire application.
 *
 * @param args The application does not take any command line parameters.
 */

    public static void main(String[] args)
    {
        // Retrieve the list of available items from ItemCatalog
        InventorySystem inventory = new InventorySystem();  // Setup inventory system
        //ShoppingCart cart = new ShoppingCart();
        Controller controller = new Controller(inventory);
        View view = new View(controller);
        view.runFakeExe();

    }
    
}
