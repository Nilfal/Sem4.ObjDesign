package intergration;
import intergration.ItemDBExeeption;
import java.util.HashMap;

import util.Amount;

/**
 * En mockup DB (datebase)
 */
public class ItemCat {

    private HashMap<String, ItemDTO> listItems = new HashMap<>();

    /**
     * Skapar en Instance av item katalogen (DB).
     */
    ItemCat() {
        selItem();
    }

    /**
     * Tittar ifall ett visst item finns i DB.
     * @param barcode represetnerar vilket item som kollas upp.
     * @return retunerar ifall itemt finns eller inte.
     */
    public boolean avaliableItem(String barcode) {
        return listItems.containsKey(barcode);
    }

    /**
     * Hämtar itemdesc med hjälp av barcode.
     * retunerar item + en mängd av itemet.
     * @param bacrode identiferar vilket item det är.
     * @param quantity mängden av itemt.
     * @return Itemdesc och quantity.
     */
    public Item getItem(String bacrode, Amount quantity) throws ItemNotIDException, ItemDBExeeption {
        if (!avaliableItem(bacrode)) {
            throw new ItemNotIDException(bacrode);
        }
        Item newItem = new Item(listItems.get(bacrode), bacrode, quantity);
        if (newItem.getBarcode() != bacrode){
            throw new ItemDBExeeption("Fel vara från DB");
        }


        return newItem;
    }


    private void selItem() {
        listItems.put("Apple", new ItemDTO(new Amount(30), "Apple", new Amount(10)));
        listItems.put("Biff", new ItemDTO(new Amount(35), "Biff", new Amount(10)));
        listItems.put("Peppar", new ItemDTO(new Amount(45), "Peppar", new Amount(10)));
        listItems.put("Salt", new ItemDTO(new Amount(55), "Salt", new Amount(15)));


    }

}
