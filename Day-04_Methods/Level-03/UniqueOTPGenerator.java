public class UniqueOTPGenerator {
    public static void main(String[] args) {
        int[] otps = new int[10];
        for (int i = 0; i < 10; i++) {
            otps[i] = generateOTP();
        }
        boolean unique = true;
        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) {
                    unique = false;
                    break;
                }
            }
        }
        for (int o : otps) System.out.println(o);
        System.out.println("All OTPs Unique? " + unique);
    }

    static int generateOTP() {
        return 100000 + (int)(Math.random() * 900000);
    }
}
