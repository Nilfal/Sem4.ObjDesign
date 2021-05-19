package intergration;

import util.*;

import java.util.HashMap;


public class DiscountCatalog {

    /**
     * en representation av en disccount katalog.
     */
    private HashMap<MemberID, DiscountRule> discount = new HashMap<>();
    private final int no_disscount = 1;


    public DiscountRule LFDisscount(MemberID ID) {
        if (discount.containsKey(ID)) {
            return discount.get(ID);
        }
        return new DiscountRule(no_disscount);
    }

    private void CustomerCat() {
        discount.put(new MemberID("199"), new DiscountRule(0.9));
        discount.put(new MemberID("198"), new DiscountRule(0.9));
        discount.put(new MemberID("197"), new DiscountRule(0.9));
        discount.put(new MemberID("196"), new DiscountRule(0.9));
        discount.put(new MemberID("195"), new DiscountRule(0.9));
    }

}
