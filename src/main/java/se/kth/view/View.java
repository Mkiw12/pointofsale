
package se.kth.view;

import se.kth.controller.Controller;
import se.kth.integration.ItemNotFoundException;
import se.kth.integration.DatabaseNotReachedException;

import java.util.List;
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
        controller.addObserver(new TotalRevenueView());
        controller.addObserver(new TotalRevenueFileOutput());
    }

    /**
     * Runs the simulated execution of the system, allowing user interaction through a series of prompts and responses.
     * Users can start a new sale, add items to a shopping cart, and complete the sale.
     */
    public void runFakeExe(){
        controller.initiateSale();
        System.out.println("New sale has started.");

        System.out.println("Available Items:");
        List<String> availableItems = controller.getFormattedAvailableItems();
        for (String itemDetails : availableItems) {
            System.out.println(itemDetails);
        }

    boolean shopping = true;
    while (shopping) {
        System.out.print("Enter item ID to add to cart (0 to end sale): ");
        int itemId = scanner.nextInt();
        if (itemId == 0) {
            System.out.println("Total cost is: " + controller.getFinalCost());
            System.out.print("Enter amount paid: ");
            double paidAmount = scanner.nextDouble();
            System.out.println("This is your change " + String.format("%.2f", controller.Change(paidAmount)));
            controller.endSale(paidAmount);
            shopping = false;
        } else {
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            try {
                String itemName = controller.regItems(itemId, quantity);
                System.out.println("Added " + quantity + " of " + itemName + " to the cart.");
            } catch (ItemNotFoundException e) {
                System.out.println(e.getMessage());
            }
              catch(DatabaseNotReachedException e) {
                System.out.println(e.getMessage());
        
              }
        }
    }



   
}

    /**
     * Runs the second simulated execution of the system, allowing user interaction through a series of prompts and responses.
     * Users can start a new sale, add items to a shopping cart, and complete the sale.
     */
    public void runFakeExe2(){
        controller.initiateSale();
        System.out.println("New sale has started.");

        System.out.println("Available Items:");
        List<String> availableItems = controller.getFormattedAvailableItems();
        for (String itemDetails : availableItems) {
            System.out.println(itemDetails);
        }

    boolean shopping = true;
    while (shopping) {
        System.out.print("Enter item ID to add to cart (0 to end sale): ");
        int itemId = scanner.nextInt();
        if (itemId == 0) {
            System.out.println("Total cost is: " + controller.getFinalCost());
            System.out.print("Enter amount paid: ");
            double paidAmount = scanner.nextDouble();
            System.out.println("This is your change " + String.format("%.2f", controller.Change(paidAmount)));
            controller.endSale(paidAmount);
            shopping = false;
        } else {
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            try {
                String itemName = controller.regItems(itemId, quantity);
                System.out.println("Added " + quantity + " of " + itemName + " to the cart.");
            } catch (ItemNotFoundException e) {
                System.out.println(e.getMessage());
            }
              catch(DatabaseNotReachedException e) {
                System.out.println(e.getMessage());
        
              }
        }
    }



    scanner.close();
}






        
}

