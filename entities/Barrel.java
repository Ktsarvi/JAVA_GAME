package entities;

import items.Item;
import graphics.Assets;
import java.awt.Graphics2D;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * A barrel entity that can be activated (broken).
 * Can store items that drop when broken.
 */
public class Barrel extends Entity implements Activatable {
    private boolean activated;
    private List<Item> items;

    public Barrel(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.activated = false;
        this.items = new ArrayList<>();
        this.sprite = Assets.barrel;
    }

    @Override
    public void update() {
        // Barrel logic if needed (e.g. physics)
    }

    @Override
    public void draw(Graphics2D g2) {
        if (sprite != null && !activated) {
            g2.drawImage(sprite, x, y, width, height, null);
        } else if (!activated) {
            g2.setColor(new Color(139, 69, 19)); // Brown
            g2.fillOval(x, y, width, height);
            g2.setColor(new Color(100, 50, 10));
            g2.fillRect(x + 4, y + height / 3, width - 8, 4);
            g2.fillRect(x + 4, y + 2 * height / 3, width - 8, 4);
            g2.setColor(Color.BLACK);
            g2.drawOval(x, y, width, height);
        } else {
            // Draw fragments
            g2.setColor(new Color(139, 69, 19, 100));
            g2.drawOval(x, y, width, height);
        }
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> breakBarrel() {
        if (activated) return null;
        activated = true;
        this.active = false;
        return items;
    }

    @Override
    public void activate() {
        if (!activated) {
            activated = true;
            System.out.println("Barrel at (" + x + ", " + y + ") was activated!");
            // Potential for spawning items here
        }
    }

    @Override
    public boolean isActivated() {
        return activated;
    }

    public List<Item> getItems() { return items; }
}
