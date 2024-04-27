package se.kth.model;

import java.time.LocalTime;


public class Sale 
{
    private LocalTime saleTime;

    public Sale()
    {
        setTimeOfSale();

    }

    private void setTimeOfSale()
    {
        saleTime = LocalTime.now();
    }
}
