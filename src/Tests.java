import java.util.Scanner;

public class Tests {
    public static void main(String[] args) {

        Library library = new Library("Central Library", 10);

        Book book1 = new Book("Great Gatsby", "F. Scott Fitzgerald");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee");

        library.addBook(book1);
        library.addBook(book2);

        library.showBooks();

        book1.borrowedBook();

        book1.bookDetails();


    }
}
