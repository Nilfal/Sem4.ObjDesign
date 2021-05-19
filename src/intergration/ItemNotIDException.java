package intergration;

public class ItemNotIDException extends Exception {

    String barcode;

    /**
     * En instance av vilket imte som inte Hittades/Existerade.
     */


    public ItemNotIDException(String barcode) {
        super("Angivna varan " + barcode + " hittades inte i systemet.");
        this.barcode = barcode;
    }


    public String getBarcodeThatNotExsist() {
        return barcode;
    }
}
