class Book {
    static String libraryName = "Central Library";
    private final String isbn;
    private String title, author;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    static void displayLibraryName() {
        System.out.println("Library: " + libraryName);
    }

    public void displayDetails() {
        if (this instanceof Book) {
            System.out.println("Title: " + this.title);
            System.out.println("Author: " + this.author);
            System.out.println("ISBN: " + this.isbn);
        }
    }

    public static void main(String[] args) {
        Book b1 = new Book("Java Basics", "James Gosling", "ISBN001");
        Book b2 = new Book("Python Intro", "Guido van Rossum", "ISBN002");

        displayLibraryName();
        b1.displayDetails();
        b2.displayDetails();
    }
}
