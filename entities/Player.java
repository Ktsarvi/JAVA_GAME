package entities;

import managers.Inventory;
import items.Food;
import items.Key;
import items.Crowbar;
import java.awt.Graphics2D;

public class Player extends LivingBeing {

    private Inventory inventory;
    private int spawnX, spawnY;

    public Player(int x, int y, int width, int height) {
        super(x, y, width, height, 100, 10, 4);
        this.spawnX = x;
        this.spawnY = y;
        this.inventory = new Inventory(10);
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

    public void setSpawnPoint(int x, int y) {
        this.spawnX = x;
        this.spawnY = y;
        System.out.println("Spawn point updated to: " + x + ", " + y);
    }

    public Inventory getInventory() { return inventory; }
    public int getSpawnX() { return spawnX; }
    public int getSpawnY() { return spawnY; }
}
