package model;
import util.Amount;

import intergration.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Representerar både priset samt skatten.
 */
public class Total {




    private Amount total;
    private Amount totalTax;
    private List<SaleObs>  saleObs;


    /**
     * Skapar en instance av Total.
     */
    public Total(){
        this.total = new Amount(0);
        this.totalTax = new Amount(0);
        this.saleObs =new ArrayList<>();
    }

    /**
     * Hämtar värdet på total.
     * @return värdet på total.
     */
    public Amount getTotal() {
        return total;
    }
    /**
     * Hämtar värdet på skatten.
     * @return värdet på skatten.
     */
    public Amount getTotalTax() {
        return totalTax;
    }

    /**
     * Hämtar värdet på total+skatten.
     * @return värdet på total+skatten.
     */
    public Amount getTotalWithTax(){

        notifyObservers();
        return total.plus(totalTax);
    }

    /**
     * Uppdaterar total samt skatten genom att använda itemdisc.
     * @param item vilket item som kommer att läggas till i total.
     */
    public void updateTotal(Item item){
        if (item == null){
            return;
        }
        Amount amountofItems= item.getQuntity();
        Amount itemPrice = item.getItemDesc().getPrice();
        Amount itemTax = item.getItemDesc().getTaxAmount();



        this.totalTax = this.totalTax.plus(amountofItems.multiply(itemTax));
        this.total = this.total.plus(amountofItems.multiply(itemPrice));
    }

    public void updateTotal(Total total){
        this.total = this.total.plus(total.getTotal());
        this.totalTax = this.totalTax.plus(total.getTotalTax());
    }

    public void addPaymentObserver(List<SaleObs> observers){
        saleObs.addAll(observers);
    }



    private void notifyObservers(){
        for (SaleObs obs : saleObs) {
            obs.updateTotal(this.total.plus(this.totalTax));
        }


}}



