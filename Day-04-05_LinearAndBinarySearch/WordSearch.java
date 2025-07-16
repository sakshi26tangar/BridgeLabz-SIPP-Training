import java.util.Scanner;

public class WordSearch {

    // Linear Search: Search for the word in each sentence
    public static String linearSearchSentence(String[] sentences, String word) {
        for (int i = 0; i < sentences.length; i++) {
            if (sentences[i].contains(word)) {
                return sentences[i]; // Return the first sentence that contains the word
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] sentences = {
            "The sky is blue.",
            "I love programming.",
            "Java is a powerful language.",
            "Always be kind."
        };

        System.out.print("Enter the word to search: ");
        String word = scanner.nextLine();

        // Perform linear search
        String result = linearSearchSentence(sentences, word);

        System.out.println("Result: " + result);

        scanner.close();
    }
}
