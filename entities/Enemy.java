package entities;

import items.Item;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class Enemy extends LivingBeing {

    private List<Item> loot;
    private int aggroRange;

    public Enemy(int x, int y, int width, int height, int hp, int strength, int speed, int aggroRange) {
        super(x, y, width, height, hp, strength, speed);
        this.loot = new ArrayList<>();
        this.aggroRange = aggroRange;
    }

    @Override
    public void update() {
    }

    @Override
    public void draw(Graphics2D g2) {
        if (sprite != null) {
            g2.drawImage(sprite, x, y, width, height, null);
        }
    }

    public void chase(Player target) {
        int dx = target.getX() - x;
        int dy = target.getY() - y;
        if (dx != 0) move(Integer.signum(dx) * speed, 0);
        if (dy != 0) move(0, Integer.signum(dy) * speed);
    }

    public boolean isInRange(Entity target) {
        int dx = target.getX() - x;
        int dy = target.getY() - y;
        return Math.sqrt(dx * dx + dy * dy) <= aggroRange;
    }

    public void addLoot(Item item) {
        loot.add(item);
    }

    public List<Item> dropItem() {
        List<Item> dropped = new ArrayList<>(loot);
        loot.clear();
        active = false;
        return dropped;
    }

    public int getAggroRange() { return aggroRange; }
}
