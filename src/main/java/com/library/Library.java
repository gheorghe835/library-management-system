package main.java.com.library;

/*
Library.java
Library gestionează colecția de cărți,
ebook-uri și membri ai bibliotecii.
Această clasă se ocupă de adăugarea, căutarea,
împrumutarea și returnarea item-urilor.
De asemenea, coordonează afișarea catalogului
și verificarea excepțiilor personalizate.
 */

import main.java.com.library.exception.BorrowLimitExceededException;
import main.java.com.library.exception.ItemNotAvailableException;
import main.java.com.library.exception.ItemNotFoundException;
import main.java.com.library.exception.MemberNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<LibraryItem> items;
    private final List<Member> members;
    private int nextId;

    public Library(){
        this.items = new ArrayList<>();
        this.members = new ArrayList<>();
        this.nextId = 1;
    }

    public Book addBook(String title,
                        String author,
                        Genre genre){
        Book book = new Book(nextId++,title,author,genre);
        items.add(book);
        return book;
    }

    public EBook addEBook(String title, String author, Genre genre) {
        EBook ebook = new EBook(nextId++, title, author, genre);
        items.add(ebook);
        return ebook;
    }

    public void addMember(String memberId,String fullName){
        members.add(new Member(memberId,fullName));
    }

    public LibraryItem findItemById(int id) throws ItemNotFoundException{
        for (LibraryItem item : items){
            if (item.getId() == id){
                return item;
            }
        }
        throw new ItemNotFoundException("Item not found with id: " + id);
    }

    public Member findMemberById(String memberId) throws MemberNotFoundException{
        for (Member member : members){
            if (member.getMemberId().equals(memberId)){
                return member;
            }
        }
        throw new MemberNotFoundException("Member not found" + memberId);
    }

    public void borrowItem(int itemId,String memberId)
        throws ItemNotFoundException,ItemNotAvailableException,MemberNotFoundException,
               BorrowLimitExceededException{
        LibraryItem item = findItemById(itemId);
        Member member = findMemberById(memberId);

        if (!item.isAvailable()){
            throw new ItemNotAvailableException("Item is not available: " + item.getTitle());
        }

        if (member.getBorrowedCount() >= 3){
            throw new BorrowLimitExceededException("Borrow limit exceeded for member: " + memberId);
        }

        if (item instanceof Borrowable borrowable){
            borrowable.borrow(memberId);
            member.increaseBorrowedCount();
        }
    }

    public void returnItem(int itemId,String memberId)
            throws ItemNotFoundException,MemberNotFoundException{
        LibraryItem item = findItemById(itemId);
        Member member = findMemberById(memberId);

        if (item instanceof Borrowable borrowable){
            borrowable.giveBack();
            member.decreaseBorrowedCount();
        }
    }

    public void displayCatalog(){
        for (LibraryItem item : items){
            System.out.printf("%-21s : %d%n","ID",item.getId());
            System.out.printf("%-21s : %s%n","Title",item.getTitle());
            System.out.printf("%-21s : %s%n","Author",item.getAuthor());
            System.out.printf("%-21s : %s%n","Type",item.getType());
            System.out.printf("%-21s : %s%n","Available",(item.isAvailable() ? "YES" : "NO"));
            if (!item.isAvailable()){
                System.out.printf("%-21s : %s%n","Borrowed by",item.getBorrowedBy());
            }
            System.out.println();
        }
    }
}
