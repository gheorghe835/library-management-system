package main.java.com.library;

/*
Book.java – reprezintă o carte fizică din
bibliotecă și extinde clasa abstractă LibraryItem.
 */

public class Book extends LibraryItem implements Borrowable{
    public Book(int id,
                String title,
                String author,
                Genre genre){
        super(id, title, author, genre);
    }

    @Override
    public String getType(){
        return "Book";
    }

    @Override
    public void borrow(String memberId){
        setAvailable(false);
        setBorrowedBy(memberId);
    }

    @Override
    public void giveBack(){
        setAvailable(true);
        setBorrowedBy(null);
    }

    @Override
    public boolean isAvailable(){
        return super.isAvailable();
    }
}
