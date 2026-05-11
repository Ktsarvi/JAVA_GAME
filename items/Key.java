package items;

import graphics.Assets;

public class Key extends Item {

    private int keyId; // must match Door keyId

    public Key(int keyId) {
        super("Key");
        this.keyId = keyId;
        this.icon = Assets.keyIcon;
    }

    @Override
    public void use() {
        // Sound of using it 
    }

    // Getters
    public int getId() {
        return keyId;
    }
}
