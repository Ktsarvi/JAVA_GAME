package entities;

import managers.Executable;
import java.awt.Color;
import java.awt.Graphics2D;

public class Achievement extends Entity implements Executable {
    private String name;
    private String description;
    private boolean unlocked;
    private Player player;
    private String roomId;

    public Achievement(int x, int y, int width, int height, String name, String description, Player player, String roomId) {
        super(x, y, width, height);
        this.name = name;
        this.description = description;
        this.unlocked = false;
        this.player = player;
        this.roomId = roomId;
    }

    @Override
    public void update() {
        if (!unlocked && player != null && collidesWith(player)) {
            execute();
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        // Draw a gold star shape
        Color starColor = unlocked ? new Color(255, 215, 0) : new Color(150, 150, 150);
        g2.setColor(starColor);

        int cx = x + width / 2;
        int cy = y + height / 2;
        int r = width / 2;

        // 5-pointed star using polygon
        int[] xPoints = new int[10];
        int[] yPoints = new int[10];
        for (int i = 0; i < 10; i++) {
            double angle = Math.PI / 2 + i * Math.PI / 5;
            int radius = (i % 2 == 0) ? r : r / 2;
            xPoints[i] = cx + (int)(radius * Math.cos(angle));
            yPoints[i] = cy - (int)(radius * Math.sin(angle));
        }
        g2.fillPolygon(xPoints, yPoints, 10);

        // Border
        g2.setColor(unlocked ? new Color(180, 140, 0) : new Color(100, 100, 100));
        g2.drawPolygon(xPoints, yPoints, 10);
    }

    @Override
    public void execute() {
        if (!unlocked) {
            unlocked = true;
            if (player != null) {
                player.setSpawnPoint(this.x, this.y, this.roomId);
            }
        }
    }

    public boolean isUnlocked() { return unlocked; }
    public String getName() { return name; }
    public String getDescription() { return description; }
}
