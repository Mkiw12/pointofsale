package se.kth.model;

public class Receipt 
{
    private float change;
    private SaleDTO updatedSalePrice;
    private Receipt receipt;
    
<<<<<<< Updated upstream
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
=======
<<<<<<< Updated upstream
    public Receipt(){
>>>>>>> Stashed changes

    }




=======
    public Receipt createReceipt(float change, SaleDTO updatedSalePrice)
    {
        return receipt;
    }

>>>>>>> Stashed changes
}
