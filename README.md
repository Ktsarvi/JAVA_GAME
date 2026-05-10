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
- [Resources](#resources)

---

## About

Java Dungeon Game is a tile-based dungeon crawler where the player explores rooms, fights enemies, loots chests, and manages an inventory of items such as keys and crowbars. The game features a heads-up display (HUD), an inventory UI, and a main menu — all built on top of a Java Swing `GamePanel`.

---

## Features

- 🗺️ **Dungeon exploration** — move between interconnected rooms inside a dungeon
- ⚔️ **Combat system** — melee attacks and ranged gun combat with HP/strength mechanics
- 🧟 **Enemy AI** — enemies detect and chase the player within aggro range
- 👹 **Boss fight** — Room 5 features a boss with minions
- 🎒 **Inventory system** — collect and manage items (keys, crowbars, food, gun) with slot limits
- 🔑 **Doors & Chests** — unlock doors with keys and break chests for loot
- 🍖 **Food & Healing** — pick up food to restore health (apples, cakes, potions)
- 🔫 **Gun & Bullets** — ranged weapon that fires projectiles at enemies
- 💀 **Respawn & Checkpoints** — player respawns at their spawn point; achievements act as checkpoints
- 🏆 **Achievement System** — unlock achievements based on world triggers and progress
- 🖥️ **HUD** — on-screen display showing player stats, keys, achievements
- 🎵 **Sound & Sprites** — audio effects and sprite-based graphics (with procedural fallbacks)
- ⌨️ **Keyboard input** — responsive keyboard-driven controls
- 🎨 **Procedural graphics** — game works without any sprite files using colored shapes

---

## Project Structure

```
├── entities/
│   ├── Entity.java           # Abstract base — position, size, sprite, collision, active flag
│   ├── LivingBeing.java      # Abstract — HP, strength, speed, movement, attack, damage
│   ├── Player.java           # Player — input handling, respawn, inventory, interactions
│   ├── Enemy.java            # Enemy — AI aggression, chase, loot drops, boss mode
│   ├── Chest.java            # Loot container — stores items, implements Activatable
│   ├── Door.java             # Door — locked/unlocked state, key-based unlock, room transitions
│   ├── Barrel.java           # Barrel — implements Activatable, stores items, can be broken
│   ├── Bullet.java           # Projectile — moves in direction, deals damage on hit
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
│   ├── Gun.java              # Ranged weapon — fires bullets with cooldown
│   └── Lock.java             # Lock mechanism — key-based unlock/lock logic
│
├── world/
│   ├── Room.java             # Single room — items, living beings, doors, draw/update
│   ├── World.java            # Game world — entities, executables, room transitions, step()
│   ├── Dungeon.java          # 5-room dungeon — level design, enemy/item placement
│   └── TileManager.java      # Tile grid — floor/wall types, collision, procedural drawing
│
├── managers/
│   ├── Inventory.java        # Slot-based inventory — add/remove/has/get items
│   ├── AchievementManager.java # Tracks progress, notifies on unlock
│   ├── EntityManager.java    # Entity lifecycle — update, draw, remove inactive
│   ├── CollisionManager.java # Collision detection — player/enemy/bullet/door/room
│   └── Executable.java       # Interface — defines execute() for logic/actions
│
├── main/
│   ├── Main.java             # Entry point — creates JFrame window
│   ├── GamePanel.java        # Core game loop (60 FPS), state machine, rendering
│   └── GameState.java        # Enum: MENU, PLAYING, PAUSED, GAME_OVER, WIN
│
├── ui/
│   ├── Menu.java             # Main menu — NEW GAME, CONTROLS, QUIT
│   ├── HUD.java              # Health bar, room name, key count, achievements
│   └── InventoryUI.java      # Inventory grid (2×5), item use, message toasts
│
├── input/
│   └── KeyboardHandler.java  # Keyboard input — WASD, arrows, SPACE, E, I, ESC, 1-9
│
├── graphics/
│   ├── SpriteLoader.java     # Image loading from classpath/filesystem
│   ├── Animator.java         # Sprite animation frames
│   └── Assets.java           # Static sprite storage, loads at startup
│
├── utils/
│   └── Constants.java        # Screen size (768×576), FPS (60), tile size (48px)
│
├── resources/
│   └── sprites/              # (Optional) PNG sprite files
│
└── README.md
```

---

## Class Overview

### Inheritance Hierarchy

```
Entity (abstract)
├── LivingBeing (abstract)
│   ├── Player
│   └── Enemy
├── Chest (implements Activatable)
├── Door
├── Barrel (implements Activatable)
├── Bullet
└── Achievement (implements Executable)

Item (abstract)
├── Food (abstract)
│   ├── Apple
│   ├── Cake
│   └── Potion
├── Key
├── Crowbar
└── Gun

Interfaces
├── Activatable (entities)
└── Executable (managers)
```

### Key Relationships

| Class | Uses |
|-------|------|
| `Player` | `Inventory`, `Food`, `Key`, `Door`, `Chest`, `Crowbar`, `KeyboardHandler` |
| `Enemy` | `Item` (loot drops), `Player` (chase target) |
| `Inventory` | `Item` (slot storage) |
| `Room` | `Entity`, `Door` (contains items, beings, doors) |
| `World` | `Room`, `Entity` (manages current room and entities) |
| `Dungeon` | `Room`, `TileManager`, `Player` (5-room level design) |
| `Door` | `Key` (unlock by matching ID), room transitions |
| `Chest` | `Item` (stores loot), `Activatable` |
| `Barrel` | `Item` (stores loot), `Activatable` |
| `Bullet` | `Enemy` (damage on collision) |
| `Gun` | `Bullet` (creates projectiles) |
| `Achievement`| `Player` (for checkpoint), `Executable` |
| `AchievementManager` | `Achievement` (manages all unlocks) |
| `GamePanel` | All managers, UI, World, Player (game loop orchestrator) |
| `Lock` | String key ID (standalone lock mechanism) |

---

## Prerequisites

- **Java 17** or higher ([Download](https://adoptium.net/))
- A Java IDE such as [IntelliJ IDEA](https://www.jetbrains.com/idea/) or [Eclipse](https://www.eclipse.org/), or the JDK command-line tools

---

## Getting Started

### Compile

```bash
javac -d out entities/*.java items/*.java managers/*.java world/*.java graphics/*.java input/*.java main/*.java ui/*.java utils/*.java
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
| `Space` | Melee attack |
| `E` | Interact (open chest / barrel / unlock door) |
| `I` | Toggle inventory |
| `1`-`9` | Use item in inventory slot |
| `Esc` | Pause / resume |
| `Enter` | Select menu option / return to menu |

---

## Gameplay Guide

1. **Room 1 (Entrance Hall)** — Kill the enemy to get Key 1, open the chest for a Crowbar and Apple, smash the barrel. Unlock the door on the right.
2. **Room 2 (The Corridor)** — Fight two enemies, open the chest for Key 2 and a Potion. Proceed right.
3. **Room 3 (The Armory)** — Find the **Gun** in the chest! Smash barrels for healing. Kill the enemy for Key 3.
4. **Room 4 (The Gauntlet)** — Three enemies, maze-like walls. Get Key 4 from the fast enemy. Stock up on Potions.
5. **Room 5 (Boss Chamber)** — Defeat the Boss and two minions to win the game!

---

## Resources

### Optional Sprite Files

The game works **without any sprites** using procedural colored shapes. To add custom graphics:

1. Place PNG files in `resources/sprites/`
2. Use these exact filenames:

| File | Size | Description |
|------|------|-------------|
| `player.png` | 48×48 | Player character |
| `enemy.png` | 48×48 | Regular enemy |
| `boss.png` | 64×64 | Boss enemy |
| `chest.png` | 48×48 | Closed chest |
| `barrel.png` | 48×48 | Barrel |
| `door_locked.png` | 48×48 | Locked door |
| `key.png` | 32×32 | Key icon |
| `apple.png` | 32×32 | Apple icon |
| `cake.png` | 32×32 | Cake icon |
| `potion.png` | 32×32 | Potion icon |
| `crowbar.png` | 32×32 | Crowbar icon |
| `gun.png` | 32×32 | Gun icon |
| `bullet.png` | 16×16 | Bullet |
| `floor.png` | 48×48 | Floor tile |
| `wall.png` | 48×48 | Wall tile |

### Where to Find Free Sprites

| Source | URL |
|--------|-----|
| **itch.io** | https://itch.io/game-assets/free/tag-2d |
| **OpenGameArt.org** | https://opengameart.org/ |
| **Kenney.nl** | https://kenney.nl/assets |
| **0x72 Dungeon Tileset** | https://0x72.itch.io/dungeontileset-ii |
