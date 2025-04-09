public class PhysicalBook extends Book{

    private String shelf;
    public PhysicalBook(String title, String author, String shelf) {
        super(title, author);
        this.shelf = shelf;
    }

    public String getShelf() {
        return shelf;
    }

    @Override
    protected void bookDetails() {
        System.out.println("\n Title: " + getTitle() + "\n" +
                "Author: " + getAuthor() + "\n" +
                "Availability: " + isAvailable() + "\n" +
                "Shelf: " + getShelf());
    }
}
