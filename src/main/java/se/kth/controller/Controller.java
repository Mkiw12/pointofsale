package se.kth.controller;

import se.kth.integration.*;

//

public class Controller 
{
    /**
     * Instance variable for managing printing operations. This Printer object is expected
     * to handle all print-related tasks for the class, ensuring that printing operations
     * are centralized and easy to manage.
     */
    private Printer print;
    
    /**
     * Instance variable for managing sales logging. The SalesLog object is used to record
     * and track sales data, providing a centralized component within the class to handle
     * all sales-related logging and analysis.
     */
    private SalesLog SaleL;

    

    /**
    * Constructs a new Controller instance with specified printer and sales log services.
    * This constructor allows for dependency injection, enabling easier management and testing of the Controller's dependencies.
    * 
    * @param print  the Printer instance that this controller will use to handle all printing tasks.
    * @param SaleL  the SalesLog instance that this controller will use to manage sales-related data and operations.
    */
    public Controller(Printer print, SalesLog SaleL)
    {
        this.print = print;
        this.SaleL = SaleL;
    }

     /**
     * Instantiates a new AccountingSystem. This method is responsible for creating a fresh accounting system,
     * potentially initializing system components or settings. Note that the created instance is not returned or stored,
     * implying that the initialization logic is self-contained or otherwise managed.
     */
    public void CreateAccountSystem()
    {
        new AccountingSystem();
    }

     /**
     * Instantiates a new InventorySystem. This method creates a new instance of InventorySystem,
     * presumably initializing system components or settings essential for inventory management.
     * The created instance is not returned or stored, implying that the initialization and management
     * are handled internally within the InventorySystem constructor or that the system operates
     * independently without needing further reference.
     */
    public void CreateInventorySystem()
    {
        new InventorySystem();
    }
    
     /**
     * Instantiates a new DiscountHandler. This method is responsible for creating a new instance of DiscountHandler,
     * which is assumed to handle its initialization and integration internally.
     * The instance created is not returned or stored externally, which implies that the DiscountHandler
     * may be registering itself with another system or has some self-sustaining operation setup.
     */

    public void CreateDiscountHandler()
    {
        new DiscountHandler();
    }

}
