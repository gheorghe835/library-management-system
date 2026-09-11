package main.java.com.library.exception;

/*
MemberNotFoundException.java – apare când un membru căutat nu există în sistem.
 */
public class MemberNotFoundException extends LibraryException{
    public MemberNotFoundException(String message){
        super(message);
    }
}
