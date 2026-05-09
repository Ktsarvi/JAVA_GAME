package world;

import entities.Entity;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class World {

    private List<Entity> entities;
    private List<Runnable> executables;
    private Room currentRoom;

    public World() {
        entities = new ArrayList<>();
        executables = new ArrayList<>();
    }

    public void step() {
        for (Entity e : entities) e.update();
        for (Runnable r : executables) r.run();
    }

    public void render(Graphics2D g) {
        if (currentRoom != null) currentRoom.draw(g);
        for (Entity e : entities) e.draw(g);
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
        entities.clear();
        entities.addAll(room.getAllEntities());
    }

    public Room getCurrentRoom(){
        return currentRoom; 
    }

    public void addEntity(Entity e){
        entities.add(e); 
    }

    public void removeEntity(Entity e){
        entities.remove(e);
    }

    public List<Entity> getEntities(){
        return entities; 
    }

    public void addExecutable(Runnable r){
        executables.add(r);
    }

    public void removeExecutable(Runnable r){
        executables.remove(r);
    }
}