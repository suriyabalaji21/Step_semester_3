import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Customer {
    double calculateFinalAmount();
    String getType();
}

class StudentCustomer implements Customer {
    private double amount;
    public StudentCustomer(double amount) { this.amount = amount; }
    public double calculateFinalAmount() { return amount * 0.90; }
    public String getType() { return "STUDENT"; }
}

class StaffCustomer implements Customer {
    private double amount;
    public StaffCustomer(double amount) { this.amount = amount; }
    public double calculateFinalAmount() { return amount * 0.95; }
    public String getType() { return "STAFF"; }
}

class GuestCustomer implements Customer {
    private double amount;
    public GuestCustomer(double amount) { this.amount = amount; }
    public double calculateFinalAmount() { return amount + 10.0; }
    public String getType() { return "GUEST"; }
}

public class CanteenBilling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Customer> bills = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();
            
            if (type.equals("STUDENT")) bills.add(new StudentCustomer(amount));
            else if (type.equals("STAFF")) bills.add(new StaffCustomer(amount));
            else if (type.equals("GUEST")) bills.add(new GuestCustomer(amount));
        }

        double total = 0;
        for (Customer c : bills) {
            double finalAmount = c.calculateFinalAmount();
            System.out.printf("%s: %.2f\n", c.getType(), finalAmount);
            total += finalAmount;
        }
        System.out.printf("Total: %.2f\n", total);
    }
}