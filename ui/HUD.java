package ui;

import entities.Player;
import managers.Inventory;
import utils.Constants;
import java.awt.*;

public class HUD {

    private Player player;

    public HUD(Player player) {
        this.player = player;
    }

    public void draw(Graphics2D g, String roomName, int achievementCount, int totalAchievements) {
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        
        g.setColor(new Color(0, 0, 0, 150));
        g.fillRect(0, 0, Constants.SCREEN_WIDTH, 40);

        
        int barX = 10, barY = 8, barW = 200, barH = 22;
        g.setColor(new Color(40, 40, 40));
        g.fillRoundRect(barX, barY, barW, barH, 8, 8);

        float hpRatio = (float) player.getHp() / player.getMaxHp();
        Color hpColor = hpRatio > 0.5f ? new Color(50, 200, 80) : hpRatio > 0.25f ? new Color(220, 180, 30) : new Color(220, 50, 40);
        g.setPaint(new GradientPaint(barX, barY, hpColor, barX, barY + barH, hpColor.darker()));
        g.fillRoundRect(barX, barY, (int)(barW * hpRatio), barH, 8, 8);

        g.setColor(new Color(180, 180, 180));
        g.drawRoundRect(barX, barY, barW, barH, 8, 8);

        
        g.setFont(new Font("SansSerif", Font.BOLD, 14));
        g.setColor(Color.WHITE);
        String hpText = player.getHp() + " / " + player.getMaxHp();
        FontMetrics fm = g.getFontMetrics();
        g.drawString(hpText, barX + (barW - fm.stringWidth(hpText)) / 2, barY + 16);

        
        g.setFont(new Font("SansSerif", Font.BOLD, 14));
        g.setColor(new Color(200, 180, 240));
        g.drawString(roomName, Constants.SCREEN_WIDTH / 2 - 40, 25);

        
        Inventory inv = player.getInventory();
        int keys = 0;
        for (var item : inv.getSlots()) {
            if (item.getName().equals("Key")) keys++;
        }
        g.setColor(new Color(255, 215, 0));
        g.drawString("Keys: " + keys, Constants.SCREEN_WIDTH - 200, 25);

        
        g.setColor(new Color(180, 220, 255));
        g.drawString("Stars: " + achievementCount + "/" + totalAchievements, Constants.SCREEN_WIDTH - 100, 25);
    }

    public void setPlayer(Player player) { this.player = player; }
}
