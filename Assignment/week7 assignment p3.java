public class PasswordChecker {
    
    private final String password;

    public PasswordChecker(String password) {
        this.password = password != null ? password : "";
    }

    public String getStrength() {
        int length = this.password.length();
        
        if (length < 6) {
            return "Weak";
        } else if (length <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }
}