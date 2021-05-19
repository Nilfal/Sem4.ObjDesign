package view;

import controller.Controller;
import intergration.ItemDBExeeption;
import intergration.ItemNotIDException;
import model.Total;
import util.Amount;
import util.LogHandler;
import util.TotalRevenueFileOutput;

import java.io.IOException;

/**
 * Ett exempel på hur en view skulle kunna se ut . Då denna applikation sakanar en fakstist view.
 */
public class View {
    private final TotalRevenueFileOutput totalrev;
    private Controller controller;
    private LogHandler logHandler;
    private ExeptionPrinter exceptionPrinter;



    /**
     * Skapar en instsance av en view.
     * @param controller där ifrån alla metoder anropas.
     */
    public View(Controller controller) throws IOException {
        this.totalrev = new TotalRevenueFileOutput();
        this.controller = controller;
        controller.addPaymentObserver(new TotalRevenueView());
        controller.addPaymentObserver(totalrev);
        exceptionPrinter = new ExeptionPrinter();
        logHandler = new LogHandler();


    }



    /**
     * Mitt exempel på hur en transaktion med en kassör tillexempel skulle kunna se ut.
     */
    public void exampel(){
        String out;
        System.out.println("Tillfället för \n");
        controller.newSale();
        System.out.println("Scannar varor. \n");

        scanItem("Salt", new Amount(10));
        scanItem("ERROR", new Amount(20));



        try{
            System.out.println("Kassören säger att det kosta:. \n");
            out = controller.displayTotalWithTax();
            System.out.println(out + "\n");
        }catch (IllegalStateException exc){
            showExeption("Kassören misslyckades med inloggning ", exc);
        }

        try {
            System.out.println("Kassören tar emot betalningen \n");
            out = controller.transaction(new Amount(2000));
            System.out.println(out);
        }catch (IllegalStateException exc){
            showExeption("Kassören misslyckades med inloggning ", exc);
        }



    }

    private void scanItem(String itemIdentifier, Amount amount){
        String out;
        try {
            out = controller.scanItem(itemIdentifier, amount);
            System.out.println(out);
        }catch (ItemNotIDException | ItemDBExeeption exc) {
            showExeption("Stäckkoden " + itemIdentifier +  " Hittades inte testa scanna om varan.", exc);
        }

    }

    private void showExeption(String message, Exception exception){
        //ErrorExeeptionHandler.errorPrint(message);
        exceptionPrinter.print(message);
        logHandler.logException(exception);
    }

}
