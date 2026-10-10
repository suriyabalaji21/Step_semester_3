import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface LibraryItem {
    LocalDate calculateDueDate(LocalDate currentDate);
    String getTitle();
}

class Book implements LibraryItem {
    private String title;
    public Book(String title) { this.title = title; }
    public LocalDate calculateDueDate(LocalDate currentDate) { return currentDate.plusDays(14); }
    public String getTitle() { return title; }
}

class DVD implements LibraryItem {
    private String title;
    public DVD(String title) { this.title = title; }
    public LocalDate calculateDueDate(LocalDate currentDate) { return currentDate.plusDays(7); }
    public String getTitle() { return title; }
}

class Magazine implements LibraryItem {
    private String title;
    public Magazine(String title) { this.title = title; }
    public LocalDate calculateDueDate(LocalDate currentDate) { return currentDate.plusDays(3); }
    public String getTitle() { return title; }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        List<LibraryItem> items = new ArrayList<>();
        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().split(" ", 2);
            String type = parts[0];
            String title = parts[1].replace("\"", "");
            
            if (type.equals("BOOK")) items.add(new Book(title));
            else if (type.equals("DVD")) items.add(new DVD(title));
            else if (type.equals("MAGAZINE")) items.add(new Magazine(title));
        }

        for (LibraryItem item : items) {
            System.out.println(item.getTitle() + ": " + item.calculateDueDate(currentDate));
        }
    }
}