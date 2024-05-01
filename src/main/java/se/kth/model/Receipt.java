package se.kth.model;

import java.time.LocalTime;
import java.util.List;


public class Receipt 
{


    private ShoppingCart cart;

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


