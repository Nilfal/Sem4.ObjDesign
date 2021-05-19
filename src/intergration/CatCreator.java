package intergration;


/**
 * En katalog skapare som består av två olika kataloger.
 *
 */

public class CatCreator {

    private DiscountCatalog discountCatalog;
    private ItemCat itemCat;


    /**
     * Skappar en katalog instance
     */


    public CatCreator(){
        discountCatalog =new DiscountCatalog();
        itemCat = new ItemCat();
    }

    /**
     * hämtar värdet på itemcat
     * @return värdet på itemcat
     */
    public ItemCat getItemCat() {
        return itemCat;
    }

    /**
     * hämtar värdet på disccountcatalog
     *
     * @return retunerar värdet på discountcatalog
     */

    public DiscountCatalog getDiscountCatalog() {
        return discountCatalog;
    }
}



