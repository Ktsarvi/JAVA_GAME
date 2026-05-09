package entities;

import java.awt.Graphics2D;
import java.awt.Color;

/**
 * A barrel entity that can be activated (broken).
 */
public class Barrel extends Entity implements Activatable {
    private boolean activated;

    public Barrel(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.activated = false;
    }

    @Override
    public void update() {
        // Barrel logic if needed (e.g. physics)
    }

    @Override
    public void draw(Graphics2D g2) {
        if (!activated) {
            g2.setColor(new Color(139, 69, 19)); // Brown
            g2.fillOval(x, y, width, height);
            g2.setColor(Color.BLACK);
            g2.drawOval(x, y, width, height);
        } else {
            // Draw fragments or just don't draw
            g2.setColor(new Color(139, 69, 19, 100));
            g2.drawOval(x, y, width, height);
        }
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
}
