import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Vehicle {
    double calculateCharge();
    String getType();
}

class Bike implements Vehicle {
    private int hours;
    public Bike(int hours) { this.hours = hours; }
    public double calculateCharge() { return 10.0 * hours; }
    public String getType() { return "BIKE"; }
}

class Car implements Vehicle {
    private int hours;
    public Car(int hours) { this.hours = hours; }
    public double calculateCharge() { return 30.0 + ((hours - 1) * 20.0); }
    public String getType() { return "CAR"; }
}

class Truck implements Vehicle {
    private int hours;
    public Truck(int hours) { this.hours = hours; }
    public double calculateCharge() { return Math.max(100.0, 50.0 * hours); }
    public String getType() { return "TRUCK"; }
}

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Vehicle> parkedVehicles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int hours = scanner.nextInt();
            
            if (type.equals("BIKE")) parkedVehicles.add(new Bike(hours));
            else if (type.equals("CAR")) parkedVehicles.add(new Car(hours));
            else if (type.equals("TRUCK")) parkedVehicles.add(new Truck(hours));
        }

        double total = 0;
        for (Vehicle v : parkedVehicles) {
            double charge = v.calculateCharge();
            System.out.printf("%s: %.2f\n", v.getType(), charge);
            total += charge;
        }
        System.out.printf("Total: %.2f\n", total);
    }
}