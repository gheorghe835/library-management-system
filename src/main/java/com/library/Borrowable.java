package main.java.com.library;

/*
Borrowable.java – este o interfață care
definește comportamentul pentru item-urile
ce pot fi împrumutate și returnate.
 */

public interface Borrowable {
    void borrow(String memberId);
    void giveBack();
    boolean isAvailable();
}
