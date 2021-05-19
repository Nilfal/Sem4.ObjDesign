package controller;

import intergration.*;
import model.*;
import util.Amount;

import java.util.ArrayList;
import java.util.List;


public class Controller {
 private Sale sale;
 private InvSys invSys;
 private Printer printer;
 private CashReg cashReg;
 private ItemCat itemCat;
 private AccountingSystem accountingSystem;
 private DiscountCatalog discountCatalog;
 private List<SaleObs> saleObs = new ArrayList<>();


/**
 * Skapar en ny intance av controller
 * @param systemCreator tar hand om externa system.
 * @param catCreator tar hand om de olika catalogerna.
 * @param printer en "printer" exempel.
 */





 public Controller(SystemCreator systemCreator, CatCreator catCreator, Printer printer){
     this.invSys = systemCreator.getInventorySystem();
     this.printer = printer;
     this.cashReg = new CashReg();
     this.itemCat = catCreator.getItemCat();
     this.accountingSystem = systemCreator.getAccountingSystem();
     this.discountCatalog = catCreator.getDiscountCatalog();

 }

    /**
     * initsierar en ny "sale"
     *
     */
 public void newSale(){
     this.sale = new Sale();
     sale.getTotal().addPaymentObserver(saleObs);

 }

    /**
     * Scann funktionen för kassan, tittar på barcode för att itemet existaerar. gör det det lägger det till den i sale och retunerar informationen
     * Om den inte hittar ett item visar den bara running total.
     * @param barcode är varans identifierar vilket vi lägger till i sale.
     * @param quantity är mängden av varan vi ska lägga till.
     *
     *
     *
     */
 public String scanItem (String barcode, Amount quantity)throws ItemDBExeeption,ItemNotIDException{
         Item item = itemCat.getItem(barcode,quantity);
         return sale.saleRefresh(item) + ", Antal: " + quantity.toString() +
                 ", Totalt: " + displayTotal();

 }


    /**
     * Visar vad den totala blir med tax och priset.
     * @return retunerar totalen som en string.
     */
 public String displayTotal() throws IllegalStateException{

     return sale.getTotal().getTotalWithTax().toString();

 }

    /**
     * Är själva betalningen, där balansen i cashReg. samt att kvittot printas.
     *
     * @param customerPay är pengarna customer ger till kassören.
     *
     * @return är den växeln som man får tillbaka.
     */

 public String transaction (Amount customerPay){
     Payment payment = new Payment(customerPay, sale.getTotal());
     //sale.getTotal().addPaymentObserver(saleObs);
     cashReg.sumPay(payment);
     Receipt receipt = new Receipt(sale);
     printer.printRec(receipt);
     accountingSystem.ExternalAccounting(sale);
     invSys.updateInv(sale);
     sale = null;

     return "Return Change:" + payment.getReturnChange().toString();


 }


    /**
     * Totala priset + skatten.
     *
     * @return Retunerar vad som ska betalas.
     */
    public String displayTotalWithTax(){
        return "total with taxes: " + sale.getTotal().getTotalWithTax().toString();
    }

    public void addPaymentObserver(SaleObs saleObs){
        this.saleObs.add(saleObs);

    }




}
