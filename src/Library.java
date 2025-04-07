public class Library {

    private String name;
    private Book[]  books;
    private User[] users;
    private int bookCounter;
    private int userCounter;
    private Book book;

    public Library(String name, int capacity) {
        this.name = name;
        this.books = new Book[capacity];
        this.bookCounter = 0;
    }

    public void addBook(Book book) {
        if (bookCounter < books.length) {
            books[bookCounter] = book;
            bookCounter++;
            System.out.println("The book " + book.getTitle() + " was added to the library.");
        } else
            System.out.println("The library max has been reached, you can't add more books.");
    }

    public void showBooks() {
        System.out.println("\nBooks list:");
        for (Book actualBook : books) {
            if (actualBook != null) {
                System.out.println("Title: " + actualBook.getTitle());
            }
        }
    }

    public void showUnavailableBooks(Library library) {
        System.out.println("Unavailable books from " + library + ": ");
        if (book.getAvailable()) {
            for (Book unavailableBook : books) {
                System.out.println(unavailableBook);
            }
        }
    }

    public void addUser(User user) {
        if (userCounter < users.length) {
            users[userCounter] = user;
            userCounter++;
            System.out.println("User " + user.getName() + " successfully added.");
        } else
            System.out.println("You can't add more users");
    }

    public void showUsers() {
        System.out.println("Users list: ");
        for (User actualUser : users) {
            System.out.println("NAME: " + actualUser.getName() + " ID: " + actualUser.getUserId());
        }
    }

    public void setBookUnavailable(Book book) {
        book.setAvailable(false);
    }

    public void setBookAvailable(Book book) {
        book.setAvailable(true);
    }

}
