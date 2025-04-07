public class PhysicalBook extends Book{

    private String shelf;
    public PhysicalBook(String title, String author, String shelf) {
        super(title, author);
        this.shelf = shelf;
    }

}
