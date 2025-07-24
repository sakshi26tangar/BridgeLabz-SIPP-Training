import java.util.LinkedList;
import java.util.Queue;

public class RequestQueue {
    private Queue<Request<? extends Book>> queue;

    public RequestQueue() {
        queue = new LinkedList<>();
    }

    public void addRequest(Request<? extends Book> request) {
        queue.offer(request);
    }

    public void processRequests() {
        while (!queue.isEmpty()) {
            Request<? extends Book> request = queue.poll();
            Book book = request.getBook();
            System.out.println("Processing request for user: " + request.getUser());
            System.out.println("Book: " + book.getTitle() + " by " + book.getAuthor());
            System.out.println("Format: " + book.getFormat());
            System.out.println("------------------------------");
        }
    }
}
