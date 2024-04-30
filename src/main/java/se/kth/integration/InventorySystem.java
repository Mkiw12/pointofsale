package se.kth.integration;

import java.util.ArrayList;
import java.util.List;

import se.kth.model.*;

public class InventorySystem 

{   

    
    
    private final List<ItemDTO> items = new ArrayList<>();
    public InventorySystem()
    {


        items.add(new ItemDTO("boll", 10, 1, 1.1));
        items.add(new ItemDTO("bomb", 30, 2, 1.3));
        items.add(new ItemDTO("fågel", 10, 3, 1.21));
        items.add(new ItemDTO("ägg", 30, 4, 1.32));
        items.add(new ItemDTO("vattenpistol", 10, 5, 1.6));
        items.add(new ItemDTO("drake", 30, 6, 1.15));
        items.add(new ItemDTO("sak", 2, 7, 1.25));

    }

    public List<ItemDTO> getAllItems() {
        return new ArrayList<>(items);
    }

    public ItemDTO findItemById(int itemId) {
        for (ItemDTO item : items) {
            if (item.getItemId() == itemId) {
                return item;
            }
        }
        return null;
    }

    public boolean legitID(int itemId)
    {
        for (ItemDTO item : items) {
            if (item.getItemId() == itemId) {
                return true;
            }
        }
        return false;
    }

}
