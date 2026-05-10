package ui;

import input.KeyboardHandler;
import utils.Constants;
import java.awt.*;

public class Menu {

    private String[] options = {"NEW GAME", "CONTROLS", "QUIT"};
    private int selected = 0;
    private boolean showControls = false;
    private KeyboardHandler keyHandler;
    private boolean upRel = true, downRel = true, enterRel = true;

    public Menu(KeyboardHandler keyHandler) {
        this.keyHandler = keyHandler;
    }

    public String update() {
        if (!keyHandler.up) upRel = true;
        if (!keyHandler.down) downRel = true;
        if (!keyHandler.enter) enterRel = true;

        if (showControls) {
            if (keyHandler.enter && enterRel) { showControls = false; enterRel = false; }
            return "MENU";
        }

        if (keyHandler.up && upRel) { selected = (selected - 1 + options.length) % options.length; upRel = false; }
        if (keyHandler.down && downRel) { selected = (selected + 1) % options.length; downRel = false; }
        if (keyHandler.enter && enterRel) {
            enterRel = false;
            switch (selected) {
                case 0: return "PLAYING";
                case 1: showControls = true; return "MENU";
                case 2: System.exit(0);
            }
        }
        return "MENU";
    }

    public void draw(Graphics2D g) {
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int w = Constants.SCREEN_WIDTH, h = Constants.SCREEN_HEIGHT;

        GradientPaint bg = new GradientPaint(0, 0, new Color(15, 10, 25), 0, h, new Color(35, 20, 50));
        g.setPaint(bg);
        g.fillRect(0, 0, w, h);

        // Ambient particles
        g.setColor(new Color(255, 255, 255, 15));
        for (int i = 0; i < 30; i++) {
            int px = (int)(Math.sin(System.currentTimeMillis() * 0.001 + i * 0.7) * w/2 + w/2);
            int py = (int)(Math.cos(System.currentTimeMillis() * 0.0008 + i * 1.3) * h/2 + h/2);
            g.fillOval(px, py, 3, 3);
        }

        if (showControls) { drawControls(g, w, h); return; }

        // Title
        g.setFont(new Font("SansSerif", Font.BOLD, 52));
        FontMetrics fm = g.getFontMetrics();
        String title = "DUNGEON CRAWLER";
        int tx = (w - fm.stringWidth(title)) / 2;
        g.setColor(new Color(200, 150, 255, 40));
        g.drawString(title, tx + 2, 142);
        g.setPaint(new GradientPaint(tx, 100, new Color(220, 180, 255), tx + fm.stringWidth(title), 140, new Color(150, 100, 220)));
        g.drawString(title, tx, 140);

        g.setFont(new Font("SansSerif", Font.PLAIN, 16));
        g.setColor(new Color(180, 160, 200, 180));
        String sub = "Explore \u2022 Fight \u2022 Survive";
        fm = g.getFontMetrics();
        g.drawString(sub, (w - fm.stringWidth(sub)) / 2, 175);

        // Options
        g.setFont(new Font("SansSerif", Font.BOLD, 28));
        fm = g.getFontMetrics();
        for (int i = 0; i < options.length; i++) {
            int oy = 280 + i * 70;
            int ox = (w - fm.stringWidth(options[i])) / 2;
            if (i == selected) {
                int bw = fm.stringWidth(options[i]) + 40;
                g.setColor(new Color(120, 80, 200, 60));
                g.fillRoundRect((w-bw)/2, oy-30, bw, 45, 12, 12);
                g.setColor(new Color(180, 140, 255));
                g.drawRoundRect((w-bw)/2, oy-30, bw, 45, 12, 12);
                g.setPaint(new GradientPaint(ox, oy-20, new Color(255,220,100), ox+fm.stringWidth(options[i]), oy, new Color(255,180,50)));
                g.drawString(options[i], ox, oy);
                g.setColor(new Color(255, 200, 80));
                g.drawString("\u25B6", ox - 30, oy);
            } else {
                g.setColor(new Color(160, 150, 170));
                g.drawString(options[i], ox, oy);
            }
        }

        g.setFont(new Font("SansSerif", Font.PLAIN, 12));
        g.setColor(new Color(100, 90, 110));
        String ft = "Use arrows to navigate  |  Enter to select";
        fm = g.getFontMetrics();
        g.drawString(ft, (w - fm.stringWidth(ft)) / 2, h - 30);
    }

    private void drawControls(Graphics2D g, int w, int h) {
        g.setColor(new Color(20, 15, 30, 230));
        g.fillRoundRect(w/6, 60, w*2/3, h-120, 20, 20);
        g.setColor(new Color(120, 100, 160));
        g.drawRoundRect(w/6, 60, w*2/3, h-120, 20, 20);

        g.setFont(new Font("SansSerif", Font.BOLD, 30));
        g.setColor(new Color(220, 200, 255));
        FontMetrics fm = g.getFontMetrics();
        g.drawString("CONTROLS", (w - fm.stringWidth("CONTROLS")) / 2, 110);

        g.setFont(new Font("Monospaced", Font.PLAIN, 18));
        g.setColor(new Color(200, 190, 210));
        String[] c = {"W/Up    Move Up","S/Down  Move Down","A/Left  Move Left","D/Right Move Right",
            "SPACE   Attack","E       Interact","I       Inventory","1-9     Use Item","ESC     Pause",
            "","Press ENTER to go back"};
        for (int i = 0; i < c.length; i++) g.drawString(c[i], w/4, 160 + i * 32);
    }

    public void reset() { selected = 0; showControls = false; }
}
