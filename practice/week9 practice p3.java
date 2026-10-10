import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class LibraryItem {
    protected String title;
    protected int daysLate;
    public LibraryItem(String title, int daysLate) { this.title = title; this.daysLate = daysLate; }
    public abstract double calculateFine();
    public String getTitle() { return title; }
}

class BookItem extends LibraryItem {
    public BookItem(String title, int daysLate) { super(title, daysLate); }
    public double calculateFine() { return daysLate * 2.0; }
}

class DvdItem extends LibraryItem {
    public DvdItem(String title, int daysLate) { super(title, daysLate); }
    public double calculateFine() { return Math.min(50.0, daysLate * 5.0); }
}

class MagazineItem extends LibraryItem {
    public MagazineItem(String title, int daysLate) { super(title, daysLate); }
    public double calculateFine() { return daysLate * 1.0; }
}

public class LibraryFineSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<LibraryItem> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String title = scanner.next();
            int days = scanner.nextInt();
            
            if (type.equals("BOOK")) items.add(new BookItem(title, days));
            else if (type.equals("DVD")) items.add(new DvdItem(title, days));
            else if (type.equals("MAGAZINE")) items.add(new MagazineItem(title, days));
        }

        double totalFines = 0;
        for (LibraryItem item : items) {
            double fine = item.calculateFine();
            System.out.printf("%s: %.2f\n", item.getTitle(), fine);
            totalFines += fine;
        }
        System.out.printf("Total Fines: %.2f\n", totalFines);
    }
}