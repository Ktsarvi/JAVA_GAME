package entities;

import items.Item;
import java.util.ArrayList;

public class Chest {
    private ArrayList<Item> items;  // List of consistency in chest
    private boolean broken;  // 

    public Chest() {
        items = new ArrayList<Item>();
        broken = false;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public ArrayList<Item> breakChest() {
        if(broken) {
            return null;
        }
        broken = true;
        return items;
    }

    public boolean isBroked() {  // If it returns true EntityManager must delete this object
        return broken;
    }
}
