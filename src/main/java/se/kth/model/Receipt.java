package se.kth.model;

import java.time.LocalTime;
import java.util.List;
import se.kth.controller.*;
import java.time.*;

public class Receipt 
{
   /*  private float change;
    private SaleDTO updatedSalePrice;
    private Receipt receipt;
    

    private SaleDTO saleDetails;

    // constructor
    public Receipt(float change, SaleDTO saleDetails){

        this.saleDetails = saleDetails;
    }

    
  

    public SaleDTO getsaleDetails(){

        return saleDetails;
    }

    public String generateTextReceipt() {

        StringBuilder sb = new StringBuilder();
        sb.append("RECEIPT\n");
        sb.append("-----------------\n");
        
        sb.append(saleDetails.getRegisterdItems());
        sb.append("-----------------\n");
        sb.append(String.format("Time of sale:",saleDetails.getTime()));
        sb.append(String.format("Total: %.2f\n", saleDetails.getPriceTotal()));
        sb.append(String.format("Tax: %.2f\n", saleDetails.getVatTotal()));
        sb.append(String.format("Change: %.2f\n",saleDetails.getChange()));
        sb.append("-----------------\n");
        sb.append("Thank you for shopping!\n");
        return sb.toString();


    public Receipt(){


    }





    public Receipt createReceipt(float change, SaleDTO updatedSalePrice)
    {
        return receipt;
    }


*/

    private ShoppingCart cart;
    private Sale endsale;
    private LocalTime saleTime;

    public Receipt(ShoppingCart cart, LocalTime saleTime) {
        this.cart = cart;
        this.saleTime = saleTime;
    }

    public String createReceipt() {
        StringBuilder receipt = new StringBuilder();
        receipt.append("RECEIPT\n");
        receipt.append("--------------------------------------------------\n");

        List<ItemAndQuantity> items = cart.getItems();
        receipt.append("Time => ").append(saleTime.toString()).append("\n");
        for (ItemAndQuantity item : items) {
            receipt.append(item.getItem().getItemName())
                   .append(" - Qty: ")
                   .append(item.getQuantity())
                   .append(" - Price: $")
                   .append(item.getItem().getPrice())
                   .append(" - Subtotal: $")
                   .append(item.getQuantity() * item.getItem().getPrice())
                   .append(" - Taxrate ")
                   .append(item.getItem().getVAT()-1)
                   .append("\n");
        }

        receipt.append("--------------------------------------------------\n");
        receipt.append("Total: $").append(cart.getTotalCost()).append("\n");
        receipt.append("Thank you for your purchase!\n");

        return receipt.toString();
    }
}


