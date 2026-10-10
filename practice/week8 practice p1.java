import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Payment {
    double calculateFinalAmount();
    String getType();
}

class CardPayment implements Payment {
    private double amount;
    public CardPayment(double amount) { this.amount = amount; }
    public double calculateFinalAmount() { return amount + (amount * 0.02); }
    public String getType() { return "CARD"; }
}

class WalletPayment implements Payment {
    private double amount;
    public WalletPayment(double amount) { this.amount = amount; }
    public double calculateFinalAmount() { return amount + (amount * 0.01); }
    public String getType() { return "WALLET"; }
}

class BankTransferPayment implements Payment {
    private double amount;
    public BankTransferPayment(double amount) { this.amount = amount; }
    public double calculateFinalAmount() { return amount; }
    public String getType() { return "BANKTRANSFER"; }
}

public class PaymentSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Payment> transactions = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();
            if (type.equals("CARD")) transactions.add(new CardPayment(amount));
            else if (type.equals("WALLET")) transactions.add(new WalletPayment(amount));
            else if (type.equals("BANKTRANSFER")) transactions.add(new BankTransferPayment(amount));
        }

        double total = 0;
        for (Payment p : transactions) {
            double finalAmount = p.calculateFinalAmount();
            System.out.printf("%s: %.2f\n", p.getType(), finalAmount);
            total += finalAmount;
        }
        System.out.printf("Total: %.2f\n", total);
    }
}