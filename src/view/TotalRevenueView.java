package view;

import model.SaleObs;

import util.Amount;

public class TotalRevenueView implements SaleObs {
    private Amount totalRev;



    public TotalRevenueView(){
        this.totalRev = new Amount(0);
    }

    @Override
    public void updateTotal(Amount total) {
        this.totalRev = total;
        printRev();
    }


    private void printRev(){
        System.out.println("*** TOTAL Omsättning ***");
        System.out.println("   Summa: " + totalRev.getAmount());

    }
}
