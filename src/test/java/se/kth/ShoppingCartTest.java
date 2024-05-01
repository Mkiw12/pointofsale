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
        assertEquals(1, items.size());
        assertEquals(2, items.get(0).getQuantity());
    }

    @Test
    void testAddExistingItem() {
        cart.addItem(itemMock, 2);
        cart.addItem(itemMock, 3);
        List<ItemAndQuantity> items = cart.getItems();
        assertEquals(1, items.size());
        assertEquals(5, items.get(0).getQuantity());
    }

    @Test
    void testTotalCostCalculation() {
        cart.addItem(itemMock, 2);
        double expectedCost = 100.0 * 1.25 * 2; // Price * VAT * Quantity
        assertEquals(expectedCost, cart.getTotalCost());
    }

    @Test
    void testGetItemsIntegrity() {
        cart.addItem(itemMock, 2);
        List<ItemAndQuantity> items = cart.getItems();
        items.clear();
        assertEquals(1, cart.getItems().size());
    }
}
