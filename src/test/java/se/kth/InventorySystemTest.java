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
<<<<<<< HEAD
        assertNotNull(items,"The returned items list should not be null.");
        assertEquals(7, items.size(),"The items list should contain exactly 7 items."); // Assuming 7 items are initially added in InventorySystem
=======
        assertNotNull(items);
        assertEquals(7, items.size()); 
>>>>>>> 46329242e43493ed9016067ef83d9595c612098d
    }

    @Test
    void testFindItemByIdExistingItem() {
        ItemDTO item = inventorySystem.findItemById(1);
        assertNotNull(item,"Item with ID 1 should not be null.");
        assertEquals("boll", item.getItemName(),"The item name should match 'boll'.");
    }

    @Test
    void testFindItemByIdNonExistingItem() {
<<<<<<< HEAD
        ItemDTO item = inventorySystem.findItemById(999); // Assuming ID 999 does not exist
        assertNull(item, "No item should be found with ID 999.");
=======
        ItemDTO item = inventorySystem.findItemById(999); 
        assertNull(item);
>>>>>>> 46329242e43493ed9016067ef83d9595c612098d
    }

    @Test
    void testLegitIDTrue() {
<<<<<<< HEAD
        assertTrue(inventorySystem.legitID(1),"ID 1 should be recognized as legitimate."); // ID 1 is known to be in the initial set
=======
        assertTrue(inventorySystem.legitID(1)); 
>>>>>>> 46329242e43493ed9016067ef83d9595c612098d
    }

    @Test
    void testLegitIDFalse() {
<<<<<<< HEAD
        assertFalse(inventorySystem.legitID(999),"ID 999 should be recognized as illegitimate."); // Assuming ID 999 does not exist
=======
        assertFalse(inventorySystem.legitID(999)); 
>>>>>>> 46329242e43493ed9016067ef83d9595c612098d
    }
}
