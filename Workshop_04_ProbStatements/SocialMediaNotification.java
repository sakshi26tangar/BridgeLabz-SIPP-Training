
import java.util.LinkedList;

public class SocialMediaNotification {
    
    private abstract static class Notification {
        final String text;
        final String time;

        Notification(String text, String time) {
            this.text = text;
            this.time = time;
        }
        
        abstract void show();
    }

    private static class LikeNotification extends Notification {
        LikeNotification(String user, String time) {
            super(user + " liked your post", time);
        }
        @Override void show() {
            System.out.println("👍 " + text + " at " + time);
        }
    }

    private static class CommentNotification extends Notification {
        CommentNotification(String user, String comment, String time) {
            super(user + " commented: " + comment, time);
        }
        @Override void show() {
            System.out.println("💬 " + text + " at " + time);
        }
    }
   
    private final LinkedList<Notification> feed = new LinkedList<>();

   
    public void addLike(String user, String time) {
        feed.addFirst(new LikeNotification(user, time));   // O(1) insert at front
    }
    public void addComment(String user, String comment, String time) {
        feed.addFirst(new CommentNotification(user, comment, time));
    }

    
    public void displayFeed() {
        for (Notification n : feed) n.show();
    }
   
    public static void main(String[] args) {
        SocialMediaNotification myFeed = new SocialMediaNotification();

        myFeed.addLike("Alice", "09:00 AM");
        myFeed.addComment("Bob", "Nice photo!", "09:01 AM");
        myFeed.addLike("Charlie", "09:02 AM");

        System.out.println("=== Recent Notifications ===");
        myFeed.displayFeed();
    }
}