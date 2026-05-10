package managers;

import entities.Entity;
import entities.Enemy;
import entities.Bullet;
import items.Item;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class EntityManager {

    private CopyOnWriteArrayList<Entity> entities;
    private List<Entity> toAdd;

    public EntityManager() {
        entities = new CopyOnWriteArrayList<>();
        toAdd = new ArrayList<>();
    }

    public void update() {
        // Add pending entities
        entities.addAll(toAdd);
        toAdd.clear();

        // Update all, collect inactive for removal
        List<Entity> toRemove = new ArrayList<>();
        for (Entity e : entities) {
            e.update();
            if (!e.isActive()) {
                toRemove.add(e);
            }
        }
        entities.removeAll(toRemove);
    }

    public void draw(Graphics2D g) {
        for (Entity e : entities) {
            e.draw(g);
        }
    }

    public void addEntity(Entity e) {
        toAdd.add(e);
    }

    public void removeEntity(Entity e) {
        e.setActive(false);
    }

    public List<Entity> getEntities() {
        return new ArrayList<>(entities);
    }

    public void clear() {
        entities.clear();
        toAdd.clear();
    }

    public <T> List<T> getEntitiesOfType(Class<T> type) {
        List<T> result = new ArrayList<>();
        for (Entity e : entities) {
            if (type.isInstance(e)) {
                result.add(type.cast(e));
            }
        }
        return result;
    }
}
