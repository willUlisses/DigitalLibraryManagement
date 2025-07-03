import java.time.LocalDate;
import java.util.Objects;

public class Lending {

    private Book book;
    private User user;
    private LocalDate lendingDate;
    private LocalDate returningDate;

    public Lending(Book book, User user, LocalDate returningDate) {
        this.book = book;
        this.returningDate = returningDate;
        this.lendingDate = LocalDate.now();
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getLendingDate() {
        return lendingDate;
    }

    public LocalDate getReturningDate() {
        return returningDate;
    }

    public User getUser() {
        return user;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setLendingDate(LocalDate lendingDate) {
        this.lendingDate = lendingDate;
    }

    public void setReturningDate(LocalDate returningDate) {
        this.returningDate = returningDate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Lending len = (Lending) o;
        return Objects.equals(this.book, len.book) && Objects.equals(this.user, len.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(book, user);
    }

    @Override
    public String toString() {
        return "Lending{" +
                "book=" + book +
                ", user=" + user +
                ", lendingDate=" + lendingDate +
                ", returningDate=" + returningDate +
                '}';
    }
}
