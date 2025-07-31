import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        String sourcePath = "source.txt";
        String destinationPath = "destination.txt";

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            File sourceFile = new File(sourcePath);
            if (!sourceFile.exists()) {
                System.out.println("Source file does not exist.");
                return;
            }

            fis = new FileInputStream(sourceFile);
            fos = new FileOutputStream(destinationPath);

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }

            System.out.println("File copied successfully to " + destinationPath);

        } catch (IOException e) {
            System.out.println("An error occurred during file handling: " + e.getMessage());
        } finally {
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.out.println("Error closing streams: " + e.getMessage());
            }
        }
    }
}
