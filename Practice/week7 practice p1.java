public class PiggyBank {
    private final String id;
    private double savings;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.savings += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= this.savings) {
            this.savings -= amount;
        }
    }

    public double getSavings() {
        return this.savings;
    }

    public String getId() {
        return this.id;
    }
}