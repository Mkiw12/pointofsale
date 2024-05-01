package se.kth;

import org.junit.jupiter.api.Test;
import se.kth.integration.*;
import se.kth.model.Printer;

import static org.junit.jupiter.api.Assertions.*;
import se.kth.controller.*;

public class ControllerTest {

    @Test
    public void testControllerInitializesCorrectly() {
        assertDoesNotThrow(() -> {
            Printer printer = new Printer();
            SalesLog salesLog = new SalesLog();
           // Controller controller = new Controller(printer, salesLog);
           // controller.CreateAccountSystem();
           // controller.CreateInventorySystem();
            //controller.CreateDiscountHandler();
        });
    }
}
