package entities;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public abstract class Entity {  

    
    
    protected int x, y;
    protected int width, height;
    protected BufferedImage sprite;  
    protected boolean active = true; 

    
    public Entity(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public abstract void update();  
    public abstract void draw(Graphics2D g2);  

    
    public boolean collidesWith(Entity other) {
        return x < other.x + other.width
            && x + width > other.x
            && y < other.y + other.height
            && y + height > other.y;
    }

    public boolean isActive() { return active; }  

    
    public void setActive(boolean active) { this.active = active; }

    public void setSprite(BufferedImage sprite) { this.sprite = sprite; }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    
    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
}
