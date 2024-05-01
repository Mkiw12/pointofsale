
package se.kth.model;

import java.time.LocalTime;
import java.util.List;
import se.kth.controller.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

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
    private LocalTime saleTime;
    private Payment pay;

    public Receipt(ShoppingCart cart, LocalTime saleTime, Payment pay) {
        this.cart = cart;
        this.saleTime = saleTime;
        this.pay = pay;
    }

    /**
     * Generates a formatted receipt string based on the shopping cart contents and sale time.
     * The receipt includes a list of items, their quantities, prices, and the total cost, including tax.
     *
     * @return the formatted receipt string
     */
    public String createReceipt(double amountP) {
        StringBuilder receipt = new StringBuilder();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        receipt.append("\nRECEIPT\n");
        receipt.append("--------------------------------------------------\n");

        List<ItemAndQuantity> items = cart.getItems();
        receipt.append("Time of sale: ").append(saleTime.format(timeFormatter)).append("\n");
        for (ItemAndQuantity item : items) {
            receipt.append(item.getItem().getItemName())
                   .append(" - Qty: ")
                   .append(item.getQuantity())
                   .append(" - Price: $")
                   .append(item.getItem().getPrice())
                   .append(" - Subtotal: $")
                   .append(item.getQuantity() * item.getItem().getPrice())
                   .append(" - Taxrate: ")
                   .append(String.format("%.2f",item.getItem().getVAT()-1))
                   .append("\n");
        }

        receipt.append("--------------------------------------------------\n");
        receipt.append("Total: $").append(String.format("%.2f",cart.getTotalCost())).append("\n");
        receipt.append("TotalVAT: $").append(String.format("%.2f", cart.getVatTotal())).append("\n");  // Format to 2 decimal places
        receipt.append("Change: $").append(String.format("%.2f", pay.calculateChange(amountP,cart.getTotalCost()))).append("\n");
        receipt.append("Thank you for your purchase!\n");

        return receipt.toString();
    }
}



