
package se.kth.model;

/**
 * Represents an association between an item and its quantity. 
 * This class is used to manage items along with their quantities, such as in a shopping cart or inventory system.
 */
public class ItemAndQuantity {

    private ItemDTO item;      // The item details
    private int quantity;      // The quantity of the item

    /**
     * Constructs an ItemAndQuantity object with specified item and quantity.
     *
     * @param item     the item details, encapsulated in an ItemDTO object
     * @param quantity the quantity of the item
     */
    public ItemAndQuantity(ItemDTO item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    /**
     * Retrieves the item details.
     *
     * @return the ItemDTO object containing item details
     */
    public ItemDTO getItem() {
        return item;
    }

    /**
     * Retrieves the quantity of the item.
     *
     * @return the quantity of the item
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the item. This method can be used to update the quantity when needed.
     *
     * @param quantity the new quantity to be set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

