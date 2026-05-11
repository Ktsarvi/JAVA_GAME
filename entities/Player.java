package entities;

import managers.Inventory;
import items.Food;
import items.Key;
import items.Crowbar;
import input.KeyboardHandler;
import graphics.Assets;
import graphics.Animator;
import utils.Constants;
import java.awt.Color;
import java.awt.Graphics2D;

public class Player extends LivingBeing {

    private Inventory inventory;
    private int spawnX, spawnY;
    private KeyboardHandler keyHandler;
    private int direction; // 0=up, 1=down, 2=left, 3=right
    private int attackCooldown;
    private Animator walkAnimator;
    private boolean moving;

    public Player(int x, int y, int width, int height) {
        super(x, y, width, height, 100, 10, 4);
        this.spawnX = x;
        this.spawnY = y;
        this.inventory = new Inventory(10);
        this.direction = 1; // facing down
        this.attackCooldown = 0;
        this.sprite = Assets.player;

        // Set up walk animation (4 frames, cycle every 8 ticks)
        if (Assets.playerWalkFrames != null) {
            walkAnimator = new Animator(Assets.playerWalkFrames, 8);
        }
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

        moving = (dx != 0 || dy != 0);

        if (moving && walkAnimator != null) {
            walkAnimator.update();
            sprite = walkAnimator.getCurrentFrame();
        } else if (!moving && Assets.playerWalkFrames != null) {
            sprite = Assets.playerWalkFrames[0]; // standing frame
        }

        move(dx, dy);
    }

    @Override
    public void draw(Graphics2D g2) {
        if (sprite != null) {
            // Flip sprite when moving left
            if (direction == 2) {
                g2.drawImage(sprite, x + width, y, -width, height, null);
            } else {
                g2.drawImage(sprite, x, y, width, height, null);
            }
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
    }

    public void setKeyboardHandler(KeyboardHandler kh) { this.keyHandler = kh; }
    public int getDirection() { return direction; }
    public Inventory getInventory() { return inventory; }
    public int getSpawnX() { return spawnX; }
    public int getSpawnY() { return spawnY; }
}
