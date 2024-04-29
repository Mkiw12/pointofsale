package se.kth.model;

import java.time.LocalTime;


public class Sale 
{
    private LocalTime saleTime;
    private Receipt receipt;
    private int itemQuant;

    public Sale()
    {
        setTimeOfSale();
    }

    private void setTimeOfSale()
    {
        saleTime = LocalTime.now();
    }

    public ShoppingCart updateSale(int itemQuant, int itemID)
    {
        return ;
    }

    public boolean searchItemID(int itemID)
    {
        return true;
    }

    public ShoppingCart addNewItem(int itemQuant, ItemDTO itemInfo)
    {

    }

    public ShoppingCart fetchFinalCart()
    {

    }

    public SaleDTO updatedSalePrice(float discount, ShoppingCart totalSale)
    {

    }

    public float updatedSalePrice(float amountPaid)
    {

    }

    public float changeAmount(float amountPaid)
    {

    }

    public Receipt fetchReceipt()
    {
        
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
