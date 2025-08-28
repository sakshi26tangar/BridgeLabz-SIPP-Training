package Marker_Interface;

import java.io.*;

// Marked as Serializable for backup
class UserData implements Serializable {
    private String username;
    private String email;

    public UserData(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String toString() {
        return "UserData{username='" + username + "', email='" + email + "'}";
    }
}

public class BackupSystem {
    public static void main(String[] args) {
        UserData user = new UserData("Arjun", "arjun@example.com");

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("backup.ser"))) {
            out.writeObject(user);
            System.out.println("✅ User data serialized for backup.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
