import java.util.Scanner;
public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShowScheduler scheduler = new ShowScheduler();

        scheduler.printSchedule();

        System.out.print("\nHow many new movies do you want to add? ");
        int count = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < count; i++) {
            System.out.println("\nEnter details for Movie " + (i + 1) + ":");
            System.out.print("Title       : ");
            String title = sc.nextLine();
            System.out.print("Start time (HH:mm): ");
            String time = sc.nextLine();

            scheduler.insertShow(new Show(title, time));
        }

        scheduler.printSchedule();
        sc.close();
    }
}
