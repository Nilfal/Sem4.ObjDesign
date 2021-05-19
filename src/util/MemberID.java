package util;

/**
 *  represetnerar en kund medlemskap
 */
public class MemberID {
    private String memberIDNumber;


    /**
     * Skapar en instance av ett kundmedlemsskap
     * @param memberIDNumber id nummret för kundmedlemskapet.
     */
    public MemberID(String memberIDNumber){
        this.memberIDNumber = memberIDNumber;
    }


    public String getMemberIDNumber() {
        return memberIDNumber;
    }
}
