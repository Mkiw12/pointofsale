package se.kth.startup;

import se.kth.controller.Controller;
import se.kth.view.*;

/**
 * Main class for starting the application. This class serves as the central launching point,
 * initializing and wiring together all necessary components including the controller and view,
 * thereby facilitating the startup and management of user interactions.
 */
public class Main {

    /**
     * The main method that serves as the entry point of the application. It initializes the
     * Controller and View components and starts the interaction flow of the application.
     *
     * @param args the command line arguments; not used in this application
     */
    public static void main(String[] args) {
        // Initialize the controller with its required subsystems (inventory, accounting, sales log, and printing)
        Controller controller = new Controller();
        
        // Initialize and start the View which handles all user interactions
        View view = new View(controller);
        view.runFakeExe(); // Start the simulation of the execution process (consider renaming this method to better reflect its purpose)
    }
}
