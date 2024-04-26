package se.kth.controller;

import se.kth.integration.*;

//

public class Controller 
{
    private Printer print;
    private SalesLog SaleL;

    //private AccountingSystem accountingSystem;

    public Controller(Printer print, SalesLog SaleL)
    {
        this.print = print;
        this.SaleL = SaleL;
    }

    public void CreateAccountSystem()
    {
        new AccountingSystem();
    }

}
