package main.java.com.library.exception;

/*
BorrowLimitExceededException.java – apare când un membru a
depășit numărul maxim de cărți pe care le poate împrumuta
 */

public class BorrowLimitExceededException extends LibraryException{
    public BorrowLimitExceededException(String message){
        super(message);
    }
}
