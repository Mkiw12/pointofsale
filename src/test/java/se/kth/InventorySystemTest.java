package se.kth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import se.kth.model.ItemDTO;
import se.kth.integration.*;

import java.util.List;

public class InventorySystemTest {
    private InventorySystem inventorySystem;

    @BeforeEach
    void setUp() {
        inventorySystem = new InventorySystem();
    }

    @Test
    void testGetAllItemsReturnsAllItems() {
        List<ItemDTO> items = inventorySystem.getAllItems();
        assertNotNull(items);
        assertEquals(7, items.size()); 
    }

    @Test
    void testFindItemByIdExistingItem() {
        ItemDTO item = inventorySystem.findItemById(1);
        assertNotNull(item);
        assertEquals("boll", item.getItemName());
    }

    @Test
    void testFindItemByIdNonExistingItem() {
        ItemDTO item = inventorySystem.findItemById(999); 
        assertNull(item);
    }

    @Test
    void testLegitIDTrue() {
        assertTrue(inventorySystem.legitID(1)); 
    }

    @Test
    void testLegitIDFalse() {
        assertFalse(inventorySystem.legitID(999)); 
    }
}
