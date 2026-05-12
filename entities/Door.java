package entities;

import items.Key;
import graphics.Assets;
import java.awt.Graphics2D;

public class Door extends Entity {
    private boolean locked;
    private int doorId;  
    private String targetRoomId;
    private int targetX, targetY;

    public Door(int x, int y, int width, int height, boolean locked, int doorId) {
        super(x, y, width, height);
        this.locked = locked;
        this.doorId = doorId;
        this.sprite = locked ? Assets.doorClosed : Assets.doorOpen;
    }

    public Door(int x, int y, int width, int height, boolean locked) {
        this(x, y, width, height, locked, 0);
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

    public void unlock(Key key) {
        if (locked && key != null && key.getId() == doorId) {
            locked = false;
            sprite = Assets.doorOpen; 
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
