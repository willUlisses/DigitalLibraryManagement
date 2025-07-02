import java.util.Objects;

public abstract class Book {

    private final String TITLE;
    private final String AUTHOR;
    private boolean available;
    private final Integer ISBN;

    public Book(String title, String author, Integer isbn) {
        this.TITLE = title;
        this.AUTHOR = author;
        this.ISBN = isbn;
        this.available = true;
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

    public Integer getISBN() {
        return ISBN;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(this.ISBN, book.ISBN);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ISBN);
    }

    @Override
    public String toString() {
        return "Book{" +
                "TITLE='" + TITLE + '\'' +
                ", AUTHOR='" + AUTHOR + '\'' +
                ", available=" + available +
                ", ISBN=" + ISBN +
                '}';
    }


}
