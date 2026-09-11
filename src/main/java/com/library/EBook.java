package main.java.com.library;

/*
EBook.java – reprezintă o carte electronică și
extinde clasa abstractă LibraryItem.
 */

public class EBook extends LibraryItem implements Borrowable{
    public EBook(int id,
                 String title,
                 String author,
                 Genre genre){
        super(id, title, author, genre);
    }

    @Override
    public String getType(){
        return "EBook";
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
