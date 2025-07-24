public class HardCopyBook extends Book {
    public HardCopyBook(String title, String author) {
        super(title, author);
    }

    @Override
    public String getFormat() {
        return "Hardcopy Book";
    }
}
