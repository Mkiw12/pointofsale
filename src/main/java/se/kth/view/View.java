/*package se.kth.view;

import se.kth.controller.Controller;
import se.kth.model.ItemDTO;

import java.util.Scanner;

public class View {
    private Controller controller;
    private Scanner scanner;

    public View(Controller controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    public void runFakeExe() {
        controller.initiateSale();
        System.out.println("New sale has started.");

        System.out.println("Available Items:");
        for (ItemDTO item : controller.getAvailableItems()) {
            System.out.println("ID: " + item.getItemId() + " - Name: " + item.getItemName() + " - Price: $" + item.getPrice());
        }

        boolean shopping = true;
        while (shopping) {
            System.out.print("Enter item ID to add to cart (0 to end sale): ");
            int itemId = scanner.nextInt();
            if (itemId == 0) {
                //System.out.println("Sale completed. Total due: $" + controller.endSale());
                System.out.println("finished");
                controller.endSale();
                //controller.endSale();
                shopping = false;
            } else {
                System.out.print("Enter quantity: ");
                int quantity = scanner.nextInt();
                //controller.scanItems(itemId, quantity);
                String itemName = controller.regItems(itemId, quantity);
                if (itemName != null) {
                    System.out.println("Added " + quantity + " of " + itemName + " to the cart.");
                } else {
                    System.out.println("Item with ID " + itemId + " not found.");
                    
                }
            }
        }

        scanner.close();
    }
}*/
package se.kth.view;

import se.kth.controller.Controller;
import se.kth.model.ItemDTO;
import java.util.Scanner;

/**
 * Provides a text-based user interface for interacting with the retail system.
 * This class handles user inputs and displays information about items and transactions.
 */
public class View {
    private Controller controller; // Controller instance to manage system operations
    private Scanner scanner;       // Scanner instance for reading user input

    /**
     * Constructs a View object with a specified controller.
     *
     * @param controller the controller that manages the system logic
     */
    public View(Controller controller) {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Runs the simulated execution of the system, allowing user interaction through a series of prompts and responses.
     * Users can start a new sale, add items to a shopping cart, and complete the sale.
     */
    public void runFakeExe() {
        controller.initiateSale();
        System.out.println("New sale has started.");

        System.out.println("Available Items:");
        for (ItemDTO item : controller.getAvailableItems()) {
            System.out.println("ID: " + item.getItemId() + " - Name: " + item.getItemName() + " - Price: $" + item.getPrice());
        }

        boolean shopping = true;
        while (shopping) {
            System.out.print("Enter item ID to add to cart (0 to end sale): ");
            int itemId = scanner.nextInt();
            if (itemId == 0) {
                System.out.println("finished");
                controller.endSale();
                shopping = false;
            } else {
                System.out.print("Enter quantity: ");
                int quantity = scanner.nextInt();
                String itemName = controller.regItems(itemId, quantity);
                if (itemName != null) {
                    System.out.println("Added " + quantity + " of " + itemName + " to the cart.");
                } else {
                    System.out.println("Item with ID " + itemId + " not found.");
                }
            }
        }

        scanner.close(); // Close the scanner when the user interaction is complete
    }
}

