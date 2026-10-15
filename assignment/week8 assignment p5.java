import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Subscription {
    LocalDate getRenewalDate();
    String getName();
}

class BasicPlan implements Subscription {
    private String name;
    private LocalDate startDate;
    public BasicPlan(String name, LocalDate startDate) { this.name = name; this.startDate = startDate; }
    public LocalDate getRenewalDate() { return startDate.plusDays(30); }
    public String getName() { return name; }
}

class StandardPlan implements Subscription {
    private String name;
    private LocalDate startDate;
    public StandardPlan(String name, LocalDate startDate) { this.name = name; this.startDate = startDate; }
    public LocalDate getRenewalDate() { return startDate.plusDays(90); }
    public String getName() { return name; }
}

class PremiumPlan implements Subscription {
    private String name;
    private LocalDate startDate;
    public PremiumPlan(String name, LocalDate startDate) { this.name = name; this.startDate = startDate; }
    public LocalDate getRenewalDate() { return startDate.plusDays(365); }
    public String getName() { return name; }
}

public class StreamingService {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Subscription> subscribers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            LocalDate startDate = LocalDate.parse(scanner.next());
            
            if (type.equals("BASIC")) subscribers.add(new BasicPlan(name, startDate));
            else if (type.equals("STANDARD")) subscribers.add(new StandardPlan(name, startDate));
            else if (type.equals("PREMIUM")) subscribers.add(new PremiumPlan(name, startDate));
        }

        for (Subscription sub : subscribers) {
            System.out.println(sub.getName() + ": " + sub.getRenewalDate());
        }
    }
}