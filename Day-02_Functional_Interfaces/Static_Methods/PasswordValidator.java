package Static_Methods;

interface SecurityUtils {
    static boolean isStrongPassword(String password) {
        // Rule: At least 8 chars, contains upper, lower, digit, and special char
        return password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&
               password.matches(".*[a-z].*") &&
               password.matches(".*[0-9].*") &&
               password.matches(".*[@#$%^&+=!].*");
    }
}

public class PasswordValidator {
    public static void main(String[] args) {
        String pwd1 = "Weak123";
        String pwd2 = "Strong@123";

        System.out.println("Password: " + pwd1 + " | Strong? " + SecurityUtils.isStrongPassword(pwd1));
        System.out.println("Password: " + pwd2 + " | Strong? " + SecurityUtils.isStrongPassword(pwd2));
    }
}

