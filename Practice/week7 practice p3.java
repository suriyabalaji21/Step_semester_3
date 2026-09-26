public class NameTag {
    private final String firstName;
    private final String lastNameInitial;

    public NameTag(String fullName) {
        String[] parts = fullName.split(" ");
        this.firstName = parts[0];
        this.lastNameInitial = parts[1].charAt(0) + ".";
    }

    public String getNickname() {
        return firstName + " " + lastNameInitial;
    }
}