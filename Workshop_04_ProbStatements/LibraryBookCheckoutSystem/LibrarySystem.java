import java.util.Scanner;

public class LibrarySystem {
    public static void main(String[] args) {
        RequestQueue queue = new RequestQueue();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of book requests: ");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            System.out.println("\nRequest #" + i);
            System.out.print("Enter user name: ");
            String user = scanner.nextLine();

            System.out.print("Enter book title: ");
            String title = scanner.nextLine();

            System.out.print("Enter book author: ");
            String author = scanner.nextLine();

            System.out.print("Enter book type (ebook/hardcopy/audio): ");
            String type = scanner.nextLine().trim().toLowerCase();

            if (type.equals("ebook")) {
                EBook ebook = new EBook(title, author);
                Request<EBook> request = new Request<>(user, ebook);
                queue.addRequest(request);
            } else if (type.equals("hardcopy")) {
                HardCopyBook hardCopy = new HardCopyBook(title, author);
                Request<HardCopyBook> request = new Request<>(user, hardCopy);
                queue.addRequest(request);
            
            } else if (type.equals("audio")) {
                AudioBook audio = new AudioBook(title, author);
                Request<AudioBook> request = new Request<>(user, audio);
                queue.addRequest(request);

            }else {
                System.out.println("Invalid book type. Skipping this request.");
            }
        }

        System.out.println("\n--- Processing Book Requests ---");
        queue.processRequests();

        scanner.close();
    }
}
