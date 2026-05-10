package entities;

import items.Item;
import java.util.ArrayList;

public class Chest extends Entity implements Activatable {

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
        } else {
            java.awt.Color wood = new java.awt.Color(139, 69, 19);
            java.awt.Color gold = new java.awt.Color(218, 165, 32);
            java.awt.Color darkWood = new java.awt.Color(101, 67, 33);
            
            if (broken) {
                g2.setColor(darkWood);
                g2.fillRect(x, y + height/2, width, height/2);
                g2.setColor(wood);
                g2.drawRect(x, y + height/2, width, height/2);
            } else {
                g2.setColor(wood);
                g2.fillRect(x, y, width, height);
                g2.setColor(gold);
                g2.drawRect(x, y, width, height);
                g2.fillRect(x, y + height/4, width, 4);
                g2.fillRect(x + width/2 - 4, y + height/2 - 4, 8, 8);
            }
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

    @Override
    public void activate() {
        breakChest();
    }

    @Override
    public boolean isActivated() {
        return broken;
    }
}
