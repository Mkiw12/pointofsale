package se.kth.model;

public class ItemDTO 
{
    private String itemName;
    private double itemVat;
    private int itemID;
    private double itemPrice;

    public ItemDTO(String itemName, double itemPrice, int itemID, double itemVat)
    {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemID = itemID;
        this.itemVat = itemVat;
    }

    public String getItemName(){
        return itemName;
    }
    
    public int getItemId(){
        return itemID;
    }
    
    public double getPrice(){
        return itemPrice;
    }
    
    public double getVAT(){
        return itemVat;
    }
    

    
}