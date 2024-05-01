package se.kth.model;

import java.time.LocalTime;
import java.util.List;

import se.kth.controller.*;
import se.kth.integration.*;

public class SaleDTO 
{
    private int saleID;
    private LocalTime time;
    private int priceTotal;
    private float priceAfterDiscount;
    private float vatTotal;
    private 

    private List<ItemDTO> registerdItems;

    /*public SaleDTO(int saleID, LocalTime time, float priceTotal, float priceAfterDiscount, float vatTotal)
    {
        this.saleID = saleID;
        this.time = time;
        this.priceTotal = priceTotal;
        this.priceAfterDiscount = priceAfterDiscount;
        this.vatTotal = vatTotal;
    }
    */
    public SaleDTO(List<ItemDTO> registerdItems, int priceTotal)
    {
        this.registerdItems = registerdItems;
        this.priceTotal = priceTotal;
    }

    public List<ItemDTO> getregisterdItems()
    {
        return registerdItems;
    }

    public int getPriceTotal()
    {
        return priceTotal;
    }


}
