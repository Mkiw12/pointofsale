package se.kth.integration;


import se.kth.model.Receipt;

/**
* Represents the printer that prints the recipt
*
*/
public class Printer 
{
    
   /**
    * Creates a new instance, representing the printer in the POS
    *
    */      
    public Printer(){

           
    }

    /**
    * Function to handle the printing of the created receipt for a sale
    * 
    * @param receipt contains relevent information to be printed on receipt
    */   
    public void printRecipt(Receipt receipt){

        System.out.println(receipt);
    }

}
