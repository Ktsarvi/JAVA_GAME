package utils;

public class Constants {

    // Screen
    public static final int TILE_SIZE = 48;
    public static final int SCREEN_COLS = 16;
    public static final int SCREEN_ROWS = 12;
    public static final int SCREEN_WIDTH = TILE_SIZE * SCREEN_COLS;   // 768
    public static final int SCREEN_HEIGHT = TILE_SIZE * SCREEN_ROWS;  // 576

    // Game loop
    public static final int FPS = 60;

    // Player defaults
    public static final int PLAYER_HP = 100;
    public static final int PLAYER_STRENGTH = 10;
    public static final int PLAYER_SPEED = 4;
    public static final int PLAYER_SIZE = 44;
    public static final int INVENTORY_SLOTS = 10;

    // Enemy defaults
    public static final int ENEMY_AGGRO_RANGE = 200;

    // Attack
    public static final int ATTACK_COOLDOWN = 30;  // frames
    public static final int ATTACK_RANGE = 50;

    // Bullet
    public static final int BULLET_SPEED = 8;
    public static final int BULLET_SIZE = 10;
    public static final int BULLET_DAMAGE = 15;
    public static final int GUN_COOLDOWN = 20;  // frames
}
