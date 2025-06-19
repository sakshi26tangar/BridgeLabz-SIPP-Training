public class StudentMarksPercentage {
    public static void main(String[] args) {
        int students = 5;
        int[][] marks = new int[students][3];
        double[][] results = new double[students][3];
        for (int i = 0; i < students; i++) {
            for (int j = 0; j < 3; j++) marks[i][j] = 40 + (int)(Math.random() * 61);
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double avg = total / 3.0;
            double perc = (total / 300.0) * 100;
            results[i][0] = total;
            results[i][1] = avg;
            results[i][2] = perc;
        }
        System.out.println("Stu\tP\tC\tM\tTotal\tAvg\t% ");
        for (int i = 0; i < students; i++) {
            System.out.printf("%d\t%d\t%d\t%d\t%.0f\t%.2f\t%.2f%n", i + 1, marks[i][0], marks[i][1], marks[i][2], results[i][0], results[i][1], results[i][2]);
        }
    }
}
