package main.java.com.library;

/*
Main.java
Main este punctul de pornire al aplicației Java.
Aici sunt create obiectele și sunt testate
funcționalitățile sistemului de bibliotecă.
Tot în această clasă se afișează rezultatele și
se verifică dacă programul funcționează corect.
Dacă vrei, pot să-ți scriu acum și o descriere
completă de proiect, gata de pus în documentație.
 */

import main.java.com.library.*;
import main.java.com.library.exception.*;

public class Main {
    public static void main(String[] args) {
        printHeader("LIBRARY MANAGEMENT SYSTEM");

        Library library = new Library();

        printAdditionalInfo("Adding Items");

        Book b1 = library.addBook("Java Basics", "John Smith", Genre.PROGRAMMING);
        System.out.println("Book added: \"" + b1.getTitle() + "\" by " + b1.getAuthor());

        Book b2 = library.addBook("OOP Principles", "Jane Doe", Genre.EDUCATION);
        System.out.println("Book added: \"" + b2.getTitle() + "\" by " + b2.getAuthor());

        Book b3 = library.addBook("Data Structures", "Robert Martin", Genre.PROGRAMMING);
        System.out.println("Book added: \"" + b3.getTitle() + "\" by " + b3.getAuthor());

        EBook e1 = library.addEBook("Clean Code", "Robert Martin", Genre.PROGRAMMING);
        System.out.println("EBook added: \"" + e1.getTitle() + "\" by " + e1.getAuthor());

        printAdditionalInfo("Adding Members");

        library.addMember("M001", "Ion Popescu");
        System.out.println("Member added: M001 - Ion Popescu");
        library.addMember("M002", "Maria Ionescu");
        System.out.println("Member added: M002 - Maria Ionescu");

        printAdditionalInfo("Library Catalog");
        library.displayCatalog();

        printAdditionalInfo("Borrowing Items");
        try {
            library.borrowItem(1, "M001");
            System.out.println("M001 borrowed: \"Java Basics\"");

            library.borrowItem(4, "M002");
            System.out.println("M002 borrowed: \"Clean Code\"");
        } catch (LibraryException e) {
            System.out.println("Error: " + e.getMessage());
        }

        printAdditionalInfo("Catalog After Borrowing");
        library.displayCatalog();

        System.out.println("--- Testing Exceptions ---");

        printAdditionalInfo("Test 1: Borrow unavailable item");
        try {
            library.borrowItem(1, "M002");
        } catch (LibraryException e) {
            System.out.println("Error: " + e.getMessage());
        }

        printAdditionalInfo("Test 2: Find non-existent item");
        try {
            library.findItemById(999);
        } catch (LibraryException e) {
            System.out.println("Error: " + e.getMessage());
        }

        printAdditionalInfo("Test 3: Find non-existent member");
        try {
            library.findMemberById("M999");
        } catch (LibraryException e) {
            System.out.println("Error: " + e.getMessage());
        }

        printAdditionalInfo("Returning Items");
        try {
            library.returnItem(1, "M001");
            System.out.println("M001 returned: \"Java Basics\"");
        } catch (LibraryException e) {
            System.out.println("Error: " + e.getMessage());
        }

        printAdditionalInfo("Final Catalog");
        library.displayCatalog();

        printFooter();

    }

    public static void printHeader(String title){
        System.out.println("====================================");
        System.out.println("        " + title);
        System.out.println("====================================");
    }

    public static void printAdditionalInfo(String title){
        System.out.println("--- " + title + " ---");
    }

    public static void printFooter() {
        System.out.println("====================================");
        System.out.println("Program finished successfully.");
    }
}
