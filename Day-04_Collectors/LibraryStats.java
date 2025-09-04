package collectors;
import java.util.*;
import java.util.stream.*;

class Book {
    String genre;
    int pages;

    Book(String genre, int pages) {
        this.genre = genre;
        this.pages = pages;
    }
}

public class LibraryStats {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
            new Book("Fiction", 320),
            new Book("Fiction", 280),
            new Book("Science", 400),
            new Book("Science", 350),
            new Book("History", 500)
        );

        Map<String, IntSummaryStatistics> stats = books.stream()
            .collect(Collectors.groupingBy(
                b -> b.genre,
                Collectors.summarizingInt(b -> b.pages)
            ));

        stats.forEach((genre, stat) -> {
            System.out.println(genre + " -> " + stat);
        });
    }
}