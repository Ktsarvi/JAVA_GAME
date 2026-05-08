# 🎮 Java Dungeon Game

A 2D dungeon crawler game built with Java. Navigate through procedurally structured dungeons, battle enemies, collect items, and find your way to freedom.

---

## 📖 Table of Contents

- [About](#about)
- [Features](#features)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Controls](#controls)

---

## About

Java Dungeon Game is a tile-based dungeon crawler where the player explores rooms, fights enemies, loots chests, and manages an inventory of items such as keys and crowbars. The game features a heads-up display (HUD), an inventory UI, and a main menu — all built on top of a Java Swing `GamePanel`.

---

## Features

- 🗺️ **Dungeon exploration** — move between interconnected rooms inside a dungeon
- ⚔️ **Enemies** — encounter and defeat enemies that roam the dungeon
- 🎒 **Inventory system** — collect and manage items (keys, crowbars, food)
- 🔑 **Doors & Chests** — unlock doors with keys and open chests for loot
- 🍖 **Food** — pick up food to restore health
- 🖥️ **HUD** — on-screen display showing player stats
- 🎵 **Sound & Sprites** — audio effects and sprite-based graphics
- ⌨️ **Keyboard input** — responsive keyboard-driven controls

---

## Project Structure

```
src/
│
├── main/
│   ├── Main.java             # Entry point — starts the game window and initializes everything
│   ├── GamePanel.java        # Core game loop, update() and paintComponent() for rendering
│   └── GameState.java        # Enum for game states: MENU, PLAYING, PAUSED, GAME_OVER
│
├── entities/
│   ├── Entity.java           # Base class — position, size, sprite, basic update/draw logic
│   ├── Player.java           # Player controls, movement, interaction, inventory access
│   ├── Enemy.java            # Enemy AI, movement patterns, attack logic
│   ├── Chest.java            # Loot container — stores items, can be opened/broken
│   └── Door.java             # Door logic — locked/unlocked state, interaction with keys
│
├── items/
│   ├── Item.java             # Base item class — name, icon (sprite), use() method
│   ├── Food.java             # Abstract food item — healing logic
│   ├── Apple.java            # Small heal item (+HP)
│   ├── Cake.java             # Medium heal item (+HP)
│   ├── Potion.java           # Special heal item + effects
│   ├── Key.java              # Used to unlock doors
│   └── Crowbar.java          # Used to break chests or force interactions
│
├── world/
│   ├── Room.java             # Single room — tile grid, entities, exits/doors
│   ├── Dungeon.java          # Collection of rooms — manages map generation and transitions
│   └── TileManager.java      # Loads and renders tile map (floor, walls, obstacles)
│
├── ui/
│   ├── Menu.java             # Main menu UI — buttons, start/exit options
│   ├── HUD.java              # In-game UI — health bar, items, key count
│   └── InventoryUI.java      # Inventory screen — displays items in grid layout
│
├── input/
│   └── KeyboardHandler.java  # Handles keyboard input — key states and actions
│
├── managers/
│   ├── EntityManager.java    # Manages all entities — update and render loop
│   ├── CollisionManager.java # Handles collisions between entities and tiles
│   └── Inventory.java        # Player inventory system — add/remove items, slots
│
├── graphics/
│   ├── SpriteLoader.java     # Loads images from resources folder
│   ├── Animator.java         # Handles sprite animations (frame switching)
│   └── Assets.java           # Stores all loaded sprites in memory for easy access
│
├── utils/
│   └── Constants.java        # Game constants — screen size, FPS, tile size, etc.
│
└── resources/
    ├── sprites/              # All game images (characters, items, tiles, UI)
    │   ├── player/
    │   ├── enemy/
    │   ├── items/
    │   ├── tiles/
    │   ├── doors/
    │   └── chests/
    │
    └── sounds/               # Game audio files
        ├── music/
        └── sfx/
```

---

## Prerequisites

- **Java 17** or higher ([Download](https://adoptium.net/))
- A Java IDE such as [IntelliJ IDEA](https://www.jetbrains.com/idea/) or [Eclipse](https://www.eclipse.org/), or the JDK command-line tools

---

## Getting Started

### Compile

```bash
javac -d out -sourcepath src src/main/Main.java
```

### Run

```bash
java -cp out main.Main
```

> **Tip:** If you are using an IDE, simply import the project, set `Main.java` as the run configuration entry point, and hit **Run**.

---

## Controls

| Key | Action |
|-----|--------|
| `W` / `↑` | Move up |
| `S` / `↓` | Move down |
| `A` / `←` | Move left |
| `D` / `→` | Move right |
| `E` | Interact (open door / chest) |
| `I` | Toggle inventory |
| `Esc` | Pause / open menu |
