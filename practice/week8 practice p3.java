import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Delivery {
    double calculateFee();
    String getType();
}

class StandardDelivery implements Delivery {
    private double weight, distance;
    public StandardDelivery(double weight, double distance) { this.weight = weight; this.distance = distance; }
    public double calculateFee() { return 5.0 + (0.50 * weight) + (0.10 * distance); }
    public String getType() { return "STANDARD"; }
}

class ExpressDelivery implements Delivery {
    private double weight, distance;
    public ExpressDelivery(double weight, double distance) { this.weight = weight; this.distance = distance; }
    public double calculateFee() { return 15.0 + (1.00 * weight) + (0.20 * distance); }
    public String getType() { return "EXPRESS"; }
}

class InternationalDelivery implements Delivery {
    private double weight, distance, customsFee;
    public InternationalDelivery(double weight, double distance, double customsFee) {
        this.weight = weight; this.distance = distance; this.customsFee = customsFee;
    }
    public double calculateFee() { return 25.0 + (2.00 * weight) + (0.50 * distance) + customsFee; }
    public String getType() { return "INTERNATIONAL"; }
}

public class DeliverySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Delivery> deliveries = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double distance = scanner.nextDouble();
            
            if (type.equals("STANDARD")) deliveries.add(new StandardDelivery(weight, distance));
            else if (type.equals("EXPRESS")) deliveries.add(new ExpressDelivery(weight, distance));
            else if (type.equals("INTERNATIONAL")) deliveries.add(new InternationalDelivery(weight, distance, scanner.nextDouble()));
        }

        double total = 0;
        for (Delivery d : deliveries) {
            double fee = d.calculateFee();
            System.out.printf("%s: %.2f\n", d.getType(), fee);
            total += fee;
        }
        System.out.printf("Total: %.2f\n", total);
    }
}