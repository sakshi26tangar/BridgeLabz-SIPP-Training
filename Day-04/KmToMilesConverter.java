public class KmToMilesConverter {
    public static void main(String[] args) {
        double kilometers = 10.8;
        double conversionRate = 1.6;
        double miles = kilometers * conversionRate;

        System.out.println("The distance " + kilometers + " km in miles is " + miles);
    }
}
