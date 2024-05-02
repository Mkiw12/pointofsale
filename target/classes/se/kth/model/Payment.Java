package se.kth.model;

/**
 * Handles payment operations for transactions. This class provides functionality 
 * to calculate the change returned from a transaction based on the amount paid and total cost.
 * 
 */
public class Payment {

/**
 * Calculates the change to be returned from a transaction.
 * Ensures that the change is not negative, which would indicate the amount paid was less than the total cost.
 *
 * @param amountPaid The total amount paid by the customer.
 * @param totalCost The total cost of the items purchased.
 * @return The amount of change to be given back to the customer, which is always non-negative.
 */

    public double calculateChange(double amountPaid, double totalCost) 
    {
        return Math.max(0, amountPaid - totalCost);
    }


}