package items;

import graphics.Assets;

public class Gun extends Item {

    private int cooldown;
    private int currentCooldown;

    public Gun() {
        super("Gun");
        this.consumable = false;
        this.cooldown = 20;
        this.currentCooldown = 0;
        this.icon = Assets.gunIcon;
    }

    @Override
    public void use() {
        // Bullet creation is handled by GamePanel/CollisionManager
        // This just checks if gun can fire
    }

    public boolean canFire() {
        return currentCooldown <= 0;
    }

    public void fire() {
        currentCooldown = cooldown;
    }

    public void updateCooldown() {
        if (currentCooldown > 0) currentCooldown--;
    }

    public int getCooldown() { return cooldown; }
}
