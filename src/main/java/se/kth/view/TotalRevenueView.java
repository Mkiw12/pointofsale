package se.kth.view;

import se.kth.model.ShoppingCartObserver;

public class TotalRevenueView implements ShoppingCartObserver{
    private double totRevenue;

    
    public void priceOfSale(double income){
        totRevenue +=((double)Math.round(income*100)/100);
        System.out.println("Total revenue is " + totRevenue + "$");

    }

    

}
