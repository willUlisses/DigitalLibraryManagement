import java.util.Scanner;

public class Tests {
    public static void main(String[] args) {

        /*Library library = new Library("Central Library", 10);

        Book book1 = new Book("Great Gatsby", "F. Scott Fitzgerald");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee");
        Book book3 = new Book("Livro teste", "Harper Lee");

        library.addBook(book1);
        library.addBook(book2);

        library.showBooks();

        User user1 = new User("Josué", 1);

        user1.borrowBook(book1, library);
        user1.borrowBook(book2, library);

        user1.showUserBorrows();

        user1.returnBook(book1, library);

        user1.showUserBorrows();

        library.addBook(book3);

        library.showBooks();

        user1.borrowBook(book3, library);

        user1.showUserBorrows();*/

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um numero:");

        int numero = scanner.nextInt();
        while (numero >= 1) {
            System.out.println("Processando..." + numero);
            numero--;
            if (numero % 13 == 0) {
                break;
            }
        }
        System.out.println("Processando...");

    }
}
