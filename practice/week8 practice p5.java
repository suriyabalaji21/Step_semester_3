import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Transport {
    double calculateFare();
    String getType();
}

class Bus implements Transport {
    private double distance;
    public Bus(double distance) { this.distance = distance; }
    public double calculateFare() { return Math.min(10.0, 2.0 + (0.10 * distance)); }
    public String getType() { return "BUS"; }
}

class Train implements Transport {
    private double distance;
    public Train(double distance) { this.distance = distance; }
    public double calculateFare() { return 3.0 + (0.15 * distance); }
    public String getType() { return "TRAIN"; }
}

class Metro implements Transport {
    private double distance, peakFactor;
    public Metro(double distance, double peakFactor) { this.distance = distance; this.peakFactor = peakFactor; }
    public double calculateFare() { return (1.50 + (0.20 * distance)) * peakFactor; }
    public String getType() { return "METRO"; }
}

public class TransportSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Transport> journeys = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double distance = scanner.nextDouble();
            
            if (type.equals("BUS")) journeys.add(new Bus(distance));
            else if (type.equals("TRAIN")) journeys.add(new Train(distance));
            else if (type.equals("METRO")) journeys.add(new Metro(distance, scanner.nextDouble()));
        }

        double total = 0;
        for (Transport t : journeys) {
            double fare = t.calculateFare();
            System.out.printf("%s: %.2f\n", t.getType(), fare);
            total += fare;
        }
        System.out.printf("Total: %.2f\n", total);
    }
}