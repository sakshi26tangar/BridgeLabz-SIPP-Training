public class Request<T extends Book> {
    private T book;
    private String user;

    public Request(String user, T book) {
        this.user = user;
        this.book = book;
    }

    public T getBook() {
        return book;
    }

    public String getUser() {
        return user;
    }
}
