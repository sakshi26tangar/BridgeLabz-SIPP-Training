import java.util.*;

public class ShowScheduler {
    private final List<Show> shows;

    public ShowScheduler() {
        shows = new ArrayList<>(List.of(
            new Show("KGF", "09:45"),
            new Show("Raid 2", "12:30"),
            new Show("Housefull 4", "15:15"),
            new Show("Avengers", "18:45"),
            new Show("Anabela", "21:00")
        ));
    }

    public void insertShow(Show newShow) {
        int i = 0;
        while (i < shows.size() && newShow.minutes() > shows.get(i).minutes()) {
            i++;
        }
        shows.add(i, newShow);
    }

    public void printSchedule() {
        System.out.println("\n--- TODAY'S SHOWTIMES ---");
        for (Show show : shows) {
            System.out.println(show);
        }
    }
}
