package se.kth.controller;

import static org.junit.jupiter.api.Assumptions.abort;

import se.kth.integration.*;
import se.kth.model.*;

//

public class Controller 
{

    private Printer print;


    private SalesLog SaleL;

    private Sale sale;

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


    public void CreateAccountSystem()
    {
        new AccountingSystem();
    }


    public void CreateInventorySystem()
    {
        new InventorySystem();
    }


    public void CreateDiscountHandler()
    {
        new DiscountHandler();
    }

    public void CreateSale()
    {
        new Sale();
    }

    public void initialteSale()
    {
        sale = new Sale();
    }

    public void createShoppingCart()
    {
        new ShoppingCart();
    }

}
