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
            System.out.println("The book " + book.getTitle() + " was successfully borrowed");
        }
        else if (borrowsCounter > borrowedBooks.length) {
            System.out.println("You can't borrow more than 5 books");
        }
    }

    public void showUserBorrows() {
        System.out.println("\nYou've borrowed these books: ");
        for (Book borrow : borrowedBooks) {
            System.out.println(borrow);
        }
    }

}