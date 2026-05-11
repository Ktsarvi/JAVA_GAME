package world;

import entities.Door;
import entities.Entity;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Room {

    private String id;
    public int x, y, width, height;

    private List<Entity> items;
    private List<Entity> livingBeings;
    private List<Door> doors;

    public Room(String id, int x, int y, int width, int height) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.items = new ArrayList<>();
        this.livingBeings = new ArrayList<>();
        this.doors = new ArrayList<>();
    }

    public void update() {
        for (Door d : doors) d.update();
        for (Entity e : items) e.update();
        for (Entity e : livingBeings) e.update();
    }

    public void draw(Graphics2D g) {
        // Floor
        g.setColor(new Color(60, 50, 40));
        g.fillRect(x, y, width, height);

        // Walls
        g.setColor(new Color(30, 20, 10));
        g.setStroke(new BasicStroke(4));
        g.drawRect(x, y, width, height);

        for (Door d : doors)          d.draw(g);
        for (Entity e : items)        e.draw(g);
        for (Entity e : livingBeings) e.draw(g);
    }

    public List<Entity> getAllEntities() {
        List<Entity> all = new ArrayList<>();
        all.addAll(items);
        all.addAll(livingBeings);
        all.addAll(doors);
        return all;
    }

    // Items
    public void addItem(Entity item) {
        items.add(item); 
    }

    public void removeItem(Entity item) {
        items.remove(item); 
    }

    public List<Entity> getItems() {
        return items;
    }

    // Living beings
    public void addLivingBeing(Entity lb) {
        livingBeings.add(lb);
    }

    public void removeLivingBeing(Entity lb) {
        livingBeings.remove(lb);
    }

    public List<Entity> getLivingBeings() {
        return livingBeings;
    }

    // Doors
    public void addDoor(Door door) { 
        doors.add(door); 
    }

    public void removeDoor(Door door) { 
        doors.remove(door); 
    }

    public List<Door> getDoors() { 
        return doors; 
    }

    public String getId() {
        return id; 
    }

    public int getX() {
        return x; 
    }

    public int getY() { 
        return y; 
    }
}
