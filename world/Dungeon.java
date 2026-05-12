package world;

import entities.*;
import items.*;
import utils.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dungeon {

    private List<Room> rooms;
    private Map<String, TileManager> tileMaps;
    private Map<String, Room> roomById;
    private Player player;

    public Dungeon(Player player) {
        this.player = player;
        this.rooms = new ArrayList<>();
        this.tileMaps = new HashMap<>();
        this.roomById = new HashMap<>();
        buildDungeon();
    }

    private void buildDungeon() {
        
        Room room1 = new Room("room1", 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        TileManager tm1 = new TileManager(Constants.SCREEN_COLS, Constants.SCREEN_ROWS);
        
        tm1.setTile(5, 4, TileManager.WALL);
        tm1.setTile(5, 5, TileManager.WALL);
        tm1.setTile(10, 7, TileManager.WALL);
        tm1.setTile(10, 8, TileManager.WALL);

        
        Chest chest1 = new Chest(300, 200, 44, 44);
        chest1.addItem(new Key(1));
        chest1.addItem(new Apple());
        room1.addItem(chest1);

        Barrel barrel1 = new Barrel(500, 350, 40, 40);
        barrel1.addItem(new Apple());
        room1.addItem(barrel1);

        
        Enemy e1 = new Enemy(400, 300, 44, 44, 20, 5, 1, 150);
        e1.setTarget(player);
        e1.addLoot(new Crowbar());
        room1.addLivingBeing(e1);

        
        Achievement ach1 = new Achievement(100, 500, 40, 40, "First Steps", "Enter the dungeon", player, "room1");
        room1.addItem(ach1);

        
        Door door1to2 = new Door(Constants.SCREEN_WIDTH - 48, Constants.SCREEN_HEIGHT / 2 - 22, 44, 44, true, 1);
        door1to2.setTarget("room2", 60, Constants.SCREEN_HEIGHT / 2 - 22);
        room1.addDoor(door1to2);
        
        tm1.setTile(Constants.SCREEN_COLS - 1, 5, TileManager.FLOOR);
        tm1.setTile(Constants.SCREEN_COLS - 1, 6, TileManager.FLOOR);

        addRoom(room1, tm1);

        
        Room room2 = new Room("room2", 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        TileManager tm2 = new TileManager(Constants.SCREEN_COLS, Constants.SCREEN_ROWS);
        
        for (int c = 3; c < 13; c++) {
            tm2.setTile(c, 3, TileManager.WALL);
            tm2.setTile(c, 8, TileManager.WALL);
        }
        
        tm2.setTile(8, 3, TileManager.FLOOR);
        tm2.setTile(8, 8, TileManager.FLOOR);

        
        Enemy e2a = new Enemy(300, 250, 44, 44, 30, 7, 2, 180);
        e2a.setTarget(player);
        e2a.addLoot(new Apple());
        room2.addLivingBeing(e2a);

        Enemy e2b = new Enemy(500, 320, 44, 44, 30, 7, 2, 180);
        e2b.setTarget(player);
        e2b.addLoot(new Cake());
        room2.addLivingBeing(e2b);

        
        Chest chest2 = new Chest(650, 250, 44, 44);
        chest2.addItem(new Key(2));
        chest2.addItem(new Potion());
        room2.addItem(chest2);

        Achievement ach2 = new Achievement(350, 500, 40, 40, "Corridor Cleared", "Survive the corridor", player, "room2");
        room2.addItem(ach2);

        
        Door door2to3 = new Door(Constants.SCREEN_WIDTH - 48, Constants.SCREEN_HEIGHT / 2 - 22, 44, 44, true, 2);
        door2to3.setTarget("room3", 60, Constants.SCREEN_HEIGHT / 2 - 22);
        room2.addDoor(door2to3);
        
        tm2.setTile(Constants.SCREEN_COLS - 1, 5, TileManager.FLOOR);
        tm2.setTile(Constants.SCREEN_COLS - 1, 6, TileManager.FLOOR);

        addRoom(room2, tm2);

        
        Room room3 = new Room("room3", 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        TileManager tm3 = new TileManager(Constants.SCREEN_COLS, Constants.SCREEN_ROWS);
        
        tm3.setTile(4, 4, TileManager.WALL);
        tm3.setTile(4, 7, TileManager.WALL);
        tm3.setTile(11, 4, TileManager.WALL);
        tm3.setTile(11, 7, TileManager.WALL);
        tm3.setTile(7, 5, TileManager.WALL);
        tm3.setTile(8, 5, TileManager.WALL);

        
        Chest chest3 = new Chest(380, 280, 44, 44);
        chest3.addItem(new Gun());
        chest3.addItem(new Cake());
        room3.addItem(chest3);

        Barrel barrel3a = new Barrel(200, 150, 40, 40);
        barrel3a.addItem(new Apple());
        room3.addItem(barrel3a);

        Barrel barrel3b = new Barrel(600, 400, 40, 40);
        barrel3b.addItem(new Potion());
        room3.addItem(barrel3b);

        
        Enemy e3 = new Enemy(450, 200, 44, 44, 50, 10, 2, 200);
        e3.setTarget(player);
        e3.addLoot(new Key(3));
        room3.addLivingBeing(e3);

        Achievement ach3 = new Achievement(400, 500, 40, 40, "Armed Up", "Find the gun", player, "room3");
        room3.addItem(ach3);

        Door door3to4 = new Door(Constants.SCREEN_WIDTH - 48, Constants.SCREEN_HEIGHT / 2 - 22, 44, 44, true, 3);
        door3to4.setTarget("room4", 60, Constants.SCREEN_HEIGHT / 2 - 22);
        room3.addDoor(door3to4);
        
        tm3.setTile(Constants.SCREEN_COLS - 1, 5, TileManager.FLOOR);
        tm3.setTile(Constants.SCREEN_COLS - 1, 6, TileManager.FLOOR);

        addRoom(room3, tm3);

        
        Room room4 = new Room("room4", 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        TileManager tm4 = new TileManager(Constants.SCREEN_COLS, Constants.SCREEN_ROWS);
        
        for (int r = 2; r < 6; r++) tm4.setTile(4, r, TileManager.WALL);
        for (int r = 6; r < 10; r++) tm4.setTile(8, r, TileManager.WALL);
        for (int r = 2; r < 6; r++) tm4.setTile(12, r, TileManager.WALL);

        
        Enemy e4a = new Enemy(250, 200, 44, 44, 60, 12, 2, 200);
        e4a.setTarget(player);
        room4.addLivingBeing(e4a);

        Enemy e4b = new Enemy(450, 350, 44, 44, 60, 12, 2, 200);
        e4b.setTarget(player);
        e4b.addLoot(new Cake());
        room4.addLivingBeing(e4b);

        Enemy e4c = new Enemy(500, 150, 44, 44, 40, 8, 3, 250);
        e4c.setTarget(player);
        e4c.addLoot(new Key(4));
        room4.addLivingBeing(e4c);

        
        Chest chest4 = new Chest(150, 450, 44, 44);
        chest4.addItem(new Potion());
        chest4.addItem(new Potion());
        room4.addItem(chest4);

        Achievement ach4 = new Achievement(350, 500, 40, 40, "Gauntlet Runner", "Survive the gauntlet", player, "room4");
        room4.addItem(ach4);

        Door door4to5 = new Door(Constants.SCREEN_WIDTH - 48, Constants.SCREEN_HEIGHT / 2 - 22, 44, 44, true, 4);
        door4to5.setTarget("room5", 60, Constants.SCREEN_HEIGHT / 2 - 22);
        room4.addDoor(door4to5);
        
        tm4.setTile(Constants.SCREEN_COLS - 1, 5, TileManager.FLOOR);
        tm4.setTile(Constants.SCREEN_COLS - 1, 6, TileManager.FLOOR);

        addRoom(room4, tm4);

        
        Room room5 = new Room("room5", 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        TileManager tm5 = new TileManager(Constants.SCREEN_COLS, Constants.SCREEN_ROWS);
        
        tm5.setTile(4, 3, TileManager.WALL);
        tm5.setTile(4, 8, TileManager.WALL);
        tm5.setTile(11, 3, TileManager.WALL);
        tm5.setTile(11, 8, TileManager.WALL);

        
        Enemy boss = new Enemy(350, 200, 64, 64, 150, 15, 1, 400);
        boss.setBoss(true);
        boss.setTarget(player);
        boss.addLoot(new Potion());
        room5.addLivingBeing(boss);

        
        Enemy minion1 = new Enemy(200, 350, 40, 40, 30, 8, 2, 200);
        minion1.setTarget(player);
        room5.addLivingBeing(minion1);

        Enemy minion2 = new Enemy(550, 350, 40, 40, 30, 8, 2, 200);
        minion2.setTarget(player);
        room5.addLivingBeing(minion2);

        
        Barrel bossBarrel = new Barrel(100, 100, 40, 40);
        bossBarrel.addItem(new Potion());
        bossBarrel.addItem(new Cake());
        room5.addItem(bossBarrel);

        addRoom(room5, tm5);
    }

    private void addRoom(Room room, TileManager tm) {
        rooms.add(room);
        tileMaps.put(room.getId(), tm);
        roomById.put(room.getId(), room);
    }

    public Room getRoom(String id) {
        return roomById.get(id);
    }

    public Room getStartRoom() {
        return rooms.get(0);
    }

    public TileManager getTileManager(String roomId) {
        return tileMaps.get(roomId);
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public int getRoomCount() {
        return rooms.size();
    }
}
