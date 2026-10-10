import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Staff {
    protected String name;
    public Staff(String name) { this.name = name; }
    public abstract double calculatePay();
    public String getName() { return name; }
}

class FullTimeStaff extends Staff {
    private double weeklySalary;
    public FullTimeStaff(String name, double weeklySalary) { super(name); this.weeklySalary = weeklySalary; }
    public double calculatePay() { return weeklySalary; }
}

class HourlyStaff extends Staff {
    private double hours, rate;
    public HourlyStaff(String name, double hours, double rate) { super(name); this.hours = hours; this.rate = rate; }
    public double calculatePay() {
        if (hours <= 40) return hours * rate;
        return (40 * rate) + ((hours - 40) * rate * 1.5);
    }
}

class Intern extends Staff {
    private double stipend;
    public Intern(String name, double stipend) { super(name); this.stipend = stipend; }
    public double calculatePay() { return stipend; }
}

public class PayrollSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Staff> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            if (type.equals("FULLTIME")) employees.add(new FullTimeStaff(name, scanner.nextDouble()));
            else if (type.equals("HOURLY")) employees.add(new HourlyStaff(name, scanner.nextDouble(), scanner.nextDouble()));
            else if (type.equals("INTERN")) employees.add(new Intern(name, scanner.nextDouble()));
        }

        double totalPayroll = 0;
        for (Staff s : employees) {
            double pay = s.calculatePay();
            System.out.printf("%s: %.2f\n", s.getName(), pay);
            totalPayroll += pay;
        }
        System.out.printf("Total Payroll: %.2f\n", totalPayroll);
    }
}