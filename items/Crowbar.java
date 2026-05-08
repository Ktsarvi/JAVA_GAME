package items;

import entities.Player;

public class Crowbar extends Item {
    public Crowbar() {
        super("Crowbar");
    }

    /**
     * Using of Crowbar
     * It can:
     * - break chests
     */
  
    @Override
    public void use() {
        // Only sounds of using it (NO game logic here)
    }
}
