package Static_Methods;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

interface DateUtils {
    static String formatDate(LocalDate date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }
}

public class InvoiceDateFormatter {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();

        System.out.println("Default format: " + DateUtils.formatDate(today, "dd/MM/yyyy"));
        System.out.println("US format: " + DateUtils.formatDate(today, "MM-dd-yyyy"));
        System.out.println("Full format: " + DateUtils.formatDate(today, "EEEE, MMM dd, yyyy"));
    }
}
