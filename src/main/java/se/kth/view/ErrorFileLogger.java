package se.kth.view;

import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;


/**
 * Prints log messages to a file. The log file will be in the current
 * directory and will be called errorLog.txt.
 */
public class ErrorFileLogger implements Logger {
    private PrintWriter logStream;    

    /**
     * Creates a new instance and also creates a new log file.
     * Any existing log file will be deleted.
     */
    public ErrorFileLogger() {
        try {
            logStream = new PrintWriter(new FileWriter("errorLog.txt"), true);
        } catch (IOException e) {
            System.out.println("FAILED TO LOG ERROR.");
            e.printStackTrace();
        }
    }
    
     /**
     * Specified string is logged to a log file.
     * @param message String that will be printed to the log file.
     */
    @Override
    public void log(String message) {
        StringBuilder errorMsg = new StringBuilder();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        now.format(formatter);
        errorMsg.append(now);
        errorMsg.append(" ");
        errorMsg.append(message);
        logStream.println(errorMsg);
    }




    
}
