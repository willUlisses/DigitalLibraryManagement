public class DigitalBook extends Book{

    private String urlDownload;
    public DigitalBook(String title, String author, String urlDownload) {
        super(title, author);
        this.urlDownload = urlDownload;
    }


}
