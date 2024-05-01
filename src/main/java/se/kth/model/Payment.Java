package se.kth.model;

public class Payment {

    public double calculateChange(double amountPaid, double totalCost) {
        return Math.max(0, amountPaid - totalCost); // Ensure that the change is not negative
    }

    





}