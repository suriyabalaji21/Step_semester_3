import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface SaverMode {
    double applySaver(double units);
}

abstract class Appliance {
    protected double hours;
    public Appliance(double hours) { this.hours = hours; }
    protected abstract double getPowerRatingW();
    public abstract String getType();

    public double getBaseUnits() {
        return (getPowerRatingW() * hours) / 1000.0;
    }
}

class Fridge extends Appliance {
    public Fridge(double hours) { super(hours); }
    protected double getPowerRatingW() { return 150.0; }
    public String getType() { return "FRIDGE"; }
}

class AirConditioner extends Appliance implements SaverMode {
    public AirConditioner(double hours) { super(hours); }
    protected double getPowerRatingW() { return 1500.0; }
    public double applySaver(double units) { return units * 0.75; }
    public String getType() { return "AC"; }
}

class Television extends Appliance {
    public Television(double hours) { super(hours); }
    protected double getPowerRatingW() { return 100.0; }
    public String getType() { return "TV"; }
}

class Washer extends Appliance implements SaverMode {
    public Washer(double hours) { super(hours); }
    protected double getPowerRatingW() { return 500.0; }
    public double applySaver(double units) { return units * 0.75; }
    public String getType() { return "WASHER"; }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = Integer.parseInt(scanner.nextLine().trim());
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().split("\\s+");
            String type = parts[0];
            double hours = Double.parseDouble(parts[1]);
            boolean isSaver = parts.length > 2 && parts[2].equals("SAVER");

            Appliance app = null;
            if (type.equals("FRIDGE")) app = new Fridge(hours);
            else if (type.equals("AC")) app = new AirConditioner(hours);
            else if (type.equals("TV")) app = new Television(hours);
            else if (type.equals("WASHER")) app = new Washer(hours);

            if (app != null) {
                double units = app.getBaseUnits();
                
                if (isSaver) {
                    if (app instanceof SaverMode) {
                        units = ((SaverMode) app).applySaver(units);
                    } else {
                        System.out.printf("%s: saver mode not supported\n", app.getType());
                        continue;
                    }
                }
                
                double cost = units * 8.0;
                System.out.printf("%s: Units=%.2f Cost=%.2f\n", app.getType(), units, cost);
                totalCost += cost;
            }
        }
        System.out.printf("Total Cost: %.2f\n", totalCost);
    }
}