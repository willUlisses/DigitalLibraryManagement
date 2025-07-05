import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Library {

    private Set<Book> availableBooks = new LinkedHashSet<>();
    private Map<Integer, User> registeredUsers = new LinkedHashMap<>();
    private List<Lending> activeLendings = new LinkedList<>();
    private Integer idCounter = 1;
    private Integer isbnCounter = 1;

    public void addBook(Book book) {
        if (book.getIsbn() == null || book.getIsbn().isEmpty()){
            book.setIsbn("ISBN-" + String.format("%04d", isbnCounter));
            isbnCounter++;
        }
        availableBooks.add(book);
    }

    public void showAllBooks() {
        Iterator<Book> iteratorBooks = availableBooks.iterator();
        Book next = iteratorBooks.next();
        while (iteratorBooks.hasNext()){
            System.out.println("Title: " + next.getTitle() +
                    "Author: " + next.getAuthor() +
                    "ISBN:" + next.getIsbn() + "\n");
        }
    }

    public List<Book> findByTitle(String title) {
        return availableBooks.stream()
                //filtra os livros com o nome que passamos
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                //coleta eles numa nova lista que será retornada contendo esses livros que passaram pelo
                //predicado dentro do filter
                .collect(Collectors.toList());
    }

    public Book findByISBN(String isbn){
        return availableBooks.stream()
                //Filtra os livros para aquele cujo isbn é idêntico ao passado no parâmetro
                .filter(book -> book.getIsbn().equalsIgnoreCase(isbn))
                //retorna esse livro único já que o ISBN é um valor único para cada livro, caso não exista nenhum retornará null.
                .findFirst().orElse(null);
    }

    public void removeBook(String isbn) {
        availableBooks.removeIf(book -> book.getIsbn().equalsIgnoreCase(isbn));
    }

    public void registrateUser(User user) {
        user.setUserId(this.idCounter);
        registeredUsers.put(user.getUserId(), user);
        this.idCounter++;
    }

    public Optional<User> findUserById(Integer id) {
        return Optional.ofNullable(registeredUsers.get(id));
    }

    public void makeLoan(String isbnBook, Integer idUser) {
        Optional<Book> borrowedBook = availableBooks.stream()
                .filter(book -> book.getIsbn().equalsIgnoreCase(isbnBook))
                .findFirst();

        Optional<User> userLending = findUserById(idUser);

        if (borrowedBook.isPresent() && userLending.isPresent()) {
            activeLendings.add(new Lending(borrowedBook.get(),userLending.get()));
            borrowedBook.get().setAvailable(false);
            availableBooks.remove(borrowedBook.get());
        }
    }

    public void returnBook(String isbn, Integer userId) {

        //Stream que encontra dentro da Lista de empréstimos
        // o empréstimo cujo ISBN do livro é o mesmo do que queremos devolver (pesquisa única)
        Optional<Lending> lending = activeLendings.stream()
                .filter(len -> len.getBook().getIsbn().equalsIgnoreCase(isbn))
                .findFirst();

        //Stream que retorna o livro do empréstimo
        Optional<Book> returningBook = activeLendings.stream()
                .map(Lending::getBook)
                .filter(book -> book.getIsbn().equalsIgnoreCase(isbn))
                .findFirst();

        //Stream que encontra o user no id passado como parâmetro
        Optional<User> userReturning = findUserById(userId);

        if (returningBook.isPresent() && userReturning.isPresent() && lending.isPresent()) {
            lending.get().setReturningDate(LocalDate.now());
            returningBook.get().setAvailable(true);
            activeLendings.remove(lending.get());
            availableBooks.add(returningBook.get());
        }
    }


}
