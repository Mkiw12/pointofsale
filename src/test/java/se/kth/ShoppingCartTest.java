package se.kth;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.model.*;
import java.util.List;

public class ShoppingCartTest {
    private ShoppingCart cart;
    private ItemDTO itemMock;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
        itemMock = mock(ItemDTO.class);
        when(itemMock.getItemId()).thenReturn(1);
        when(itemMock.getItemName()).thenReturn("TestItem");
        when(itemMock.getPrice()).thenReturn(100.0);
        when(itemMock.getVAT()).thenReturn(1.25);
    }

    @Test
    void testAddNewItem() {
        cart.addItem(itemMock, 2);
        List<ItemAndQuantity> items = cart.getItems();
        assertEquals(1, items.size(),"There should be exactly one type of item in the cart.");
        assertEquals(2, items.get(0).getQuantity(),"The quantity of the item should be 2.");
    }

    @Test
    void testAddExistingItem() {
        cart.addItem(itemMock, 2);
        cart.addItem(itemMock, 3);
        List<ItemAndQuantity> items = cart.getItems();
        assertEquals(1, items.size(),"There should still be only one type of item in the cart after adding more.");
        assertEquals(5, items.get(0).getQuantity(),"The quantity of the item should be updated to 5.");
    }

    @Test
    void testTotalCostCalculation() {
        cart.addItem(itemMock, 2);
        double expectedCost = 100.0 * 1.25 * 2; 
        assertEquals(expectedCost, cart.getTotalCost(),"The total cost should be calculated correctly.");
    }    

    @Test
    void testGetItemsIntegrity() {
        cart.addItem(itemMock, 2);
        List<ItemAndQuantity> items = cart.getItems();
        items.clear();
        assertEquals(1, cart.getItems().size(),"The original list of items in the cart should remain unaffected by external modifications.");
    }
}
