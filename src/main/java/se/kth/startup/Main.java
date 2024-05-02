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

        
        Controller controller = new Controller();
        
        
        View view = new View(controller);
        view.runFakeExe(); 
    }
}
