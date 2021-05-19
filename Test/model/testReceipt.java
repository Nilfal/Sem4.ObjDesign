package model;

import intergration.Item;
import intergration.ItemDTO;
import org.junit.Test;
import util.Amount;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class testReceipt {

    @Test
    public void testToString() {
        Amount price = new Amount(55);
        Amount tax = new Amount(15);
        String itemNameAndIdentifier ="Salt";
        ItemDTO itemDescription = new ItemDTO(price, itemNameAndIdentifier, tax);
        Amount quantity = new Amount(1);
        Item item = new Item(itemDescription, itemNameAndIdentifier, quantity);
        Sale sale = new Sale();
        sale.saleRefresh(item);
        Receipt receipt = new Receipt(sale);
        LocalDateTime saleTime = LocalDateTime.now();
        String expectedResult =
                "\n------AffärensNamn-------" +
                "\n----------Kvitoo----------" +
                "\nTime of Sale: " + saleTime.toLocalDate().toString() +
                "\nVaror: "+
                "\nVara :"+itemNameAndIdentifier + "\nTotal: " + price + "\nSkatt: " + tax +"\n"+"\n";
        String actualResult = receipt.toString();
        assertEquals("Receipt string is not equal to another instance with same state.", expectedResult, actualResult);
    }

}
