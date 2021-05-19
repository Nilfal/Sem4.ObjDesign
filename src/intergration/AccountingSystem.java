package intergration;
import model.Sale;

import java.time.LocalDateTime;
import java.util.HashMap;

public class AccountingSystem {

    /**
     * externt accouting system, representation.
     */
    private HashMap<LocalDateTime, Sale> accounting = new HashMap<>();

    /**
     * Skapar en ny instance av Accounting system.

     */
    AccountingSystem(){}

    /**
     * Uppdaterar accounting system med sale.
     * @param sale efter transaktionen är klar så läggs sale till i externalaccouting.
     */

    public void ExternalAccounting(Sale sale){
        LocalDateTime timeofsale = LocalDateTime.now();
        accounting.put(timeofsale, sale);
    }

}
