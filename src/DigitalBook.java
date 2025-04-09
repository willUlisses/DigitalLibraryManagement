public class DigitalBook extends Book{

    private final String urlDownload;
    public DigitalBook(String title, String author, String urlDownload) {
        super(title, author);
        this.urlDownload = urlDownload;
    }

    public String getUrlDownload() {
        return urlDownload;
    }

    @Override
    protected void bookDetails() {
        System.out.println("\n Title: " + getTitle() + "\n" +
                "Author: " + getAuthor() + "\n" +
                "Availability: " + isAvailable() + "\n" +
                "DownloadLink: " + getUrlDownload());
    }
}
