package items;

public class Key extends Item {

    private int keyId; // must match Door keyId

    public Key(int keyId) {
        super("Key");
        this.keyId = keyId;
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
