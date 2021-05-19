package util;

/**
 * Ett obj som representerar mängden va något specifkt.
 */
public class Amount {


    private final int amount;

    /**
     * Skapar en instance av amount.
     * @param amount den som represeterar den ny skapade instancen.
     */
    public Amount(int amount){
        this.amount = amount;
    }

    /**
     * Hämtar värdet på amount.
     * @return värdet på amount.
     */
    public int getAmount() {
        return amount;
    }
    /**
     * Gör om <code>Amount</code> till <code>String</code> object.
     *
     * @return <code>Amount</code> som en <code>String</code>.
     */
    @Override
    public String toString() {
        return Integer.toString (amount);   }




        public Amount minus (Amount otherA) {
        return new Amount(this.amount - otherA.amount);
        }
    public Amount plus (Amount otherA) {
        return new Amount(this.amount + otherA.amount);
    }

    /**
     * För att multipilcera olika amounts.

     * @return amount * otherA
     */
    public Amount multiply(Amount otherA){return new Amount(this.amount * otherA.amount);}
}
