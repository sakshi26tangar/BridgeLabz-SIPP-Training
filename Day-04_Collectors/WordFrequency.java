package collectors;
import java.util.*;
import java.util.stream.*;

public class WordFrequency {
    public static void main(String[] args) {
        String paragraph = "Java is powerful and Java is versatile and Java is popular";
        String[] words = paragraph.split(" ");

        Map<String, Long> frequency = Arrays.stream(words)
            .collect(Collectors.toMap(
                w -> w,
                w -> 1L,
                Long::sum
            ));

        frequency.forEach((word, count) -> 
            System.out.println(word + " -> " + count));
    }
}