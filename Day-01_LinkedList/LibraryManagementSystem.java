import java.util.Scanner;

class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    Book prev, next;

    public Book(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.prev = null;
        this.next = null;
    }
}

public class LibraryManagementSystem {
    private Book head = null;
    private Book tail = null;

    public void addAtBeginning(String title, String author, String genre, int id, boolean status) {
        Book newBook = new Book(title, author, genre, id, status);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    public void addAtEnd(String title, String author, String genre, int id, boolean status) {
        Book newBook = new Book(title, author, genre, id, status);
        if (head == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    public void addAtPosition(int pos, String title, String author, String genre, int id, boolean status) {
        if (pos == 0) {
            addAtBeginning(title, author, genre, id, status);
            return;
        }
        Book newBook = new Book(title, author, genre, id, status);
        Book temp = head;
        for (int i = 0; i < pos - 1 && temp != null; i++)
            temp = temp.next;
        if (temp == null || temp.next == null) {
            addAtEnd(title, author, genre, id, status);
            return;
        }
        newBook.next = temp.next;
        newBook.prev = temp;
        temp.next.prev = newBook;
        temp.next = newBook;
    }

    public void removeById(int id) {
        if (head == null) return;
        Book temp = head;
        while (temp != null && temp.bookId != id)
            temp = temp.next;
        if (temp == null) return;
        if (temp == head) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
        } else if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }

    public void searchByTitleOrAuthor(String key) {
        Book temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(key) || temp.author.equalsIgnoreCase(key)) {
                System.out.println("Book: " + temp.title + ", Author: " + temp.author +
                        ", Genre: " + temp.genre + ", ID: " + temp.bookId +
                        ", Available: " + temp.isAvailable);
            }
            temp = temp.next;
        }
    }

    public void updateAvailability(int id, boolean status) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == id) {
                temp.isAvailable = status;
                return;
            }
            temp = temp.next;
        }
    }

    public void displayForward() {
        Book temp = head;
        while (temp != null) {
            System.out.println("Book: " + temp.title + ", Author: " + temp.author +
                    ", Genre: " + temp.genre + ", ID: " + temp.bookId +
                    ", Available: " + temp.isAvailable);
            temp = temp.next;
        }
    }

    public void displayReverse() {
        Book temp = tail;
        while (temp != null) {
            System.out.println("Book: " + temp.title + ", Author: " + temp.author +
                    ", Genre: " + temp.genre + ", ID: " + temp.bookId +
                    ", Available: " + temp.isAvailable);
            temp = temp.prev;
        }
    }

    public void countBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Total number of books: " + count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryManagementSystem lib = new LibraryManagementSystem();

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Remove by ID");
            System.out.println("5. Search by Title/Author");
            System.out.println("6. Update Availability");
            System.out.println("7. Display Forward");
            System.out.println("8. Display Reverse");
            System.out.println("9. Count Books");
            System.out.println("10. Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();

            if (ch == 10) break;

            switch (ch) {
                case 1, 2, 3 -> {
                    System.out.print("Enter Title, Author, Genre, ID, Availability (true/false): ");
                    String title = sc.next();
                    String author = sc.next();
                    String genre = sc.next();
                    int id = sc.nextInt();
                    boolean avail = sc.nextBoolean();
                    if (ch == 1) lib.addAtBeginning(title, author, genre, id, avail);
                    else if (ch == 2) lib.addAtEnd(title, author, genre, id, avail);
                    else {
                        System.out.print("Position: ");
                        int pos = sc.nextInt();
                        lib.addAtPosition(pos, title, author, genre, id, avail);
                    }
                }
                case 4 -> {
                    System.out.print("Enter Book ID to remove: ");
                    lib.removeById(sc.nextInt());
                }
                case 5 -> {
                    System.out.print("Enter Title or Author: ");
                    lib.searchByTitleOrAuthor(sc.next());
                }
                case 6 -> {
                    System.out.print("Enter Book ID and new availability (true/false): ");
                    lib.updateAvailability(sc.nextInt(), sc.nextBoolean());
                }
                case 7 -> lib.displayForward();
                case 8 -> lib.displayReverse();
                case 9 -> lib.countBooks();
                default -> System.out.println("Invalid");
            }
        }

        sc.close();
    }
}
