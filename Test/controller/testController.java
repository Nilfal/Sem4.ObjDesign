package controller;


import intergration.*;
import org.junit.After;
import org.junit.Before;

import org.junit.Test;
import util.Amount;

import static org.junit.Assert.assertEquals;

public class testController {



    private Controller controller;

    @Before
    public void setUp(){

        controller = new Controller(new SystemCreator(),new CatCreator(),new Printer());

    }
    @After
    public void tearDown(){
        controller = null;
    }



    @Test
    public void regItem(){
        controller.newSale();
        String itemName = "Salt";
        Amount price = new Amount(55);
        Amount tax = new Amount(15);
        try{
        String actualResult = controller.scanItem(itemName, new Amount(1));
        String expectedResult = "Varor: " + itemName + "\t" +
                "Pris: " + price + "\t" +
                "Skatt: " + tax + "\t" +
                ", Antal: " + new Amount(1) + ", Totalt: " + price.plus(tax);
        assertEquals("RegItem inte samma Strings", expectedResult, actualResult);
    }catch (ItemNotIDException | ItemDBExeeption exc){

        }}


    // test for a transaktion with payment and receipt

   @Test
    public void displayTotalWithTax()  {
        controller.newSale();
        String itemName = "Salt";
        Amount price = new Amount(55);
        Amount taxAmount = new Amount(15);
       try {
           controller.scanItem(itemName, new Amount(1));


       }catch (ItemNotIDException | ItemDBExeeption exc){

       }

       String actualResult = controller.displayTotalWithTax();
       String expectedResult = "total with taxes: " + price.plus(taxAmount);
       assertEquals("The total with tax from sale is not equal to the expected result.", expectedResult, actualResult);
    }

    @Test
    public void trasaction() {
        controller.newSale();
        String itemName = "Salt";
        Amount price = new Amount(55);
        Amount taxAmount = new Amount(15);
            try {
                controller.scanItem(itemName, new Amount(1));


            }catch (ItemNotIDException | ItemDBExeeption exc){

            }

            String actualResult = controller.displayTotalWithTax();
            String expectedResult = "total with taxes: " + price.plus(taxAmount);
            assertEquals("The total with tax from sale is not equal to the expected result.", expectedResult, actualResult);
        }}




