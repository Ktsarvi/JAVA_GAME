package entities;

import items.Item;
import java.util.ArrayList;

public class Chest extends Entity {

    private ArrayList<Item> items;
    private boolean broken;

    public Chest(int x, int y, int width, int height) {
        super(x, y, width, height);

        items = new ArrayList<>();
        broken = false;
    }

    @Override
    public void update() {
        // Chest has no movement logic so we dont have anything 
    }

    @Override
    public void draw(java.awt.Graphics2D g2) {
        if (sprite != null) {
            g2.drawImage(sprite, x, y, width, height, null);
        }
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public ArrayList<Item> breakChest() {
        if (broken) {
            return null;
        }
        broken = true;

        // mark for removal from EntityManager
        this.active = false;

        return items;
    }

    public boolean isBroken() {
        return broken;
    }
}
