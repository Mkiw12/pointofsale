
package se.kth.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a shopping cart used in a retail transaction.
 * The cart manages a collection of items and their quantities, allowing items to be added or modified.
 */
public class ShoppingCart {
    private List<ItemAndQuantity> items;
    private ArrayList<ShoppingCartObserver> shoppingCartObservers = new ArrayList<>();

    /**
     * Constructs an empty shopping cart.
     */
    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    /**
     * Adds an item to the shopping cart or updates the quantity of an existing item.
     * If the item is already present in the cart, it increases the quantity. Otherwise, it adds a new entry.
     *
     * @param item     the item to add to the cart
     * @param quantity the quantity of the item to be added
     * @return the updated list of items and quantities in the cart
     */
    public List<ItemAndQuantity> addItem(ItemDTO item, int quantity) {
        int itemId = item.getItemId();
        boolean itemAlreadyRegistered = false;
        
        for (ItemAndQuantity currentIterationItem : items) {
            if (currentIterationItem.getItem().getItemId() == itemId) {
                
                currentIterationItem.setQuantity(currentIterationItem.getQuantity() + quantity);
                itemAlreadyRegistered = true;
                System.out.println("Added " + quantity + " of " + item.getItemName() + " to the cart.");
                break;
            }
        }

        if (!itemAlreadyRegistered) {
            
            items.add(new ItemAndQuantity(item, quantity));
        }

        return items;
    }

    /**
     * Calculates the total cost of all items in the cart, including applicable taxes.
     *
     * @return the total cost of items in the cart
     */
    public double getTotalCost() {
        double totalCost = 0.0;
        for (ItemAndQuantity itemAndQuantity : items) {
            totalCost += itemAndQuantity.getItem().getPrice() * itemAndQuantity.getItem().getVAT() * itemAndQuantity.getQuantity();
        }
        return totalCost;
        
    }   

    /**
     * Retrieves a copy of the list of items and quantities in the shopping cart.
     * This prevents the original list from being modified externally.
     *
     * @return a copy of the list of items and their quantities
     */
    public List<ItemAndQuantity> getItems() {
        return new ArrayList<>(this.items); 
    }


    /**
     * Calculates the total VAT of all items in the cart
     *
     * @return the total VAT of all items in the cart
     */
    public double getVatTotal() {
        double totVat = 0;

        for (ItemAndQuantity itemQuantity : items) {
            ItemDTO item = itemQuantity.getItem();
            int quantity = itemQuantity.getQuantity();
            double price = item.getPrice();
            double VATRate = item.getVAT();
            totVat += (price * VATRate - price) * quantity;
        }
        notifyObservers();

        return totVat;
    }

  /*   public void finalizeSale() {
        double totalCost = getTotalCost();
        // Additional code to handle the sale process, like payment handling
        notifyObservers(totalCost);  // Notify observers with the final sale amount
    } */



    /**
     * Adds observers from controller to a list.
     * @param obs List of observers to be added to the list
     */
    public void addShoppingCartObservers(List<ShoppingCartObserver> obs){

        shoppingCartObservers.addAll(obs);
    }
    //double finalSaleAmount
    public void notifyObservers(){
        for(ShoppingCartObserver obs : shoppingCartObservers){
          obs.priceOfSale(getTotalCost());
            
        }
    }
}

