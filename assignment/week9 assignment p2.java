import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Insurable {
    double getInsuranceAmount();
}

abstract class Parcel {
    protected double weight;
    protected double declaredValue;

    public Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    public abstract double getCharge();
    public abstract String getType();
}

class StandardParcel extends Parcel {
    public StandardParcel(double weight, double declaredValue) { super(weight, declaredValue); }
    public double getCharge() { return 40.0 + (10.0 * weight); }
    public String getType() { return "STANDARD"; }
}

class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(double weight, double declaredValue) { super(weight, declaredValue); }
    public double getCharge() { return 80.0 + (15.0 * weight); }
    public double getInsuranceAmount() { return declaredValue * 0.02; }
    public String getType() { return "EXPRESS"; }
}

class FragileParcel extends Parcel implements Insurable {
    public FragileParcel(double weight, double declaredValue) { super(weight, declaredValue); }
    public double getCharge() { return 40.0 + (10.0 * weight) + 50.0; }
    public double getInsuranceAmount() { return declaredValue * 0.02; }
    public String getType() { return "FRAGILE"; }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        List<Parcel> parcels = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double declaredValue = scanner.nextDouble();

            if (type.equals("STANDARD")) parcels.add(new StandardParcel(weight, declaredValue));
            else if (type.equals("EXPRESS")) parcels.add(new ExpressParcel(weight, declaredValue));
            else if (type.equals("FRAGILE")) parcels.add(new FragileParcel(weight, declaredValue));
        }

        double grandTotal = 0;
        for (Parcel p : parcels) {
            double charge = p.getCharge();
            double insurance = 0;
            if (p instanceof Insurable) {
                insurance = ((Insurable) p).getInsuranceAmount();
            }
            double total = charge + insurance;
            grandTotal += total;
            
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f\n", 
                    p.getType(), charge, insurance, total);
        }
        System.out.printf("Grand Total: %.2f\n", grandTotal);
    }
}