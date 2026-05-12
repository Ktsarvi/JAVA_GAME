package entities;

import graphics.Assets;
import utils.Constants;
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

        
        if (x < -50 || x > Constants.SCREEN_WIDTH + 50
                || y < -50 || y > Constants.SCREEN_HEIGHT + 50) {
            active = false;
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        if (sprite != null) {
            g2.drawImage(sprite, x, y, width, height, null);
        }
    }

    public int getDamage() { return damage; }
}
