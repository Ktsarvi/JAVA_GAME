# 🎮 Java Dungeon Game

A 2D dungeon crawler game built with Java. Navigate through procedurally structured dungeons, battle enemies, collect items, and find your way to freedom.

---

## 📖 Table of Contents

- [About](#about)
- [Features](#features)
- [Project Structure](#project-structure)
- [Class Overview](#class-overview)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Controls](#controls)

---

## About

Java Dungeon Game is a tile-based dungeon crawler where the player explores rooms, fights enemies, loots chests, and manages an inventory of items such as keys and crowbars. The game features a heads-up display (HUD), an inventory UI, and a main menu — all built on top of a Java Swing `GamePanel`.

---

## Features

- 🗺️ **Dungeon exploration** — move between interconnected rooms inside a dungeon
- ⚔️ **Combat system** — attack enemies and take damage with HP/strength mechanics
- 🧟 **Enemy AI** — enemies detect and chase the player within aggro range
- 🎒 **Inventory system** — collect and manage items (keys, crowbars, food) with slot limits
- 🔑 **Doors & Chests** — unlock doors with keys and break chests with crowbars for loot
- 🍖 **Food & Healing** — pick up food to restore health (apples, cakes, potions)
- 💀 **Respawn & Checkpoints** — player respawns at their spawn point; achievements act as checkpoints
- 🏆 **Achievement System** — unlock achievements based on world triggers and progress
- 🖥️ **HUD** — on-screen display showing player stats
- 🎵 **Sound & Sprites** — audio effects and sprite-based graphics
- ⌨️ **Keyboard input** — responsive keyboard-driven controls

---

## Project Structure

```
├── entities/
│   ├── Entity.java           # Abstract base — position, size, sprite, collision, active flag
│   ├── LivingBeing.java      # Abstract — HP, strength, speed, movement, attack, damage
│   ├── Player.java           # Player — input handling, respawn, inventory, interactions
│   ├── Enemy.java            # Enemy — AI aggression, chase, loot drops
│   ├── Chest.java            # Loot container — stores items, implements Activatable
│   ├── Door.java             # Door — locked/unlocked state, key-based unlock
│   ├── Barrel.java           # Barrel — implements Activatable, can be broken
│   ├── Achievement.java      # Checkpoint — updates spawn point on collision
│   └── Activatable.java      # Interface — defines activate() and isActivated()
│
├── items/
│   ├── Item.java             # Abstract base — name, icon, use(), consumable flag
│   ├── Food.java             # Abstract food — heal amount, speed boost
│   ├── Apple.java            # Small heal (+5 HP)
│   ├── Cake.java             # Medium heal (+25 HP)
│   ├── Potion.java           # Large heal (+50 HP) + speed boost
│   ├── Key.java              # Unlocks matching doors by ID
│   ├── Crowbar.java          # Breaks chests
│   └── Lock.java             # Lock mechanism — key-based unlock/lock logic
│
├── world/
│   ├── Room.java             # Single room — items, living beings, doors, draw/update
│   └── World.java            # Game world — entities, executables, room transitions, step()
│
├── managers/
│   ├── Inventory.java        # Slot-based inventory — add/remove/has/get items
│   ├── AchievementManager.java # Tracks progress, notifies on unlock
│   └── Executable.java       # Interface — defines execute() for logic/actions
│
└── README.md
```

### Planned (not yet implemented)

```
├── main/
│   ├── Main.java             # Entry point
│   ├── GamePanel.java        # Core game loop, update/render
│   └── GameState.java        # Enum: MENU, PLAYING, PAUSED, GAME_OVER
│
├── world/
│   ├── Dungeon.java          # Collection of rooms, map generation
│   └── TileManager.java      # Tile map loading and rendering
│
├── ui/
│   ├── Menu.java             # Main menu UI
│   ├── HUD.java              # In-game health bar, key count
│   └── InventoryUI.java      # Inventory grid display
│
├── input/
│   └── KeyboardHandler.java  # Keyboard input states
│
├── managers/
│   ├── EntityManager.java    # Entity update/render loop
│   └── CollisionManager.java # Collision detection
│
├── graphics/
│   ├── SpriteLoader.java     # Image loading
│   ├── Animator.java         # Sprite animation frames
│   └── Assets.java           # Loaded sprite storage
│
├── utils/
│   └── Constants.java        # Screen size, FPS, tile size
│
└── resources/
    ├── sprites/              # Character, item, tile, UI images
    └── sounds/               # Music and SFX
```

---

## Class Overview

### Inheritance Hierarchy

```
Entity (abstract)
└── LivingBeing (abstract)
    ├── Player
    └── Enemy

Item (abstract)
├── Food (abstract)
│   ├── Apple
│   ├── Cake
│   └── Potion
├── Key
└── Crowbar

Entity
├── Chest (implements Activatable)
├── Door
├── Barrel (implements Activatable)
└── Achievement (implements Executable)

Interfaces
├── Activatable (entities)
└── Executable (managers)
```

### Key Relationships

| Class | Uses |
|-------|------|
| `Player` | `Inventory`, `Food`, `Key`, `Door`, `Chest`, `Crowbar` |
| `Enemy` | `Item` (loot drops), `Player` (chase target) |
| `Inventory` | `Item` (slot storage) |
| `Room` | `Entity`, `Door` (contains items, beings, doors) |
| `World` | `Room`, `Entity` (manages current room and entities) |
| `Door` | `Key` (unlock by matching ID) |
| `Chest` | `Item` (stores loot), `Activatable` |
| `Barrel` | `Activatable` |
| `Achievement`| `Player` (for checkpoint), `Executable` |
| `AchievementManager` | `Achievement` (manages all unlocks) |
| `Lock` | String key ID (standalone lock mechanism) |

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
