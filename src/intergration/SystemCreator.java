package intergration;

public class SystemCreator {



    private AccountingSystem accountingSystem;
    private InvSys inventorySystem;



    /* SystemCreator makes creates the diffrent systems*/

    public SystemCreator(){
        inventorySystem = new InvSys();
        accountingSystem = new AccountingSystem();
    }

    /* getter methods for inventorysystem & accoutingsystem*/

    public InvSys getInventorySystem() {
        return inventorySystem;
    }

    public AccountingSystem getAccountingSystem() {
        return accountingSystem;
    }


}
