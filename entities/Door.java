package entities;

import items.Key;
import java.awt.Graphics2D;

public class Door extends Entity {
    private boolean locked;
    private int doorId;  // For relevant match of key with door

    public Door(int x, int y, int width, int height, boolean locked) {
        super(x, y, width, height);
        this.locked = locked;
    }

    @Override
    public void update() {
        // Door doesn't move so it is empty
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

            // door becomes passable so it can be removed from collision system
            // and in general this object will be deleted 
            this.active = false;
        }
    }

    public boolean isLocked() {
        return locked;
    }

    public boolean canPass() {
        return !locked;
    }
}
