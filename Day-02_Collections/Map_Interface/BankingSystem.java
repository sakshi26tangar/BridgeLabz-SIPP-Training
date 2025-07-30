import java.util.*;

class WithdrawalRequest {
    int accountNumber;
    double amount;

    public WithdrawalRequest(int accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }
}

public class BankingSystem {
    private HashMap<Integer, Double> accounts = new HashMap<>();
    private Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>();

    // Add account
    public void addAccount(int accountNumber, double balance) {
        accounts.put(accountNumber, balance);
    }

    // Add withdrawal request
    public void requestWithdrawal(int accountNumber, double amount) {
        withdrawalQueue.offer(new WithdrawalRequest(accountNumber, amount));
    }

    // Process withdrawal requests
    public void processWithdrawals() {
        System.out.println("\n🔁 Processing Withdrawals:");
        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest req = withdrawalQueue.poll();
            if (!accounts.containsKey(req.accountNumber)) {
                System.out.println("❌ Account " + req.accountNumber + " not found.");
                continue;
            }
            double currentBalance = accounts.get(req.accountNumber);
            if (currentBalance >= req.amount) {
                accounts.put(req.accountNumber, currentBalance - req.amount);
                System.out.println("✅ Withdrawn ₹" + req.amount + " from Account " + req.accountNumber);
            } else {
                System.out.println("⚠️ Insufficient balance in Account " + req.accountNumber);
            }
        }
    }

    // Display accounts sorted by balance
    public void displaySortedByBalance() {
        System.out.println("\n📊 Accounts Sorted by Balance:");

        TreeMap<Double, List<Integer>> sortedAccounts = new TreeMap<>();

        for (Map.Entry<Integer, Double> entry : accounts.entrySet()) {
            int acc = entry.getKey();
            double bal = entry.getValue();
            sortedAccounts.putIfAbsent(bal, new ArrayList<>());
            sortedAccounts.get(bal).add(acc);
        }

        for (Map.Entry<Double, List<Integer>> entry : sortedAccounts.entrySet()) {
            double bal = entry.getKey();
            for (int acc : entry.getValue()) {
                System.out.println("Account " + acc + " → ₹" + bal);
            }
        }
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        // Add customer accounts
        bank.addAccount(1001, 5000);
        bank.addAccount(1002, 2000);
        bank.addAccount(1003, 8000);
        bank.addAccount(1004, 2000);

        // Add withdrawal requests
        bank.requestWithdrawal(1001, 1000);
        bank.requestWithdrawal(1002, 2500); // should show insufficient
        bank.requestWithdrawal(1003, 500);
        bank.requestWithdrawal(1005, 100); // account not found

        // Process all withdrawals
        bank.processWithdrawals();

        // Display all accounts sorted by balance
        bank.displaySortedByBalance();
    }
}
