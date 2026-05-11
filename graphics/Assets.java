package graphics;

import java.awt.image.BufferedImage;

public class Assets {

    // Entities
    public static BufferedImage player;
    public static BufferedImage[] playerWalkFrames;
    public static BufferedImage enemy;
    public static BufferedImage boss;
    public static BufferedImage chest;
    public static BufferedImage chestOpen;
    public static BufferedImage barrel;
    public static BufferedImage barrelBroken;
    public static BufferedImage doorClosed;
    public static BufferedImage doorOpen;
    public static BufferedImage achievement;
    public static BufferedImage bullet;

    // Items (icons for inventory)
    public static BufferedImage keyIcon;
    public static BufferedImage appleIcon;
    public static BufferedImage cakeIcon;
    public static BufferedImage potionIcon;
    public static BufferedImage crowbarIcon;
    public static BufferedImage gunIcon;

    // Tiles
    public static BufferedImage floorTile;
    public static BufferedImage wallTile;

    public static void load() {
        // Player — strip has 4 walk frames (64x32), each frame is 16x32
        playerWalkFrames = SpriteLoader.loadSpriteSheet(
            "resources/sprites/player.png", 16, 32
        );
        if (playerWalkFrames != null && playerWalkFrames.length > 0) {
            player = playerWalkFrames[0]; // default standing frame
        }

        // Enemy — use first frame from south-facing walk strip (16x24 per frame)
        BufferedImage[] enemyFrames = SpriteLoader.loadSpriteSheet(
            "resources/sprites/enemy_Soldier_WALK_SOUTH_strip4.png", 16, 24
        );
        if (enemyFrames != null && enemyFrames.length > 0) {
            enemy = enemyFrames[0];
        }

        boss         = SpriteLoader.load("resources/sprites/boss.png");
        chest        = SpriteLoader.load("resources/sprites/chest.png");
        chestOpen    = SpriteLoader.load("resources/sprites/chest_open.png");
        barrel       = SpriteLoader.load("resources/sprites/barrel.png");
        barrelBroken = SpriteLoader.load("resources/sprites/barrel_broken.png");
        doorClosed   = SpriteLoader.load("resources/sprites/door_closed.png");
        doorOpen     = SpriteLoader.load("resources/sprites/door_open.png");
        achievement  = SpriteLoader.load("resources/sprites/achievement.png");
        bullet       = SpriteLoader.load("resources/sprites/bullet.png");

        keyIcon      = SpriteLoader.load("resources/sprites/key.png");
        appleIcon    = SpriteLoader.load("resources/sprites/apple.png");
        cakeIcon     = SpriteLoader.load("resources/sprites/cake.png");
        potionIcon   = SpriteLoader.load("resources/sprites/potion.png");
        crowbarIcon  = SpriteLoader.load("resources/sprites/crowbar.png");
        gunIcon      = SpriteLoader.load("resources/sprites/gun.png");

        floorTile    = SpriteLoader.load("resources/sprites/floor.png");
        wallTile     = SpriteLoader.load("resources/sprites/wall.png");
    }
}
