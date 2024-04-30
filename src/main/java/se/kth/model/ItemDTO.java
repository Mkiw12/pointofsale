package se.kth.model;

public class ItemDTO 
{
    private String itemName;
    private float itemVat;
    private int itemID;
    private float itemPrice;

    public ItemDTO(String itemName, float itemPrice, int itemID, double d)
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
    
    public float getPrice(){
        return itemPrice;
    }
    
    public float getVAT(){
        return itemVat;
    }
    

    
}