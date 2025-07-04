import java.util.*;
import java.util.stream.Collectors;

public class Library {

    private Set<Book> availableBooks = new LinkedHashSet<>();
    private Set<User> registeredUsers = new LinkedHashSet<>();
    private List<Lending> activeLendings = new LinkedList<>();

    public void addBook(Book book) {
        availableBooks.add(book);
    }

    public void showAllBooks() {
        Iterator<Book> iteratorBooks = availableBooks.iterator();
        Book next = iteratorBooks.next();
        while (iteratorBooks.hasNext()){
            System.out.println("Title: " + next.getTitle() +
                    "Author: " + next.getAuthor() +
                    "ISBN:" + next.getISBN() + "\n");
        }
    }

    public List<Book> findByTitle(String title) {
        return availableBooks.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    public Book findByISBN(String isbn){
        return availableBooks.stream()
                //Filtra os livros para aquele cujo isbn é idêntico ao passado no parâmetro
                .filter(book -> book.getISBN().equalsIgnoreCase(isbn))
                //retorna esse livro único já que o ISBN é um valor único para cada livro, caso não exista nenhum retornará null.
                .findFirst().orElse(null);
    }

    public void removeBook(String isbn) {
        availableBooks.removeIf(book -> book.getISBN().equalsIgnoreCase(isbn));
    }



}
