package entities;

import managers.Executable;
import java.awt.Graphics2D;
import java.awt.Color;

/**
 * Achievement entity that acts as a checkpoint.
 * When executed, it updates the player's spawn point.
 */
public class Achievement extends Entity implements Executable {
    private String name;
    private String description;
    private boolean unlocked;
    private Player player;

    public Achievement(int x, int y, int width, int height, String name, String description, Player player) {
        super(x, y, width, height);
        this.name = name;
        this.description = description;
        this.unlocked = false;
        this.player = player;
    }

    @Override
    public void update() {
        if (!unlocked && player != null && collidesWith(player)) {
            execute();
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        // Simple representation: a gold star or trophy
        g2.setColor(unlocked ? Color.YELLOW : Color.GRAY);
        g2.fillRect(x, y, width, height);
        g2.setColor(Color.BLACK);
        g2.drawRect(x, y, width, height);
        g2.drawString(unlocked ? "★" : "?", x + width / 4, y + height / 2);
    }

    @Override
    public void execute() {
        if (!unlocked) {
            unlocked = true;
            System.out.println("Achievement Unlocked: " + name + " - " + description);
            if (player != null) {
                player.setSpawnPoint(this.x, this.y);
            }
        }
    }

    public boolean isUnlocked() { return unlocked; }
    public String getName() { return name; }
    public String getDescription() { return description; }
}
