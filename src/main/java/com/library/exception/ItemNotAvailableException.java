package main.java.com.library.exception;

/*
ItemNotAvailableException.java – apare când un item există,
dar nu poate fi împrumutat fiindcă este deja luat.
 */

public class ItemNotAvailableException extends LibraryException{
    public ItemNotAvailableException(String message){
        super(message);
    }
}
