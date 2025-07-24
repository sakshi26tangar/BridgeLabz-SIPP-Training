public abstract class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public abstract String getFormat();

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
