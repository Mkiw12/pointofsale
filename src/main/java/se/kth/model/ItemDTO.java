
package se.kth.model;

/**
 * Represents a data transfer object for item details.
 * This class encapsulates the properties of an item, including its name, price, ID, and VAT rate.
 * It is used throughout the system to manage and transfer item data.
 */
public class ItemDTO {

    private String itemName;    
    private double itemVat;     
    private int itemID;         
    private double itemPrice;   

    /**
     * Constructs an ItemDTO with specified details.
     *
     * @param itemName  the name of the item
     * @param itemPrice the price of the item
     * @param itemID    the unique identifier of the item
     * @param itemVat   the VAT rate applicable to the item
     */
    public ItemDTO(String itemName, double itemPrice, int itemID, double itemVat) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemID = itemID;
        this.itemVat = itemVat;
    }

    /**
     * Returns the name of the item.
     *
     * @return the item name
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Returns the unique identifier for the item.
     *
     * @return the item ID
     */
    public int getItemId() {
        return itemID;
    }

    /**
     * Returns the price of the item.
     *
     * @return the item price
     */
    public double getPrice() {
        return itemPrice;
    }

    /**
     * Returns the VAT rate of the item.
     *
     * @return the VAT rate
     */
    public double getVAT() {
        return itemVat;
    }
}
