package entities;

import java.awt.Graphics2D;

public abstract class LivingBeing extends Entity {

    protected int hp;
    protected int maxHp;
    protected int strength;
    protected int speed;

    public LivingBeing(int x, int y, int width, int height, int hp, int strength, int speed) {
        super(x, y, width, height);
        this.hp = hp;
        this.maxHp = hp;
        this.strength = strength;
        this.speed = speed;
    }

    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public void attack(LivingBeing target) {
        target.takeDamage(strength);
    }

    public void takeDamage(int damage) {
        hp -= damage;
        if (hp <= 0) {
            hp = 0;
            active = false;
        }
    }

    public void heal(int amount) {
        hp += amount;
        if (hp > maxHp) hp = maxHp;
    }

    public boolean isAlive() { return hp > 0; }
    public int getHp() { return hp; }
    public int getMaxHp() { return maxHp; }
    public int getStrength() { return strength; }
    public int getSpeed() { return speed; }
}
