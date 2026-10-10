import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Employee {
    double calculateBonus();
    String getName();
}

class FullTimeEmployee implements Employee {
    private String name;
    private double salary;
    public FullTimeEmployee(String name, double salary) { this.name = name; this.salary = salary; }
    public double calculateBonus() { return salary * 0.10; }
    public String getName() { return name; }
}

class PartTimeEmployee implements Employee {
    private String name;
    private double salary;
    public PartTimeEmployee(String name, double salary) { this.name = name; this.salary = salary; }
    public double calculateBonus() { return salary * 0.05; }
    public String getName() { return name; }
}

class Intern implements Employee {
    private String name;
    public Intern(String name) { this.name = name; }
    public double calculateBonus() { return 2000.0; }
    public String getName() { return name; }
}

public class PayrollSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            double salary = scanner.nextDouble();
            
            if (type.equals("FULLTIME")) employees.add(new FullTimeEmployee(name, salary));
            else if (type.equals("PARTTIME")) employees.add(new PartTimeEmployee(name, salary));
            else if (type.equals("INTERN")) employees.add(new Intern(name));
        }

        double totalBonus = 0;
        for (Employee e : employees) {
            double bonus = e.calculateBonus();
            System.out.printf("%s: %.2f\n", e.getName(), bonus);
            totalBonus += bonus;
        }
        System.out.printf("Total Bonus: %.2f\n", totalBonus);
    }
}