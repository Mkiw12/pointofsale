
package se.kth.integration;

import java.util.ArrayList;
import java.util.List;

import se.kth.model.*;

/**
 * Manages the inventory of items in the system. This includes maintaining a list of items,
 * adding new items, and providing methods to query and update item information.
 */
public class InventorySystem {

    private final List<ItemDTO> items = new ArrayList<>();

    /**
     * Constructs an InventorySystem and initializes it with a default set of items.
     */
    public InventorySystem() {
        items.add(new ItemDTO("boll", 10, 1, 1.1));
        items.add(new ItemDTO("bomb", 30, 2, 1.3));
        items.add(new ItemDTO("fågel", 10, 3, 1.21));
        items.add(new ItemDTO("ägg", 30, 4, 1.32));
        items.add(new ItemDTO("vattenpistol", 10, 5, 1.6));
        items.add(new ItemDTO("drake", 30, 6, 1.15));
        items.add(new ItemDTO("sak", 2, 7, 1.25));
    }

    /**
     * Retrieves a list of all items currently in the inventory.
     *
     * @return a new list containing copies of all items in the inventory
     */
    public List<ItemDTO> getAllItems() {
        return new ArrayList<>(items);
    }

    /**
     * Finds an item in the inventory by its item ID.
     *
     * @param itemId the ID of the item to find
     * @return the ItemDTO if found, null otherwise
     */
    public ItemDTO findItemById(int itemId) {
        for (ItemDTO item : items) {
            if (item.getItemId() == itemId) {
                return item;
            }
        }
        return null;
    }

    /**
     * Checks if an item ID is valid and exists in the inventory.
     *
     * @param itemId the ID to validate
     * @return true if the ID exists, false otherwise
     */
    public boolean legitID(int itemId) {
        for (ItemDTO item : items) {
            if (item.getItemId() == itemId) {
                return true;
            }
        }
        return false;
    }

    /**
     * Updates the inventory based on recent transactions.
     * This method is currently a placeholder and should be implemented to update inventory quantities.
     */
    public void updateInventory() {
        // Implementation needed to update inventory quantities based on sales and restocks.
    }
}
