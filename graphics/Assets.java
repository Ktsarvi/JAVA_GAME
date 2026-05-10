package graphics;

import java.awt.image.BufferedImage;

public class Assets {

    // Entities
    public static BufferedImage player;
    public static BufferedImage enemy;
    public static BufferedImage boss;
    public static BufferedImage chest;
    public static BufferedImage chestOpen;
    public static BufferedImage barrel;
    public static BufferedImage barrelBroken;
    public static BufferedImage doorLocked;
    public static BufferedImage doorOpen;
    public static BufferedImage achievement;
    public static BufferedImage bullet;

    // Items (icons)
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
        player       = SpriteLoader.load("resources/sprites/player.png");
        enemy        = SpriteLoader.load("resources/sprites/enemy.png");
        boss         = SpriteLoader.load("resources/sprites/boss.png");
        chest        = SpriteLoader.load("resources/sprites/chest.png");
        chestOpen    = SpriteLoader.load("resources/sprites/chest_open.png");
        barrel       = SpriteLoader.load("resources/sprites/barrel.png");
        barrelBroken = SpriteLoader.load("resources/sprites/barrel_broken.png");
        doorLocked   = SpriteLoader.load("resources/sprites/door_locked.png");
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
