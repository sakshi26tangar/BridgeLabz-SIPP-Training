import java.util.*;

public class FrequencyCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter words (space-separated):");
        List<String> words = Arrays.asList(sc.nextLine().split(" "));

        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        System.out.println("Frequencies: " + freqMap);
    }
}
