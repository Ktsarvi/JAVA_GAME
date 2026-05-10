package entities;

import managers.Inventory;
import items.Food;
import items.Key;
import items.Crowbar;
import input.KeyboardHandler;
import graphics.Assets;
import utils.Constants;
import java.awt.Color;
import java.awt.Graphics2D;

public class Player extends LivingBeing {

    private Inventory inventory;
    private int spawnX, spawnY;
    private KeyboardHandler keyHandler;
    private int direction; // 0=up, 1=down, 2=left, 3=right
    private int attackCooldown;

    public Player(int x, int y, int width, int height) {
        super(x, y, width, height, 100, 10, 4);
        this.spawnX = x;
        this.spawnY = y;
        this.inventory = new Inventory(10);
        this.direction = 1; // facing down
        this.attackCooldown = 0;
        this.sprite = Assets.player;
    }

    @Override
    public void update() {
        if (attackCooldown > 0) attackCooldown--;

        if (keyHandler == null) return;

        int dx = 0, dy = 0;
        if (keyHandler.up)    { dy = -speed; direction = 0; }
        if (keyHandler.down)  { dy =  speed; direction = 1; }
        if (keyHandler.left)  { dx = -speed; direction = 2; }
        if (keyHandler.right) { dx =  speed; direction = 3; }

        move(dx, dy);
    }

    @Override
    public void draw(Graphics2D g2) {
        if (sprite != null) {
            g2.drawImage(sprite, x, y, width, height, null);
        } else {
            // Procedural player drawing — blue body with direction indicator
            g2.setColor(new Color(40, 100, 200));
            g2.fillRoundRect(x, y, width, height, 8, 8);

            // Direction arrow
            g2.setColor(new Color(200, 220, 255));
            int cx = x + width / 2;
            int cy = y + height / 2;
            switch (direction) {
                case 0: g2.fillPolygon(new int[]{cx, cx - 6, cx + 6}, new int[]{y + 4, y + 14, y + 14}, 3); break;
                case 1: g2.fillPolygon(new int[]{cx, cx - 6, cx + 6}, new int[]{y + height - 4, y + height - 14, y + height - 14}, 3); break;
                case 2: g2.fillPolygon(new int[]{x + 4, x + 14, x + 14}, new int[]{cy, cy - 6, cy + 6}, 3); break;
                case 3: g2.fillPolygon(new int[]{x + width - 4, x + width - 14, x + width - 14}, new int[]{cy, cy - 6, cy + 6}, 3); break;
            }

            // Eyes
            g2.setColor(Color.WHITE);
            g2.fillOval(x + 10, y + 12, 8, 8);
            g2.fillOval(x + width - 18, y + 12, 8, 8);
            g2.setColor(Color.BLACK);
            g2.fillOval(x + 12, y + 14, 4, 4);
            g2.fillOval(x + width - 16, y + 14, 4, 4);
        }

        // Health bar above player
        int barWidth = width;
        int barHeight = 4;
        int barY = y - 8;
        g2.setColor(Color.DARK_GRAY);
        g2.fillRect(x, barY, barWidth, barHeight);
        float hpRatio = (float) hp / maxHp;
        g2.setColor(hpRatio > 0.5f ? Color.GREEN : hpRatio > 0.25f ? Color.YELLOW : Color.RED);
        g2.fillRect(x, barY, (int) (barWidth * hpRatio), barHeight);
    }

    public void respawn() {
        this.x = spawnX;
        this.y = spawnY;
        this.hp = maxHp;
        this.active = true;
    }

    public void useFood(Food food) {
        heal(food.getHealAmount());
    }

    public void unlockDoor(Door door, Key key) {
        door.unlock(key);
    }

    public void breakChest(Chest chest, Crowbar crowbar) {
        var loot = chest.breakChest();
        if (loot != null) {
            for (var item : loot) {
                inventory.add(item);
            }
        }
    }

    public boolean canAttack() {
        return attackCooldown <= 0;
    }

    public void performAttack() {
        attackCooldown = Constants.ATTACK_COOLDOWN;
    }

    public void setSpawnPoint(int x, int y) {
        this.spawnX = x;
        this.spawnY = y;
        System.out.println("Spawn point updated to: " + x + ", " + y);
    }

    public void setKeyboardHandler(KeyboardHandler kh) { this.keyHandler = kh; }
    public int getDirection() { return direction; }
    public Inventory getInventory() { return inventory; }
    public int getSpawnX() { return spawnX; }
    public int getSpawnY() { return spawnY; }
}
