import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Booking {
    protected String mode;
    protected double distance;
    // Centralized booking fee. Change here applies to all modes.
    private static final double BOOKING_FEE = 50.0; 

    public Booking(String mode, double distance) { 
        this.mode = mode; 
        this.distance = distance; 
    }

    // Template method pattern
    public double getTotalFare() {
        return calculateBaseFare() + BOOKING_FEE;
    }

    protected abstract double calculateBaseFare();
    
    public String getMode() { return mode; }
}

class BusBooking extends Booking {
    public BusBooking(double distance) { super("BUS", distance); }
    protected double calculateBaseFare() { return distance * 2.0; }
}

class TrainBooking extends Booking {
    public TrainBooking(double distance) { super("TRAIN", distance); }
    protected double calculateBaseFare() { return distance * 1.5; }
}

class FlightBooking extends Booking {
    public FlightBooking(double distance) { super("FLIGHT", distance); }
    protected double calculateBaseFare() { return 2500.0 + (distance * 4.0); }
}

public class TravelBookingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Booking> bookings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String mode = scanner.next();
            double distance = scanner.nextDouble();
            
            if (mode.equals("BUS")) bookings.add(new BusBooking(distance));
            else if (mode.equals("TRAIN")) bookings.add(new TrainBooking(distance));
            else if (mode.equals("FLIGHT")) bookings.add(new FlightBooking(distance));
        }

        for (Booking b : bookings) {
            System.out.printf("%s: %.2f\n", b.getMode(), b.getTotalFare());
        }
    }
}