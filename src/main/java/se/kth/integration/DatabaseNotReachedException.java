package se.kth.integration;


/**
 * Exception represents that contact with database failed
 */
public class DatabaseNotReachedException extends Exception{


    /**
     * Creates a new instance of DatabaseNotReachedException
     * @param message takes a provided message to show
     */

    public DatabaseNotReachedException(String message){

        super(message);
    }

}