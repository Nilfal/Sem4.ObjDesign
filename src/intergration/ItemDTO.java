package intergration;

import util.Amount;

/**
 * En data transport för ett item.
 */
public class ItemDTO {


    private final Amount price;
    private final String ItemName;
    private final Amount taxAmount;

    /**
     *  skapar en instance av ett specifikt item.
     * @param price price representerar priset på den varan.
     * @param itemName represetnerar namnet på varan.
     * @param taxAmount represetenrear skatten på varan.
     */

    public ItemDTO(Amount price, String itemName, Amount taxAmount) {
        this.price = price;
        this.ItemName = itemName;
        this.taxAmount = taxAmount;
    }

    /**
     * Hämtar värdet på price.
     * @return värdet på price.
     */
    public Amount getPrice() {
        return price;
    }

    /**
     * Hämtar namnet på varan.
     * @return Namnet på varan.
     */
    public String getItemName() {
        return ItemName;
    }

    /**
     * Hämtar skatten på varan.
     * @return skatten på varan.
     */
    public Amount getTaxAmount() {
        return taxAmount;
    }

/**
 * Skapar en instance av  hur koden ska skrivas.

 */
    @Override
    public String toString() {
        String builder = "Varor: " + ItemName + "\t" +
                "Pris: " + price + "\t" +
                "Skatt: " + taxAmount + "\t";
        return builder;
    }
}
