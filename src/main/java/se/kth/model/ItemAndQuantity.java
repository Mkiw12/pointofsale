package se.kth.model;

public class ItemAndQuantity 
{


    private ItemDTO item;
    private int quantity;

    public ItemAndQuantity(ItemDTO item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public ItemDTO getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
