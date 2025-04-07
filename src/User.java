import java.util.Arrays;

public class User {

    private String name;
    private int userId;
    private Book book;
    private Library library;
    private final Book[] borrowedBooks = new Book[5];
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
        if (book.returnedBook() && borrowsCounter < borrowedBooks.length) {
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
        for (Book borrow : borrowedBooks)
            if (borrow != null) {
                System.out.println("\nYou've borrowed these books: ");
                System.out.println(borrow.getTitle());
            } else if (borrowedBooks[0] == null) {
                System.out.println("You don't have any borrowed book in your account");
                break;
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