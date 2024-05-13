package se.kth.view;

/**
 * Prints log messages. The destination of the log is decided by the
 * class implementing the interface.
 */
public interface Logger {
    
    /**
     * Logs the specified string.
     * @param message String that will be logged.
     */
    void log(String message);
    
}