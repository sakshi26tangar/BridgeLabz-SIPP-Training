import java.util.Scanner;

class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie prev, next;

    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.prev = null;
        this.next = null;
    }
}

public class MovieManagementSystem {
    private Movie head = null;
    private Movie tail = null;

    // Add at beginning
    public void addAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    // Add at end
    public void addAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    // Add at specific position (0-based index)
    public void addAtPosition(int position, String title, String director, int year, double rating) {
        if (position == 0) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        Movie newMovie = new Movie(title, director, year, rating);
        Movie temp = head;

        for (int i = 0; i < position - 1 && temp != null; i++)
            temp = temp.next;

        if (temp == null || temp.next == null) {
            addAtEnd(title, director, year, rating);
            return;
        }

        newMovie.next = temp.next;
        newMovie.prev = temp;
        temp.next.prev = newMovie;
        temp.next = newMovie;
    }

    // Remove movie by title
    public void removeByTitle(String title) {
        Movie temp = head;
        while (temp != null && !temp.title.equalsIgnoreCase(title))
            temp = temp.next;

        if (temp == null) {
            System.out.println("Movie not found.");
            return;
        }

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
        System.out.println("Movie removed.");
    }

    // Search by director or rating
    public void search(String key) {
        Movie temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(key) || String.valueOf(temp.rating).equals(key)) {
                System.out.println("Title: " + temp.title + ", Director: " + temp.director +
                        ", Year: " + temp.year + ", Rating: " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No matching movie found.");
    }

    // Update rating
    public void updateRating(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }

    // Display forward
    public void displayForward() {
        if (head == null) {
            System.out.println("No movies found.");
            return;
        }
        Movie temp = head;
        System.out.println("Movies (Forward):");
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director +
                    ", Year: " + temp.year + ", Rating: " + temp.rating);
            temp = temp.next;
        }
    }

    // Display reverse
    public void displayReverse() {
        if (tail == null) {
            System.out.println("No movies found.");
            return;
        }
        Movie temp = tail;
        System.out.println("Movies (Reverse):");
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director +
                    ", Year: " + temp.year + ", Rating: " + temp.rating);
            temp = temp.prev;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieManagementSystem mms = new MovieManagementSystem();

        while (true) {
            System.out.println("\n--- Movie Management Menu ---");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Remove by Title");
            System.out.println("5. Search by Director/Rating");
            System.out.println("6. Update Rating");
            System.out.println("7. Display Forward");
            System.out.println("8. Display Reverse");
            System.out.println("9. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            if (choice == 9) break;

            switch (choice) {
                case 1, 2, 3 -> {
                    System.out.print("Enter Title, Director, Year, Rating: ");
                    String title = sc.nextLine();
                    String director = sc.nextLine();
                    int year = sc.nextInt();
                    double rating = sc.nextDouble();
                    if (choice == 1) mms.addAtBeginning(title, director, year, rating);
                    else if (choice == 2) mms.addAtEnd(title, director, year, rating);
                    else {
                        System.out.print("Enter Position: ");
                        int pos = sc.nextInt();
                        mms.addAtPosition(pos, title, director, year, rating);
                    }
                }
                case 4 -> {
                    System.out.print("Enter Title to remove: ");
                    String title = sc.nextLine();
                    mms.removeByTitle(title);
                }
                case 5 -> {
                    System.out.print("Enter Director or Rating to search: ");
                    String key = sc.nextLine();
                    mms.search(key);
                }
                case 6 -> {
                    System.out.print("Enter Title and New Rating: ");
                    String title = sc.nextLine();
                    double rating = sc.nextDouble();
                    mms.updateRating(title, rating);
                }
                case 7 -> mms.displayForward();
                case 8 -> mms.displayReverse();
                default -> System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
