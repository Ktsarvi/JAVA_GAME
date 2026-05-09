package managers;

import items.Item;
import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<Item> slots;
    private int maxSlots;

    public Inventory(int maxSlots) {
        this.maxSlots = maxSlots;
        this.slots = new ArrayList<>();
    }

    public boolean add(Item item) {
        if (slots.size() >= maxSlots) return false;
        slots.add(item);
        return true;
    }

    public void remove(Item item) {
        slots.remove(item);
    }

    public boolean has(String itemName) {
        for (Item item : slots) {
            if (item.getName().equals(itemName)) return true;
        }
        return false;
    }

    public Item get(String itemName) {
        for (Item item : slots) {
            if (item.getName().equals(itemName)) return item;
        }
        return null;
    }

    public List<Item> getSlots() { return slots; }
    public int getMaxSlots() { return maxSlots; }
    public boolean isFull() { return slots.size() >= maxSlots; }
}
