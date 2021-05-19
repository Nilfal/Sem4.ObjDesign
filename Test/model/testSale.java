package model;

import intergration.Item;
import intergration.ItemDTO;
import org.junit.Test;
import util.Amount;
import static org.junit.Assert.*;
public class testSale {


    @Test
    public void testSaleRefresh(){

        Amount price = new Amount(55);
        Amount tax = new Amount(15);
        String itemNameAndIdentifier = "Salt";
        ItemDTO itemDesc = new ItemDTO(price, itemNameAndIdentifier, tax);
        Amount quantity = new Amount(4);
        Item item = new Item(itemDesc, itemNameAndIdentifier, quantity);
        Sale sale = new Sale();
        String actualResult = sale.saleRefresh(item);
        String expectedResult = item.getItemDesc().toString();
        assertEquals("Skillnad i stringsen", expectedResult, actualResult);



    }



@Test
    public void TestToString(){
        Amount price = new Amount(50);
        Amount tax = new Amount(15);
        String itemNameAndIdentifier = "Salt";
        ItemDTO itemDesc = new ItemDTO(price, itemNameAndIdentifier, tax);
        Amount quantity = new Amount(1);
        Item item = new Item(itemDesc, itemNameAndIdentifier, quantity);
        Sale sale = new Sale();
        sale.saleRefresh(item);
    String expectedResult = "Vara :"+itemNameAndIdentifier +
             "\nTotal: " + price + "\nSkatt: " + tax + "\n";
    String actualResult = sale.toString();
    assertEquals("Strings with the same entries not the same.", expectedResult, actualResult);
}


}




