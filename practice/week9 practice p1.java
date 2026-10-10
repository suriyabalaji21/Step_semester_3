import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Plot {
    protected String owner;
    protected String shape;

    public Plot(String owner, String shape) {
        this.owner = owner;
        this.shape = shape;
    }

    public abstract double getArea();

    public String getOwner() { return owner; }
    public String getShape() { return shape; }
}

class CirclePlot extends Plot {
    private double radius;
    public CirclePlot(String owner, double radius) { super(owner, "CIRCLE"); this.radius = radius; }
    public double getArea() { return Math.PI * radius * radius; }
}

class RectanglePlot extends Plot {
    private double length, width;
    public RectanglePlot(String owner, double length, double width) { super(owner, "RECTANGLE"); this.length = length; this.width = width; }
    public double getArea() { return length * width; }
}

class TrianglePlot extends Plot {
    private double base, height;
    public TrianglePlot(String owner, double base, double height) { super(owner, "TRIANGLE"); this.base = base; this.height = height; }
    public double getArea() { return 0.5 * base * height; }
}

public class GardenReport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Plot> plots = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String owner = scanner.next();
            if (type.equals("CIRCLE")) plots.add(new CirclePlot(owner, scanner.nextDouble()));
            else if (type.equals("RECTANGLE")) plots.add(new RectanglePlot(owner, scanner.nextDouble(), scanner.nextDouble()));
            else if (type.equals("TRIANGLE")) plots.add(new TrianglePlot(owner, scanner.nextDouble(), scanner.nextDouble()));
        }

        double totalArea = 0;
        for (Plot p : plots) {
            double area = p.getArea();
            System.out.printf("%s (%s): %.2f\n", p.getOwner(), p.getShape(), area);
            totalArea += area;
        }
        System.out.printf("Total Area: %.2f\n", totalArea);
    }
}