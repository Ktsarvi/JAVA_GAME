package items;

public abstract class Food extends Item {
    protected int healAmount;  // How much HP it will heal player
    protected bool speedBoost;    // If food gave speed boost to player

    public Food(String name, int healAmount, bool speedBoost) {
        super(name);
        this.healAmount = healAmount;
        this.speedBoost = speedBoost;

        // Food is usually consumed after use
        this.consumable = true;
    }

    @Override
    public void use() {
        // Logic is handled in Player,
        // But we will add here sound of eating
    }

    // Getters
    public int getHealAmount() {
        return healAmount;
    }

    public bool getSpeedBoost() {
        return speedBoost;
    }
}
