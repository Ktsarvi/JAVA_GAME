package entities;

import items.Item;
import graphics.Assets;
import utils.Constants;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class Enemy extends LivingBeing {

    private List<Item> loot;
    private int aggroRange;
    private Player target;
    private int attackCooldown;
    private boolean isBoss;

    public Enemy(int x, int y, int width, int height, int hp, int strength, int speed, int aggroRange) {
        super(x, y, width, height, hp, strength, speed);
        this.loot = new ArrayList<>();
        this.aggroRange = aggroRange;
        this.attackCooldown = 0;
        this.isBoss = false;
        this.sprite = Assets.enemy;
    }

    @Override
    public void update() {
        if (attackCooldown > 0) attackCooldown--;

        if (target != null && target.isAlive() && isInRange(target)) {
            chase(target);
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        if (sprite != null) {
            g2.drawImage(sprite, x, y, width, height, null);
        } else {
            
            g2.setColor(isBoss ? new Color(180, 30, 30) : new Color(160, 50, 50));
            g2.fillRoundRect(x, y, width, height, 6, 6);
            if (isBoss) {
                
                g2.setColor(new Color(255, 215, 0));
                g2.fillRect(x + 4, y - 6, width - 8, 6);
            }
        }

        
        int barWidth = width;
        int barHeight = 4;
        int barY = y - 8;
        g2.setColor(Color.DARK_GRAY);
        g2.fillRect(x, barY, barWidth, barHeight);
        float hpRatio = (float) hp / maxHp;
        g2.setColor(hpRatio > 0.5f ? new Color(200, 50, 50) : new Color(255, 80, 30));
        g2.fillRect(x, barY, (int) (barWidth * hpRatio), barHeight);
    }

    public void chase(Player target) {
        int dx = target.getX() - x;
        int dy = target.getY() - y;
        if (dx != 0) move(Integer.signum(dx) * speed, 0);
        if (dy != 0) move(0, Integer.signum(dy) * speed);
    }

    public void attackPlayer(Player player) {
        if (attackCooldown <= 0) {
            attack(player);
            attackCooldown = Constants.ATTACK_COOLDOWN;
        }
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

    public void setTarget(Player player) { this.target = player; }
    public void setBoss(boolean boss) { this.isBoss = boss; if (boss) sprite = Assets.boss; }
    public boolean isBoss() { return isBoss; }
    public int getAggroRange() { return aggroRange; }
}
