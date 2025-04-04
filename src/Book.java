public abstract class Book {

    private String title;
    private String author;
    private String bookIdentifier;
    private boolean available;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    protected boolean borrowedBook() {
        return available = false;
    }

    protected boolean returnedBook() {
        return available = true;
    }

    protected void bookDetails(Book book) {
        System.out.println("Title: " + this.title + "\n" +
                "Author: " + this.author + "\n" +
                "ISBN: " + this.bookIdentifier + "\n" +
                "Availability: " + this.available);
    }

}
