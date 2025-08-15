import java.util.*;
import java.util.function.Predicate;

class Alert {
    String type;
    String message;

    Alert(String type, String message) {
        this.type = type;
        this.message = message;
    }

    @Override
    public String toString() {
        return "[" + type + "] " + message;
    }
}

public class NotificationFiltering {
    public static void main(String[] args) {
        List<Alert> alerts = Arrays.asList(
            new Alert("CRITICAL", "Patient heart rate abnormal"),
            new Alert("INFO", "Routine check-up scheduled"),
            new Alert("WARNING", "Low blood pressure detected")
        );

        Predicate<Alert> criticalOnly = alert -> alert.type.equals("CRITICAL");
        Predicate<Alert> warningsAndCritical = alert -> 
            alert.type.equals("CRITICAL") || alert.type.equals("WARNING");

        System.out.println("Critical Alerts: ");
        alerts.stream().filter(criticalOnly).forEach(System.out::println);

        System.out.println("\nWarnings and Critical Alerts: ");
        alerts.stream().filter(warningsAndCritical).forEach(System.out::println);
    }
}
