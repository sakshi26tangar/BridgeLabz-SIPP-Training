public class AudioBook extends Book {
    public AudioBook(String title, String author) {
        super(title, author);
    }

    @Override
    public String getFormat() {
        return "Audio Book";
    }
}
