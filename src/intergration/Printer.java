package intergration;


import model.Receipt;

public class Printer {

    /* instance of a printer*/
    public Printer() {
    }


    /**
     * use system out to create a receipt fictional receipt
     */

    public void printRec(Receipt receipt) {

        System.out.println(receipt.toString());

    }


}
