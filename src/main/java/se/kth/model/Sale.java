package se.kth.model;

import java.time.LocalTime;


public class Sale 
{
    private LocalTime saleTime;
    private Receipt receipt;

    public Sale()
    {
        setTimeOfSale();
    }

    private void setTimeOfSale()
    {
        saleTime = LocalTime.now();
    }

    public void createShoppingCart()
    {
        new ShoppingCart();
    }

    public void createReceipt()
    {
        receipt = new Receipt();
    }
}
