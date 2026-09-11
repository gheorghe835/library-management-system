package main.java.com.library.exception;

/*
ItemNotFoundException.java – apare când o
carte sau un ebook căutat nu există în bibliotecă.
 */

public class ItemNotFoundException extends LibraryException{
    public ItemNotFoundException(String message){
        super(message);
    }
}
