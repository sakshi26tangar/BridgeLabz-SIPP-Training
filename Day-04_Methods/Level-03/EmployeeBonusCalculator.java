public class EmployeeBonusCalculator {
    public static void main(String[] args) {
        int[][] salaryData = new int[10][2];
        double[][] resultData = new double[10][2];
        double totalOld = 0, totalBonus = 0, totalNew = 0;
        for (int i = 0; i < 10; i++) {
            int salary = 10000 + (int)(Math.random() * 90000);
            int service = 1 + (int)(Math.random() * 10);
            salaryData[i][0] = salary;
            salaryData[i][1] = service;
            double bonus = service > 5 ? 0.05 * salary : 0.02 * salary;
            double newSalary = salary + bonus;
            resultData[i][0] = newSalary;
            resultData[i][1] = bonus;
            totalOld += salary;
            totalBonus += bonus;
            totalNew += newSalary;
        }
        System.out.println("Emp\tOld\tService\tBonus\tNew");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d\t%d\t%d\t%.2f\t%.2f%n", i + 1, salaryData[i][0], salaryData[i][1], resultData[i][1], resultData[i][0]);
        }
        System.out.printf("Total Old: %.2f, Bonus: %.2f, New: %.2f%n", totalOld, totalBonus, totalNew);
    }
}
