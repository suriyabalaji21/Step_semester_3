import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface BusRider {
    double getTransportFee();
}

abstract class Student {
    protected String name;
    public Student(String name) { this.name = name; }
    public abstract double getTuition();
    public String getName() { return name; }
}

class DayScholar extends Student implements BusRider {
    public DayScholar(String name) { super(name); }
    public double getTuition() { return 40000.0; }
    public double getTransportFee() { return 12000.0; }
}

class Hosteller extends Student {
    public Hosteller(String name) { super(name); }
    public double getTuition() { return 40000.0 + 60000.0; }
}

class Scholar extends Student implements BusRider {
    public Scholar(String name) { super(name); }
    public double getTuition() { return 20000.0; }
    public double getTransportFee() { return 12000.0; }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();

            if (type.equals("DAY_SCHOLAR")) students.add(new DayScholar(name));
            else if (type.equals("HOSTELLER")) students.add(new Hosteller(name));
            else if (type.equals("SCHOLAR")) students.add(new Scholar(name));
        }

        double totalCollected = 0;
        for (Student s : students) {
            double fee = s.getTuition();
            if (s instanceof BusRider) {
                fee += ((BusRider) s).getTransportFee();
            }
            System.out.printf("%s: %.2f\n", s.getName(), fee);
            totalCollected += fee;
        }
        System.out.printf("Total Collected: %.2f\n", totalCollected);
    }
}