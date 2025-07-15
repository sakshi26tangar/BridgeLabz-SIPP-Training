public class PersonalWallet extends Wallet {
    private static final double LIMIT = 10000;

    public PersonalWallet(double bonus) {
        super(bonus);
    }

    @Override
    public void transferTo(User receiver, double amount) {
        if (amount <= getBalance() && amount <= LIMIT) {
            deduct(amount);
            receiver.wallet.credit(amount);
            history.add(new Transaction("Transferred to " + receiver.name, amount));
        } else {
            System.out.println("Transfer failed: Limit or balance exceeded.");
        }
    }
}
