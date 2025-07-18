public class Show {
    String title;
    String time;

    public Show(String title, String time) {
        this.title = title;
        this.time = time;
    }

    public int minutes() {
        String[] p = time.split(":");
        return Integer.parseInt(p[0]) * 60 + Integer.parseInt(p[1]);
    }

    @Override
    public String toString() {
        return time + " – " + title;
    }
}
