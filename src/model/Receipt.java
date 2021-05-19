package model;

import java.time.LocalDateTime;

/**
 * Ett mockup kvitto
 */

public class Receipt {


    private Sale sale;


    /**
     * Skapar en instance av ett kvitto.
     * @param sale den information som kvittot ska innehålla.
     */
    public Receipt(Sale sale){

    this.sale = sale;

}

private void NewRowReceipt(StringBuilder builder){
    builder.append("\n");
};

private void NewLineReceipt(StringBuilder builder, String line){
    builder.append(line);
    NewRowReceipt(builder);
}

private void TimeDateReceipt(StringBuilder builder){
    LocalDateTime timeOfSale = LocalDateTime.now();
    NewLineReceipt(builder,"Time of Sale: "+timeOfSale.toLocalDate().toString());
}

    /**
     * Skapar en instance till ett <code>String</code >
     * @return en instance till ett <code>String</code >
     */

@Override
public String toString() {
    StringBuilder builder = new StringBuilder();
    NewRowReceipt(builder);
    NewLineReceipt(builder, "------AffärensNamn-------");
    NewLineReceipt(builder, "----------Kvitoo----------");
    TimeDateReceipt(builder);
    NewLineReceipt(builder, "Varor: ");
    NewLineReceipt(builder, sale.toString());


    return builder.toString();
}


    }




