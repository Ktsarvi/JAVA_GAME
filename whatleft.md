Based on the task division and README:

### Person 3 — Items (missing)

| Class          | What it does                                   |
| -------------- | ---------------------------------------------- |
| `Gun`          | New item type                                  |
| `Barrel`       | Implements `Activatable`, stores items         |
| Wiring `use()` | Actual logic inside each item's `use()` method |

### Engine / Shared (missing — not assigned to any person)

| Class                   | What it does                     |
| ----------------------- | -------------------------------- |
| `Main.java`             | Entry point                      |
| `GamePanel.java`        | Game loop, update/render         |
| `GameState.java`        | MENU, PLAYING, PAUSED, GAME_OVER |
| `Dungeon.java`          | Room collection, map generation  |
| `TileManager.java`      | Tile loading and rendering       |
| `Menu.java`             | Main menu UI                     |
| `HUD.java`              | Health bar, key count            |
| `InventoryUI.java`      | Inventory grid display           |
| `KeyboardHandler.java`  | Keyboard input                   |
| `EntityManager.java`    | Entity update/render loop        |
| `CollisionManager.java` | Collision detection              |
| `SpriteLoader.java`     | Image loading                    |
| `Animator.java`         | Sprite animation                 |
| `Assets.java`           | Sprite storage                   |
| `Constants.java`        | Screen size, FPS, tile size      |
| `resources/`            | Sprites + sounds                 |

# Directory Structure

```
resources/
├── sprites/
│   ├── boss.png          (64×64 or 96×96) teymur
└── sounds/               (optional)
    ├── attack.wav
    ├── pickup.wav
    ├── door_open.wav
    └── game_over.wav
```

# Important

take walls and floor from punyworld-tileset because our wall and floor sprites are not matching with each other
or
take walls and floor from dungeon-tiles, take also door and open (broken) door png
take player and enemies from spritesheet.png
