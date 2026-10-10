import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Booking {
    protected int count;
    private static final double CONVENIENCE_FEE = 20.0;

    public Booking(int count) {
        this.count = count;
    }

    protected abstract double getSeatPrice();
    public abstract String getType();

    public double getTotalAmount() {
        return (getSeatPrice() + CONVENIENCE_FEE) * count;
    }
}

class RegularBooking extends Booking {
    public RegularBooking(int count) { super(count); }
    protected double getSeatPrice() { return 150.0; }
    public String getType() { return "REGULAR"; }
}

class PremiumBooking extends Booking {
    public PremiumBooking(int count) { super(count); }
    protected double getSeatPrice() { return 250.0; }
    public String getType() { return "PREMIUM"; }
}

class ReclinerBooking extends Booking {
    public ReclinerBooking(int count) { super(count); }
    protected double getSeatPrice() { return 400.0; }
    public String getType() { return "RECLINER"; }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        List<Booking> bookings = new ArrayList<>();

        for (int i = 0; i < n;