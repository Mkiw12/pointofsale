package se.kth.integration;
 
/**
 * Exception represents an invalid item ID error
 */
public class ItemNotFoundException extends Exception {
    

    /**
     * Creates a new instance of ItemNotFoundException
     * @param message takes a provided message to show
     */

    public ItemNotFoundException(String message){

        super(message);
    }

}
