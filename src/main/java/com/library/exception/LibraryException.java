package main.java.com.library.exception;

/*
LibraryException.java – este clasa de bază pentru
toate excepțiile personalizate din sistemul bibliotecii.
 */

public class LibraryException extends Exception{
    public LibraryException(String message){
        super(message);
    }
}
