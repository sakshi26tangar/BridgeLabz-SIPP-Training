public class LibraryBookSystem {
    public String ISBN;
    protected String title;
    private String author;

    public LibraryBookSystem(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
}

class EBookLibrary extends LibraryBookSystem {
    double fileSizeMB;

    public EBookLibrary(String ISBN, String title, String author, double fileSizeMB) {
        super(ISBN, title, author);
        this.fileSizeMB = fileSizeMB;
    }

    public void displayBookInfo() {
        System.out.println("ISBN: " + ISBN + ", Title: " + title + ", Size: " + fileSizeMB + "MB");
    }

    public static void main(String[] args) {
        EBookLibrary ebook = new EBookLibrary("978-0-123456-47-2", "Java Fundamentals", "Herbert Schildt", 3.2);
        ebook.displayBookInfo();
        System.out.println("Author: " + ebook.getAuthor());
    }
}
