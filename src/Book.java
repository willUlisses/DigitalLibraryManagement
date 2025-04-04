public class Book {

    private String title;
    private String author;
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

    public String isAvailable() {
        if (available) {
            return "The Book is available";
        } else
            return "The Book isn't available";
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


    protected void bookDetails() {
        System.out.println("\nTitle: " + getTitle() + "\n" +
                "Author: " + getAuthor() + "\n" +
                "Availability: " + isAvailable());
    }
}
