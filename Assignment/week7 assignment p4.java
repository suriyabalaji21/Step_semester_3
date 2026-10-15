public class TrafficLight {
    private final String id;
    private String color;

    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED"; 
    }

    public void next() {
        if ("RED".equals(color)) {
            color = "GREEN";
        } else if ("GREEN".equals(color)) {
            color = "YELLOW";
        } else if ("YELLOW".equals(color)) {
            color = "RED";
        }
    }

    // Read-only access to current state
    public String getColor() {
        return this.color;
    }

    public String getId() {
        return this.id;
    }
}