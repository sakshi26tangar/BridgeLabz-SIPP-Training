import java.time.LocalDate;

public class DateArithmetic {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2022, 6, 20); // Sample input date
        LocalDate result = date.plusDays(7).plusMonths(1).plusYears(2).minusWeeks(3);

        System.out.println("Original Date: " + date);
        System.out.println("Modified Date: " + result);
    }
}