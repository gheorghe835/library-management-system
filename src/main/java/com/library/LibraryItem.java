package main.java.com.library;

/*
LibraryItem.java – este clasa abstractă de
bază pentru toate elementele bibliotecii,
cu atribute comune precum titlu, autor și disponibilitate.
 */

public abstract class LibraryItem {
    private final int id;
    private final String title;
    private final String author;
    private final Genre genre;
    private  boolean available;
    private String borrowedBy;

    public LibraryItem(int id,
                       String title,
                       String author,
                       Genre genre){
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.available = true;
        this.borrowedBy = null;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Genre getGenre() {
        return genre;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getBorrowedBy() {
        return borrowedBy;
    }

    protected void setAvailable(boolean available){
        this.available = available;
    }
    protected void setBorrowedBy(String borrowedBy){
        this.borrowedBy = borrowedBy;
    }

    public abstract String getType();
}
