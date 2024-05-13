package se.kth.model;

/** 
 * Interface for the classes that observe the ShoppingCart class
 */

public interface ShoppingCartObserver {

    /**
     * 
     *
     * @param totalCost total cost of a sale
     */

    void priceOfSale(double totalCost);

        
}
    
