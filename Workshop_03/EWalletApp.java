import java.util.*;

public class EWalletApp {

    interface Wallet {
        void loadMoney(double amount);
        void transferTo(User to, double amount);
        void receive(double amount, String note);
        void showHistory();
    }

    static class PersonalWallet implements Wallet {
        private double balance;
        private final List<String> history = new ArrayList<>();

        PersonalWallet(double balance) {
            this.balance = balance;
            history.add("Wallet opened with " + balance);
        }

        public void loadMoney(double amount) {
            balance += amount;
            history.add("Loaded " + amount);
        }

        public void transferTo(User to, double amount) {
            if (amount <= balance) {
                balance -= amount;
                history.add("Transferred " + amount + " to " + to.name);
                to.wallet.receive(amount, "from " + to.name);
            } else {
                history.add("Failed transfer of " + amount + " to " + to.name + " (insufficient funds)");
            }
        }

        public void receive(double amount, String note) {
            balance += amount;
            history.add("Received " + amount + " " + note);
        }

        public void showHistory() {
            history.forEach(System.out::println);
            System.out.println("Current balance: " + balance);
        }
    }

    static class BusinessWallet extends PersonalWallet {
        BusinessWallet(double balance) { super(balance); }
    }

    static class User {
        String name;
        Wallet wallet;
        User(String name, Wallet wallet) { this.name = name; this.wallet = wallet; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        User[] users = new User[2];
        for (int i = 0; i < 2; i++) {
            System.out.print("Enter name for user " + (i + 1) + ": ");
            String name = sc.nextLine().trim();
            System.out.print("Wallet type (1‑Personal / 2‑Business): ");
            int type = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Initial balance: ");
            double bal = Double.parseDouble(sc.nextLine().trim());
            users[i] = new User(name, type == 2 ? new BusinessWallet(bal) : new PersonalWallet(bal));
            System.out.println();
        }

        for (User u : users) {
            System.out.print("Amount to load into " + u.name + "'s wallet: ");
            double amt = Double.parseDouble(sc.nextLine().trim());
            u.wallet.loadMoney(amt);
        }
        System.out.println();

        System.out.print("Transfer amount (user1 ➜ user2): ");
        double amt = Double.parseDouble(sc.nextLine().trim());
        users[0].wallet.transferTo(users[1], amt);
        System.out.println();

        System.out.println(users[0].name + "'s Transactions:");
        users[0].wallet.showHistory();
        System.out.println("\n" + users[1].name + "'s Transactions:");
        users[1].wallet.showHistory();

        sc.close();
    }
}
