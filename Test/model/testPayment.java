package model;

import intergration.Item;
import intergration.ItemDTO;
import org.junit.Test;
import util.Amount;
import static org.junit.Assert.*;

public class testPayment {


    @Test
    public void testGetChange(){


        Amount price = new Amount(55);
        Amount tax = new Amount(15);
        String itemNameAndIdentifier = "Salt";
        ItemDTO itemDescription = new ItemDTO(price, itemNameAndIdentifier, tax);
        Amount quantity = new Amount(1);
        Item item = new Item(itemDescription, itemNameAndIdentifier, quantity);
        Total total = new Total();
        total.updateTotal(item);
        Amount paidAmount = new Amount(100);
        Payment payment = new Payment(paidAmount, total);
        Amount expectedResult = paidAmount.minus(price.multiply(quantity).plus(tax.multiply(quantity)));
        Amount actualResult = payment.getReturnChange();
        assertEquals("Change is not the same.", expectedResult, actualResult);
    }
    }




