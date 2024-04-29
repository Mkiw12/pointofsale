package se.kth;

<<<<<<< HEAD
import se.kth.controller.*;

import org.junit.jupiter.api.BeforeEach;
=======
>>>>>>> d68d57b051bc1be7570f36de6c296950ee998dea
import org.junit.jupiter.api.Test;
import se.kth.integration.*;

import static org.junit.jupiter.api.Assertions.*;
import se.kth.controller.*;

public class ControllerTest {

    @Test
    public void testControllerInitializesCorrectly() {
        assertDoesNotThrow(() -> {
            Printer printer = new Printer();
            SalesLog salesLog = new SalesLog();
            Controller controller = new Controller(printer, salesLog);
            controller.CreateAccountSystem();
            controller.CreateInventorySystem();
            controller.CreateDiscountHandler();
        });
    }
}
