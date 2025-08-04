import java.io.*;

public class ImageByteArrayConversion {
    public static void main(String[] args) {
        File originalFile = new File("original.jpg");
        File outputFile = new File("copied.jpg");

        try (FileInputStream fis = new FileInputStream(originalFile);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            byte[] imageBytes = baos.toByteArray();

            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
            try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                while ((bytesRead = bais.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
            }

            System.out.println("Image successfully copied using byte array.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
