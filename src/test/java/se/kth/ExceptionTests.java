package se.kth;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import se.kth.integration.*;



public class ExceptionTests {
    private int itemID;
    private InventorySystem inventory;

/**
 * Test to check ItemNotFoundException, simulates a hardcoded item outside the inventory system
 */


@Test
void ItemNotFoundExceptionTest(){
try{
    itemID = 15;
    inventory = new InventorySystem();
    inventory.findItemById(itemID);
    fail("Item is in inventory system");
} catch(ItemNotFoundException exception){
    assertTrue(true ,"ItemNotFoundException caught");
} catch(DatabaseNotReachedException exception){

 }

}

/**
 * Test to check DatabaseNotReachedException, simulates a hardcoded item that triggers a fake call to database
 */

@Test 
void DatabaseNotReachedTest(){
try{
    itemID = 10;
   inventory = new InventorySystem();
    inventory.findItemById(itemID); 
    fail("Connection to database established");
} catch(DatabaseNotReachedException Exception){
    assertTrue(true, "Connection to database failed");
} catch(ItemNotFoundException exception){

 }
}


}
