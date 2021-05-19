package intergration;

import util.Amount;

public class Item {

    /*** Item is represetned of 3 things, Itemdescription,Barcode and quiantity. ***/

    private ItemDTO itemDesc;
    private String barcode;
    private Amount quntity;

    /**
     * Skapar en instance av ett item.
     * @param itemDesc förklaring av itemet.
     * @param barcode koden för att identifiera ett item.
     * @param quntity mängden av itemet.
     */
    public Item(ItemDTO itemDesc, String barcode, Amount quntity) {
        this.itemDesc = itemDesc;
        this.barcode = barcode;
        this.quntity = quntity;
    }

    /**
     * Hämtar värdet på ett item.
     * @return värdet på ett item.
     */

    public ItemDTO getItemDesc() {
        return itemDesc;
    }

    /**
     * Hämtar mängden av ett item.
     * @return mängden av ett item.
     */
    public Amount getQuntity() {
        return quntity;
    }

    /**
     * Tar bort bort en viss mängd speciferad av oQuantity.
     * @param oQuantity mängden som kommer tas bort.
     */
    public void minusQuntity(Amount oQuantity) {
        this.quntity = this.quntity.minus(oQuantity);
    }

    /**
     * Lägger till ev viss mängd specifierad av oQuanttiy.
     * @param oQuntity den specifika mängden som läggs till.
     */
    public void plusQuntity(Amount oQuntity) {
        this.quntity = this.quntity.plus(oQuntity);
    }

    /**
     * Hämtar värdet på barcode.
     * @return värdet på barcode.
     */
    public String getBarcode() {
        return barcode;
    }


}
