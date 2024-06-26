
package se.kth.model;

import java.time.LocalTime;
import java.util.List;

import java.time.format.DateTimeFormatter;

/**
 * Represents a receipt for a shopping transaction. This class is responsible for generating a formatted receipt.
 * The receipt includes details about the items purchased, their quantities, prices, the total cost, and the time of the sale.
 * It is designed to be used post-sale to provide a detailed summary of the transaction.
 *
 * The Receipt class interacts with the ShoppingCart to access item details and uses a Payment instance to handle payment-related information.
 */
public class Receipt 
{
   

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
        receipt.append("TotalVAT: $").append(String.format("%.2f", cart.getVatTotal())).append("\n");
        receipt.append("Paid Amount: $").append(String.format("%.2f", amountP)).append("\n");
        receipt.append("Change: $").append(String.format("%.2f", pay.calculateChange(amountP,cart.getTotalCost()))).append("\n");
        receipt.append("Thank you for your purchase!\n");

        return receipt.toString();
    }
}



