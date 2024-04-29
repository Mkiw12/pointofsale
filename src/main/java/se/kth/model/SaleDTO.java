package se.kth.model;

import java.time.LocalTime;

public class SaleDTO 
{
    private int saleID;
    private LocalTime time;
    private float priceTotal;
    private float priceAfterDiscount;
    private float vatTotal;

    public SaleDTO(int saleID, LocalTime time, float priceTotal, float priceAfterDiscount, float vatTotal)
    {
        this.saleID = saleID;
        this.time = time;
        this.priceTotal = priceTotal;
        this.priceAfterDiscount = priceAfterDiscount;
        this.vatTotal = vatTotal;
    }


}
