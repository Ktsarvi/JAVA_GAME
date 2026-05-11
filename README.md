# Java Dungeon Game

Hi! I built this 2D tile-based dungeon crawler from scratch using Java Swing. There are no massive game engines behind this—just pure Java. 

Your goal in this game is simple: fight your way through five interconnected rooms, gather loot, and defeat the boss to escape to freedom.

## What is this game about?

You start with nothing but your bare fists. As you explore the dungeon, you'll need to fight enemies and find items to survive. 
- You can find **Apples** and **Potions** to heal yourself.
- You'll need to get a **Crowbar** to smash open chests, which hold important items like **Keys** to unlock the doors to the next rooms.
- Later on, you can even find a **Gun** to shoot enemies from a distance instead of fighting them hand-to-hand.
- Make sure to touch the golden stars in each room—they act as checkpoints. If you die, you'll respawn at the last star you activated.

## How to play

You'll need Java 17 or higher to run the game. You can open the project in any IDE (like IntelliJ or Eclipse) and run `Main.java`, or use the command line:

**To compile:**
```bash
javac -d out entities/*.java items/*.java managers/*.java world/*.java graphics/*.java input/*.java main/*.java ui/*.java utils/*.java
```

**To run:**
```bash
java -cp out main.Main
```

### Controls

- **W, A, S, D** or **Arrow Keys**: Move your character
- **Space**: Attack (Melee punch, or shoot if you have the Gun equipped)
- **E**: Interact (Smash chests/barrels, unlock doors)
- **I**: Open or close your inventory
- **1-9**: Use an item in your inventory, or equip/unequip the Gun
- **Esc**: Pause the game

## Walkthrough

If you get stuck, here is a quick guide to how the rooms work:

1. **Room 1 (Entrance Hall):** Kill the first enemy to get the Crowbar. Use it to smash the chest and get Key 1, then unlock the door to the right.
2. **Room 2 (The Corridor):** Fight the guards, grab the next key, and keep moving.
3. **Room 3 (The Armory):** Find the Gun hidden in the chest! You can also smash barrels for extra health.
4. **Room 4 (The Gauntlet):** A maze filled with enemies. Be quick and use your potions if you get low on health.
5. **Room 5 (Boss Chamber):** The final showdown. Defeat the massive Boss and his minions to win!

Enjoy the game!
