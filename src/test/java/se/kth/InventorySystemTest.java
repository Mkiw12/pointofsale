package se.kth;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import se.kth.model.ItemDTO;
import se.kth.integration.DatabaseNotReachedException;
import se.kth.integration.InventorySystem;
import se.kth.integration.ItemNotFoundException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InventorySystemTest {
    private InventorySystem inventorySystem;

    @BeforeEach
    public void setUp() {
        inventorySystem = new InventorySystem();
    }

    @Test
    public void testGetAllItems() {
        List<ItemDTO> items = inventorySystem.getAllItems();
        assertEquals(8, items.size(), "The inventory should contain 8 items.");
    }

    @Test
    public void testFindItemById_Success() {
        try {
            ItemDTO item = inventorySystem.findItemById(1);
            assertNotNull(item, "Item should not be null.");
            assertEquals(1, item.getItemId(), "Item ID should be 1.");
            assertEquals("boll", item.getItemName(), "Item name should be 'boll'.");
        } catch (ItemNotFoundException | DatabaseNotReachedException e) {
            fail("Exception should not be thrown for valid item ID.");
        }
    }

    @Test
    public void testFindItemById_ItemNotFoundException() {
        try {
            inventorySystem.findItemById(99);
            fail("ItemNotFoundException should be thrown for invalid item ID.");
        } catch (ItemNotFoundException e) {
            assertEquals("ERROR: Item with ItemID: 99, was not found in inventory", e.getMessage());
        } catch (DatabaseNotReachedException e) {
            fail("DatabaseNotReachedException should not be thrown for this test.");
        }
    }

    @Test
    public void testFindItemById_DatabaseNotReachedException() {
        try {
            inventorySystem.findItemById(10);
            fail("DatabaseNotReachedException should be thrown for item ID 10.");
        } catch (ItemNotFoundException e) {
            fail("ItemNotFoundException should not be thrown for this test.");
        } catch (DatabaseNotReachedException e) {
            assertEquals("ERROR: Database connection failed", e.getMessage());
        }
    }


}
