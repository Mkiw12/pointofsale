package se.kth.view;

import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileWriter;

import se.kth.model.ShoppingCartObserver;


public class TotalRevenueFileOutput implements ShoppingCartObserver {
    private PrintWriter logStream;
    private double totRevenue;

    /**
     * Creates a new instance and also creates a new log file.
     * Any existing log file will be deleted.
     */
    public TotalRevenueFileOutput() {
        try {
            logStream = new PrintWriter(new FileWriter("revenueLog.txt"), true);
        } catch (IOException e) {
            System.out.println("FAILED TO LOG REVENUE.");
            e.printStackTrace();
        }
    }


    /**
     * Specified double is logged to a log file.
     * @param income double that will be printed to the log file.
     */
    @Override
    public void priceOfSale(double income){
        totRevenue +=((double)Math.round(income*100)/100);

        logStream.println("Total revenue is " + totRevenue + "$");

    }

}
