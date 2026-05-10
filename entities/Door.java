package entities;

import items.Key;
import graphics.Assets;
import java.awt.Color;
import java.awt.Graphics2D;

public class Door extends Entity {
    private boolean locked;
    private int doorId;  // For relevant match of key with door
    private String targetRoomId;
    private int targetX, targetY;

    public Door(int x, int y, int width, int height, boolean locked, int doorId) {
        super(x, y, width, height);
        this.locked = locked;
        this.doorId = doorId;
        this.sprite = locked ? Assets.doorLocked : Assets.doorOpen;
    }

    public Door(int x, int y, int width, int height, boolean locked) {
        this(x, y, width, height, locked, 0);
    }

    @Override
    public void update() {
        // Door doesn't move so it is empty
    }

    @Override
    public void draw(Graphics2D g2) {
        if (sprite != null) {
            g2.drawImage(sprite, x, y, width, height, null);
        } else {
            if (locked) {
                // Locked door: dark brown with lock symbol
                g2.setColor(new Color(100, 60, 20));
                g2.fillRect(x, y, width, height);
                g2.setColor(new Color(60, 35, 10));
                g2.drawRect(x, y, width, height);
                // Lock icon
                g2.setColor(new Color(200, 170, 50));
                g2.fillOval(x + width / 2 - 6, y + height / 2 - 8, 12, 12);
                g2.fillRect(x + width / 2 - 5, y + height / 2, 10, 8);
            } else {
                // Open door: lighter color, archway
                g2.setColor(new Color(60, 40, 15));
                g2.fillRect(x, y, width, height);
                g2.setColor(new Color(30, 20, 5));
                g2.fillRect(x + 6, y + 4, width - 12, height - 4);
            }
        }
    }

    public void unlock(Key key) {
        if (locked && key != null && key.getId() == doorId) {
            locked = false;
            // Door stays active — it remains visible as an open doorway
            // Player walks through it to trigger room transition
        }
    }

    public void setTarget(String roomId, int x, int y) {
        this.targetRoomId = roomId;
        this.targetX = x;
        this.targetY = y;
    }

    public boolean isLocked() { return locked; }
    public boolean canPass() { return !locked; }
    public int getDoorId() { return doorId; }
    public String getTargetRoomId() { return targetRoomId; }
    public int getTargetX() { return targetX; }
    public int getTargetY() { return targetY; }
}
