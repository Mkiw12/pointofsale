package se.kth.model;

public class ItemDTO 
{
    private String itemName;
    private float itemVat;
    private int itemID;
    private float itemPrice;

    public ItemDTO(String itemName, float itemPrice, int itemID, float itemVat)
    {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemID = itemID;
        this.itemVat = itemVat;
    }

    
}