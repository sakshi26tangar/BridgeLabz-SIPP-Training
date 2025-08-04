import java.io.*;

public class FilterStreamLowercase {
    public static void main(String[] args) {
        File inputFile = new File("input.txt");
        File outputFile = new File("output.txt");

        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))
        ) {
            int character;
            while ((character = reader.read()) != -1) {
                writer.write(Character.toLowerCase(character));
            }
            System.out.println("Conversion completed. Check output.txt.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

