public class EBook extends Book {
    public EBook(String title, String author) {
        super(title, author);
    }

    @Override
    public String getFormat() {
        return "E-Book";
    }
}
