package model;
import intergration.Item;
import intergration.ItemDTO;

import org.junit.Test;
import util.Amount;

import static org.junit.Assert.*;

public class testCashReg {




    @Test
    public void testAddPayment() {
        CashReg cashReg = new CashReg();
        Amount price = new Amount(55);
        Amount tax = new Amount(15);
        String itemNameAndIdentifier = "Salt";
        ItemDTO itemDescription = new ItemDTO(price, itemNameAndIdentifier, tax);
        Amount quantity = new Amount(1);
        Item item = new Item(itemDescription, itemNameAndIdentifier, quantity);
        Total total = new Total();
        total.updateTotal(item);
        Amount paidAmount = new Amount(90);
        Payment payment = new Payment(paidAmount, total);
        cashReg.sumPay(payment);
        Amount expectedResult = new Amount(0).plus(payment.getTotal().getTotalWithTax());
        Amount actualResult = cashReg.getBalance();
        assertEquals("CashReg balance är inte samma", expectedResult, actualResult);
    }
}




