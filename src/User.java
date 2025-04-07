import java.util.Arrays;

public class User {

    private String name;
    private int userId;
    private Book book;
    private Library library;
    private final Book[] borrowedBooks;
    private int borrowsCounter;

    public User(String name, int userId) {
        this.name = name;
        this.userId = userId;
        this.borrowedBooks = new Book[5];
        this.borrowsCounter = 0;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void borrowBook(Book book, Library library) {
        if (book.getAvailable() && borrowsCounter < borrowedBooks.length) {
            borrowedBooks[borrowsCounter] = book;
            borrowsCounter++;
            library.setBookUnavailable(book);
            System.out.println("\nThe book " + book.getTitle() + " was successfully borrowed");
        }
        else if (borrowsCounter > borrowedBooks.length) {
            System.out.println("You can't borrow more than 5 books");
        }
    }

    public void showUserBorrows() {
        System.out.println("\nYou've borrowed these books: ");
        for (Book borrow : borrowedBooks) {
            if (borrow != null) {
                System.out.println(borrow.getTitle());
            }
        }
    }

    public void returnBook(Book book, Library library) {
        for (Book returnedBook : borrowedBooks) {
            if (returnedBook == book) {
                borrowedBooks[borrowsCounter - 1] = borrowedBooks[borrowsCounter];
            }
        }
        library.setBookAvailable(book);
        System.out.println("\nThe book has been returned to the library.");
    }
}