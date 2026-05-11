
package ui;

import entities.Player;
import managers.Inventory;
import items.Item;
import input.KeyboardHandler;
import utils.Constants;
import java.awt.*;
import java.util.List;

public class InventoryUI {

    private Player player;
    private boolean visible = false;
    private KeyboardHandler keyHandler;
    private boolean iReleased = true;
    private int selectedSlot = -1;
    private String message = "";
    private int messageTimer = 0;

    public InventoryUI(Player player, KeyboardHandler keyHandler) {
        this.player = player;
        this.keyHandler = keyHandler;
    }

    public void update() {
        if (!keyHandler.inventory) iReleased = true;
        if (keyHandler.inventory && iReleased) {
            visible = !visible;
            iReleased = false;
        }

        if (messageTimer > 0) messageTimer--;
        if (messageTimer <= 0) message = "";

        if (visible && keyHandler.numberPressed >= 1 && keyHandler.numberPressed <= 9) {
            selectedSlot = keyHandler.numberPressed - 1;
            keyHandler.numberPressed = -1;
        }
    }

    public int getSelectedSlot() { return selectedSlot; }
    public void clearSelectedSlot() { selectedSlot = -1; }

    public void showMessage(String msg) {
        this.message = msg;
        this.messageTimer = 120; // 2 seconds at 60fps
    }

    public void draw(Graphics2D g) {
        // Always draw message if active
        if (!message.isEmpty()) {
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setFont(new Font("SansSerif", Font.BOLD, 16));
            FontMetrics fm = g.getFontMetrics();
            int mw = fm.stringWidth(message) + 20;
            int mx = (Constants.SCREEN_WIDTH - mw) / 2;
            int my = Constants.SCREEN_HEIGHT - 80;
            g.setColor(new Color(0, 0, 0, 180));
            g.fillRoundRect(mx, my, mw, 30, 10, 10);
            g.setColor(new Color(255, 255, 200));
            g.drawString(message, mx + 10, my + 21);
        }

        if (!visible) return;

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = Constants.SCREEN_WIDTH, h = Constants.SCREEN_HEIGHT;
        int panelW = 360, panelH = 280;
        int px = (w - panelW) / 2, py = (h - panelH) / 2;

        // Panel background
        g.setColor(new Color(20, 15, 30, 230));
        g.fillRoundRect(px, py, panelW, panelH, 16, 16);
        g.setColor(new Color(120, 100, 180));
        g.drawRoundRect(px, py, panelW, panelH, 16, 16);

        // Title
        g.setFont(new Font("SansSerif", Font.BOLD, 20));
        g.setColor(new Color(220, 200, 255));
        g.drawString("INVENTORY", px + panelW / 2 - 55, py + 30);

        // Grid: 5 cols x 2 rows
        Inventory inv = player.getInventory();
        List<Item> slots = inv.getSlots();
        int slotSize = 50, gap = 10;
        int gridX = px + 30, gridY = py + 50;

        for (int i = 0; i < inv.getMaxSlots(); i++) {
            int row = i / 5, col = i % 5;
            int sx = gridX + col * (slotSize + gap);
            int sy = gridY + row * (slotSize + gap + 20);

            // Slot background
            g.setColor(i < slots.size() ? new Color(50, 40, 70) : new Color(30, 25, 45));
            g.fillRoundRect(sx, sy, slotSize, slotSize, 8, 8);
            g.setColor(new Color(100, 85, 140));
            g.drawRoundRect(sx, sy, slotSize, slotSize, 8, 8);

            // Slot number
            g.setFont(new Font("SansSerif", Font.PLAIN, 10));
            g.setColor(new Color(150, 140, 160));
            g.drawString(String.valueOf(i + 1), sx + 2, sy + 12);

            // Item
            if (i < slots.size()) {
                Item item = slots.get(i);
                if (item.getIcon() != null) {
                    g.drawImage(item.getIcon(), sx + 5, sy + 5, slotSize - 10, slotSize - 10, null);
                } else {
                    // Procedural icon
                    g.setFont(new Font("SansSerif", Font.BOLD, 11));
                    g.setColor(getItemColor(item.getName()));
                    String abbr = item.getName().length() > 5 ? item.getName().substring(0, 5) : item.getName();
                    g.drawString(abbr, sx + 5, sy + 35);
                }

                // Item name below
                g.setFont(new Font("SansSerif", Font.PLAIN, 10));
                g.setColor(new Color(180, 170, 200));
                g.drawString(item.getName(), sx, sy + slotSize + 12);

                if (player.getEquippedWeapon() == item) {
                    g.setFont(new Font("SansSerif", Font.BOLD, 12));
                    g.setColor(Color.YELLOW);
                    g.drawString("E", sx + slotSize - 12, sy + 12);
                }
            }
        }

        // Instructions
        g.setFont(new Font("SansSerif", Font.PLAIN, 12));
        g.setColor(new Color(140, 130, 160));
        g.drawString("Press 1-9 to use  |  I to close", px + 60, py + panelH - 15);
    }

    private Color getItemColor(String name) {
        switch (name) {
            case "Apple": return new Color(200, 60, 60);
            case "Cake": return new Color(220, 180, 100);
            case "Potion": return new Color(100, 180, 255);
            case "Key": return new Color(255, 215, 0);
            case "Crowbar": return new Color(150, 150, 150);
            case "Gun": return new Color(180, 100, 50);
            default: return new Color(200, 200, 200);
        }
    }

    public boolean isVisible() { return visible; }
    public void setPlayer(Player player) { this.player = player; }
}
