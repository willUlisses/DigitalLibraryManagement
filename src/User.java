import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private int userId;
    private Book book;
    private Library library;

    private Book[] borrowedBooks;
    private int borrowsCounter;

    public User(String name, int userId) {
        this.name = name;
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void borrowBook(Book book, Library library) {
        if (book.returnedBook()) {
            borrowedBooks[borrowsCounter] = book;
            borrowsCounter++;
            library.setBookUnavailable(book);
        }
    }
}