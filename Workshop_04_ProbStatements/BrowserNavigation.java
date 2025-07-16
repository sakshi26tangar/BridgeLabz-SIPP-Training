import java.util.Scanner;
import java.util.Stack;

interface NavigationManager {
    void openPage(String url);
    void goBack();
    void goForward();
    void showCurrentPage();
}

class DesktopBrowser implements NavigationManager {
    private Stack<String> backStack = new Stack<>();
    private Stack<String> forwardStack = new Stack<>();
    private String currentPage = "Home";

    @Override
    public void openPage(String url) {
        backStack.push(currentPage);
        currentPage = url;
        forwardStack.clear();
        System.out.println("Opened: " + currentPage);
    }

    @Override
    public void goBack() {
        if (!backStack.isEmpty()) {
            forwardStack.push(currentPage);
            currentPage = backStack.pop();
            System.out.println("Went back to: " + currentPage);
        } else {
            System.out.println("No page to go back to.");
        }
    }

    @Override
    public void goForward() {
        if (!forwardStack.isEmpty()) {
            backStack.push(currentPage);
            currentPage = forwardStack.pop();
            System.out.println("Went forward to: " + currentPage);
        } else {
            System.out.println("No page to go forward to.");
        }
    }

    @Override
    public void showCurrentPage() {
        System.out.println("Current Page: " + currentPage);
    }
}
// Main driver class
public class BrowserNavigation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NavigationManager browser = new DesktopBrowser();

        while (true) {
            System.out.println("\n1. Open Page");
            System.out.println("2. Go Back");
            System.out.println("3. Go Forward");
            System.out.println("4. Show Current Page");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter URL to open: ");
                    String url = sc.nextLine();
                    browser.openPage(url);
                    break;
                case 2:
                    browser.goBack();
                    break;
                case 3:
                    browser.goForward();
                    break;
                case 4:
                    browser.showCurrentPage();
                    break;
                case 5:
                    System.out.println("Exiting browser...");
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
