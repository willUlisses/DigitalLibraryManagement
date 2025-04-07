public class Book {

    private final String TITLE;
    private final String AUTHOR;
    private boolean available;

    public Book(String title, String author) {
        this.TITLE = title;
        this.AUTHOR = author;
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


    protected void bookDetails() {
        System.out.println("\nTitle: " + getTitle() + "\n" +
                "Author: " + getAuthor() + "\n" +
                "Availability: " + isAvailable());
    }
}
