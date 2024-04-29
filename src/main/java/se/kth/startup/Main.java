package se.kth.startup;

import se.kth.controller.Controller;
import se.kth.view.*;
import se.kth.integration.*;


/**
 * Starts the entire application, contains the main method used to start the application.
 */
public class Main
{
/**
 * The main method used to start the entire application.
 *
 * @param args The application does not take any command line parameters.
 */

    public static void main(String[] args)
    {
        SalesLog SaleL = new SalesLog();
        Printer print = new Printer();

        Controller control = new Controller(print, SaleL);
        new View(control);
    }
    
}
