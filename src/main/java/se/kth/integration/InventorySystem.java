package se.kth.integration;

import java.util.ArrayList;
import java.util.List;

import se.kth.model.ItemDTO;

public class InventorySystem 

{   private String name;
    private int price;
    private double vatRate;
    private String itemDesc;

    
    
    private final List<ItemDTO> items = new ArrayList<>();
    public InventorySystem()
    {
        /*items.add(new ItemDTO(new ItemDTO("Eco Avocado", 0, new Amount(2.99), new Amount(0.06), "Eco Avocado... VAT: 6%"), 503));
        items.add(new ItemAndQuantity(new ItemDTO("Medium-fat milk", 1, new Amount(5.79), new Amount(0.12), "Medium-fat milk... VAT: 12%"), 213));
        items.add(new ItemAndQuantity(new ItemDTO("Jensons Farm's Potato", 2, new Amount(3.50), new Amount(0.25), "Jensons Farm's Potato... VAT: 25%"), 704));
        items.add(new ItemAndQuantity(new ItemDTO("Crusty breadsticks", 3, new Amount(3.29), new Amount(0.12), "Crusty breadsticks... VAT: 12% "), 150));
        items.add(new ItemAndQuantity(new ItemDTO("Karin's family lasagna", 4, new Amount(6.99), new Amount(0.06), "Karin's family lasagna... VAT: 6%"), 35));
        items.add(new ItemAndQuantity(new ItemDTO("Gazzo's Microwave Pizza", 5, new Amount(4.99), new Amount(0.06), "Gazzo's Microwave Pizza... VAT: 6%"), 16));
        */

        items.add(new ItemDTO("boll", 10, 1, 2.5));
        items.add(new ItemDTO("bomb", 30, 2, 3));
        items.add(new ItemDTO("fågel", 10, 1, 2.5));
        items.add(new ItemDTO("ägg", 30, 2, 3));
        items.add(new ItemDTO("vattenpistol", 10, 1, 2.5));
        items.add(new ItemDTO("drake", 30, 2, 3));

    }

    public ItemDTO checkForItem(int itemID)
    {
        ItemDTO searchingItem = null;

        for(int i = 0; i < items.size(); i++)
        {
            searchingItem = items.get(i);
            if(searchingItem.getItemId() == itemID)
            {
                return searchingItem;
            }
        }
        return null;
    }

    public boolean findItem(int itemID)
    {
        boolean itemExist = false;

        ItemDTO regItem = checkForItem(itemID);

        if(regItem.getItemId() == itemID)
        {
            itemExist = true;
        }

        return itemExist;
    }

    public ItemDTO fetchItem(int itemID)
    {
        ItemDTO searchedItem = checkForItem(itemID);

        if(searchedItem != null)
        {
            name = searchedItem.getItemName();
            price = searchedItem.getPrice();
            vatRate = searchedItem.getVAT();
        }
        ItemDTO registerdItem = new ItemDTO(name, itemID, itemID, itemID);
        return registerdItem;
    }

}
