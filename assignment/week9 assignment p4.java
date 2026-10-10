import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface NightService {
    double applyNightMultiplier(double baseFare);
}

abstract class Cab {
    protected double km;
    public Cab(double km) { this.km = km; }
    protected abstract double getRate();
    public abstract String getType();

    public double getBaseFare() {
        return Math.max(100.0, km * getRate());
    }
}

class MiniCab extends Cab {
    public MiniCab(double km) { super(km); }
    protected double getRate() { return 10.0; }
    public String getType() { return "MINI"; }
}

class SedanCab extends Cab implements NightService {
    public SedanCab(double km) { super(km); }
    protected double getRate() { return 14.0; }
    public double applyNightMultiplier(double baseFare) { return baseFare * 1.20; }
    public String getType() { return "SEDAN"; }
}

class SuvCab extends Cab implements NightService {
    public SuvCab(double km) { super(km); }
    protected double getRate() { return 18.0; }
    public double applyNightMultiplier(double baseFare) { return baseFare * 1.20; }
    public String getType() { return "SUV"; }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = Integer.parseInt(scanner.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().split("\\s+");
            String type = parts[0];
            double km = Double.parseDouble(parts[1]);
            String time = parts[2];

            Cab cab = null;
            if (type.equals("MINI")) cab = new MiniCab(km);
            else if (type.equals("SEDAN")) cab = new SedanCab(km);
            else if (type.equals("SUV")) cab = new SuvCab(km);

            if (cab != null) {
                double fare = cab.getBaseFare();
                if (time.equals("NIGHT")) {
                    if (cab instanceof NightService) {
                        fare = ((NightService) cab).applyNightMultiplier(fare);
                    } else {
                        System.out.printf("%s: night service not available\n", cab.getType());
                        continue;
                    }
                }
                System.out.printf("%s: %.2f\n", cab.getType(), fare);
                total += fare;
            }
        }
        System.out.printf("Total: %.2f\n", total);
    }
}