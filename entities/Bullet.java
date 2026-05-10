package entities;

import graphics.Assets;
import utils.Constants;
import java.awt.Color;
import java.awt.Graphics2D;

public class Bullet extends Entity {

    private int dx, dy;
    private int damage;

    public Bullet(int x, int y, int dx, int dy) {
        super(x, y, Constants.BULLET_SIZE, Constants.BULLET_SIZE);
        this.dx = dx;
        this.dy = dy;
        this.damage = Constants.BULLET_DAMAGE;
        this.sprite = Assets.bullet;
    }

    @Override
    public void update() {
        x += dx;
        y += dy;

        // Deactivate if out of screen bounds
        if (x < -50 || x > Constants.SCREEN_WIDTH + 50
                || y < -50 || y > Constants.SCREEN_HEIGHT + 50) {
            active = false;
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        if (sprite != null) {
            g2.drawImage(sprite, x, y, width, height, null);
        } else {
            g2.setColor(new Color(255, 200, 50));
            g2.fillOval(x, y, width, height);
            g2.setColor(new Color(255, 100, 0));
            g2.drawOval(x, y, width, height);
        }
    }

    public int getDamage() { return damage; }
}
