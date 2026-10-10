import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Room {
    double calculateBill();
    String getType();
}

class SingleRoom implements Room {
    private int units;
    public SingleRoom(int units) { this.units = units; }
    public double calculateBill() { return 8.0 * units; }
    public String getType() { return "SINGLE"; }
}

class SharedRoom implements Room {
    private int units, occupants;
    public SharedRoom(int units, int occupants) { this.units = units; this.occupants = occupants; }
    public double calculateBill() { return (6.0 * units) / occupants; }
    public String getType() { return "SHARED"; }
}

class AcRoom implements Room {
    private int units;
    public AcRoom(int units) { this.units = units; }
    public double calculateBill() { return (10.0 * units) + 200.0; }
    public String getType() { return "AC"; }
}

public class HostelBilling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().trim().split("\\s+");
            String type = parts[0];
            int units = Integer.parseInt(parts[1]);
            
            if (type.equals("SINGLE")) {
                rooms.add(new SingleRoom(units));
            } else if (type.equals("SHARED")) {
                int occupants = Integer.parseInt(parts[2]);
                rooms.add(new SharedRoom(units, occupants));
            } else if (type.equals("AC")) {
                rooms.add(new AcRoom(units));
            }
        }

        double total = 0;
        for (Room r : rooms) {
            double bill = r.calculateBill();
            System.out.printf("%s: %.2f\n", r.getType(), bill);
            total += bill;
        }
        System.out.printf("Total: %.2f\n", total);
    }
}