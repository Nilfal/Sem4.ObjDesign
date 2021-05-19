package model;

import util.Amount;
import java.util.ArrayList;
import java.util.List;

/**
 * En betalning av sale.
 */
public class Payment {
    private List<SaleObs> saleObs = new ArrayList();
    private Amount payAmount;
    private Total total;

    /**
     * Skapar en ny instance av payment.
     * @param payAmount vad kunden faktiskt ger i betalning
     * @param total vad kunden ska betala.
     */
    public Payment(Amount payAmount, Total total) {

        this.payAmount = payAmount;
        this.total = total;
    }

    /***
     * hämtar total
     * @return värdet på total.
     */

    public Total getTotal() {
        return total;
    }

    /**
     * hämtar värdet på payAmount.
     * @return värdet på payAmount.
     */
    public Amount getPayAmount() {
        return payAmount;
    }

    /**
     * Hämtar värdet på växeln.
     * @return värdet på växeln.
     */
    public Amount getReturnChange() {

        return payAmount.minus(total.getTotalWithTax());

    }


}



