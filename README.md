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
│   ├── Main.java             # Entry point — launches the game window
│   ├── GamePanel.java        # Core game loop and rendering
│   └── GameState.java        # Manages active game states (menu, playing, etc.)
│
├── entities/
│   ├── Entity.java           # Base class for all game entities
│   ├── Player.java           # Player character logic and movement
│   ├── Enemy.java            # Enemy behaviour and AI
│   ├── Chest.java            # Lootable chest entity
│   ├── Door.java             # Door entity (requires key to open)
│   └── Food.java             # Food pickup entity
│
├── world/
│   ├── Room.java             # Individual dungeon room
│   ├── Dungeon.java          # Dungeon layout and room management
│   └── TileManager.java      # Loads and renders tile maps
│
├── items/
│   ├── Item.java             # Base class for all items
│   ├── Key.java              # Key item (opens doors)
│   ├── Crowbar.java          # Crowbar item (forces open chests)
│   └── Inventory.java        # Player inventory logic
│
├── ui/
│   ├── Menu.java             # Main menu screen
│   ├── HUD.java              # Heads-up display (health, stats)
│   └── InventoryUI.java      # In-game inventory overlay
│
├── input/
│   └── KeyboardHandler.java  # Captures and processes keyboard input
│
├── managers/
│   ├── CollisionManager.java # Handles entity-tile and entity-entity collisions
│   └── EntityManager.java    # Tracks and updates all active entities
│
├── utils/
│   └── Constants.java        # Shared constants (tile size, screen dimensions, etc.)
│
└── assets/
    ├── sprites/              # Sprite sheets and images
    └── sounds/               # Sound effects and music
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
