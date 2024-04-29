package se.kth.view;

import se.kth.controller.Controller;


public class View
{
    private Controller control;

    public View(Controller control)
    {
        this.control = control;
    }

    public void runFakeExe()
    {
        control.initialteSale();
        System.out.println("A new sale has started");
    }
}
