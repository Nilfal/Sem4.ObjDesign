package model;
import util.Amount;

/**
 * Represeterar en mochup kassaregister.
 */
public class CashReg {




    private Amount balance;


    /**
     * skapar en instance av kassa registeret med ett innehåll på balansen som noll.
     */
    public CashReg(){

        this.balance = new Amount(0);

    }

    /**
     * Hämtar värdet på balance.
     * @return värdet på balance.
     */
    public Amount getBalance() {

        return balance;
    }

    /**
     * Uppdaterar balance.
     * @param payment det pengar som ska adderas till balansen.
     */
    public void updateBalance(Payment payment) {
        balance = balance.plus(payment.getTotal().getTotalWithTax());
    }


    public void sumPay(Payment payment){
        balance = balance.plus(payment.getTotal().getTotalWithTax());
    }

}
