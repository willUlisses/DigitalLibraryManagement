import java.util.Objects;

public class Book {

    private final String TITLE;
    private final String AUTHOR;
    private boolean available;
    private String isbn;

    public Book(String title, String author) {
        this.TITLE = title;
        this.AUTHOR = author;
        this.available = true;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return TITLE;
    }

    public String getAuthor() {
        return AUTHOR;
    }

    public String isAvailable() {
        if (available) {
            return "The Book is available";
        } else
            return "The Book isn't available";
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean getAvailable() {
        return available;
    }

    public String getIsbn() {
        return isbn;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(this.isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() {
        return "Book{" +
                "TITLE='" + TITLE + '\'' +
                ", AUTHOR='" + AUTHOR + '\'' +
                ", available=" + available +
                ", ISBN=" + isbn +
                '}';
    }


}
