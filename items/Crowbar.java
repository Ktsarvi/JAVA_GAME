package items;

import graphics.Assets;

public class Crowbar extends Item {
    public Crowbar() {
        super("Crowbar");
        this.icon = Assets.crowbarIcon;
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
