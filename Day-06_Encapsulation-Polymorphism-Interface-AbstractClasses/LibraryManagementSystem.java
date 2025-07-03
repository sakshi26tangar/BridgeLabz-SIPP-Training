import java.util.*;

interface Reservable {
    void reserveItem(String userId);
    boolean checkAvailability();
}

abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    private boolean isAvailable = true;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public abstract int getLoanDuration();

    public void getItemDetails() {
        System.out.println("Item ID   : " + itemId);
        System.out.println("Title     : " + title);
        System.out.println("Author    : " + author);
        System.out.println("Available : " + (isAvailable ? "Yes" : "No"));
        System.out.println("Loan Days : " + getLoanDuration());
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean status) {
        this.isAvailable = status;
    }

    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}

class Book extends LibraryItem implements Reservable {
    private String reservedBy;

    public Book(String id, String title, String author) {
        super(id, title, author);
    }

    public int getLoanDuration() {
        return 14;
    }

    public void reserveItem(String userId) {
        if (checkAvailability()) {
            reservedBy = userId;
            setAvailable(false);
            System.out.println("Book reserved by " + userId);
        } else {
            System.out.println("Book not available.");
        }
    }

    public boolean checkAvailability() {
        return isAvailable();
    }
}

class Magazine extends LibraryItem implements Reservable {
    private String reservedBy;

    public Magazine(String id, String title, String author) {
        super(id, title, author);
    }

    public int getLoanDuration() {
        return 7;
    }

    public void reserveItem(String userId) {
        if (checkAvailability()) {
            reservedBy = userId;
            setAvailable(false);
            System.out.println("Magazine reserved by " + userId);
        } else {
            System.out.println("Magazine not available.");
        }
    }

    public boolean checkAvailability() {
        return isAvailable();
    }
}

class DVD extends LibraryItem implements Reservable {
    private String reservedBy;

    public DVD(String id, String title, String author) {
        super(id, title, author);
    }

    public int getLoanDuration() {
        return 3;
    }

    public void reserveItem(String userId) {
        if (checkAvailability()) {
            reservedBy = userId;
            setAvailable(false);
            System.out.println("DVD reserved by " + userId);
        } else {
            System.out.println("DVD not available.");
        }
    }

    public boolean checkAvailability() {
        return isAvailable();
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();

        items.add(new Book("B101", "Java Programming", "James Gosling"));
        items.add(new Magazine("M202", "Tech Monthly", "Editor A"));
        items.add(new DVD("D303", "Inception", "Christopher Nolan"));

        System.out.println("=== Library Items ===");
        for (LibraryItem item : items) {
            System.out.println("\n---------------------");
            item.getItemDetails();

            if (item instanceof Reservable) {
                ((Reservable) item).reserveItem("User001");
            }

            System.out.println("Availability after reservation: " + (item.isAvailable() ? "Yes" : "No"));
        }
    }
}
