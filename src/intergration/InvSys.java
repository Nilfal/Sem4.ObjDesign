package intergration;

import java.util.HashMap;
import java.util.Map;

import model.Sale;
import util.Amount;

import java.util.Set;


public class InvSys {
    /**
     * Represetntear en class som tittar på den externa inventory system.
     */

    private HashMap<String, Item> inv = new HashMap<>();

    /**
     * Skapar en instance av inventory system
     */
    InvSys() {
        selItem();
    }

    /**
     * uppdaterar inventory systemet med items.
      * @param sale ger information om vilka typ av items det gäller.
     */
    public void updateInv(Sale sale) {
        HashMap<String, Item> items = sale.getItems();
        Set entries = items.entrySet();


        for (Object entry : entries) {
            Item item = getCurrentItem(entry);

            if (avaliableIteminInv(item)) {
                removeItemInInv(item);
            }
        }

    }



    private boolean avaliableIteminInv(Item item) {
        return inv.containsKey(item.getBarcode());
    }



    private void removeItemInInv(Item item) {
        Item soldItem = inv.get(item.getBarcode());
        soldItem.minusQuntity(soldItem.getQuntity());
        inv.put(soldItem.getBarcode(), soldItem);
    }

    /**
     * hämtar ett specifekt item ur inventoryt.

     */

    private Item getCurrentItem(Object entry) {
        Map.Entry mapping = (Map.Entry) entry;
        return (Item) mapping.getValue();
    }

    private void selItem() {
        inv.put("Apple", new Item(new ItemDTO(new Amount(30), "Apple", new Amount(10)), "Apple", new Amount(Integer.MAX_VALUE)));
        inv.put("Biff", new Item(new ItemDTO(new Amount(35), "Biff", new Amount(10)), "Biff", new Amount(Integer.MAX_VALUE)));
        inv.put("Peppar", new Item(new ItemDTO(new Amount(45), "Peppar", new Amount(10)), "Peppar", new Amount(Integer.MAX_VALUE)));
        inv.put("Salt", new Item(new ItemDTO(new Amount(55), "Salt", new Amount(15)), "Salt", new Amount(Integer.MAX_VALUE)));
    }


}
