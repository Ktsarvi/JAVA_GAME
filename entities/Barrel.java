package entities;

import items.Item;
import graphics.Assets;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

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
        // Barrel logic if needed
    }

    @Override
    public void draw(Graphics2D g2) {
        if (sprite != null) {
            g2.drawImage(sprite, x, y, width, height, null);
        }
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> breakBarrel() {
        if (activated) return null;
        activated = true;
        sprite = Assets.barrelBroken; // Switch to broken barrel sprite
        this.active = false;
        return items;
    }

    @Override
    public void activate() {
        if (!activated) {
            activated = true;
        }
    }

    @Override
    public boolean isActivated() {
        return activated;
    }

    public List<Item> getItems() { return items; }
}
