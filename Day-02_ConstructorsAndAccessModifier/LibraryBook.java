public class LibraryBook {
    String title;
    String author;
    double price;
    boolean available;

    public LibraryBook(String title, String author, double price, boolean available) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = available;
    }

    public void borrowBook() {
        if (available) {
            System.out.println("Book borrowed: " + title);
            available = false;
        } else {
            System.out.println("Book not available");
        }
    }

    public void display() {
        System.out.println("Title: " + title + ", Author: " + author +
                ", Price: " + price + ", Available: " + available);
    }

    public static void main(String[] args) {
        LibraryBook lb = new LibraryBook("Effective Java", "Joshua Bloch", 499.0, true);
        lb.display();
        lb.borrowBook();
        lb.display();
    }
}

