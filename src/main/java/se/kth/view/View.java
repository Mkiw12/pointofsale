package se.kth.view;

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
}
