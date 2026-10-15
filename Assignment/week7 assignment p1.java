public class Character {
    private int health;
    private final int maxHealth;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth; // Initializes character with full health
    }

    public void takeDamage(int amount) {
        if (amount > 0) {
            // Clamps health so it never drops below 0
            this.health = Math.max(0, this.health - amount);
        }
    }

    public void heal(int amount) {
        if (amount > 0) {
            // Clamps health so it never exceeds maxHealth
            this.health = Math.min(this.maxHealth, this.health + amount);
        }
    }

    // Read-only getter, no setter provided
    public int getHealth() {
        return this.health;
    }
}