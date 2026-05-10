package managers;

import entities.*;
import items.*;
import utils.Constants;
import java.util.List;

public class CollisionManager {

    public static void checkPlayerEnemyCollision(Player player, List<Enemy> enemies) {
        for (Enemy enemy : enemies) {
            if (!enemy.isActive()) continue;
            if (player.collidesWith(enemy)) {
                enemy.attackPlayer(player);
            }
        }
    }

    public static void checkPlayerDoorCollision(Player player, List<Door> doors) {
        for (Door door : doors) {
            if (!door.isActive() || !door.isLocked()) continue;
            if (player.collidesWith(door)) {
                // Push player back
                int dx = player.getX() - door.getX();
                int dy = player.getY() - door.getY();
                if (Math.abs(dx) > Math.abs(dy)) {
                    player.setPosition(
                        dx > 0 ? door.getX() + door.getWidth() : door.getX() - player.getWidth(),
                        player.getY()
                    );
                } else {
                    player.setPosition(
                        player.getX(),
                        dy > 0 ? door.getY() + door.getHeight() : door.getY() - player.getHeight()
                    );
                }
            }
        }
    }

    public static void checkBulletEnemyCollision(List<Bullet> bullets, List<Enemy> enemies) {
        for (Bullet bullet : bullets) {
            if (!bullet.isActive()) continue;
            for (Enemy enemy : enemies) {
                if (!enemy.isActive()) continue;
                if (bullet.collidesWith(enemy)) {
                    enemy.takeDamage(bullet.getDamage());
                    bullet.setActive(false);
                    break;
                }
            }
        }
    }

    public static void clampToRoom(Entity entity, int roomX, int roomY, int roomW, int roomH) {
        int ex = entity.getX();
        int ey = entity.getY();
        int ew = entity.getWidth();
        int eh = entity.getHeight();

        int margin = 4; // wall thickness
        if (ex < roomX + margin) entity.setPosition(roomX + margin, ey);
        if (ey < roomY + margin) entity.setPosition(entity.getX(), roomY + margin);
        if (ex + ew > roomX + roomW - margin) entity.setPosition(roomX + roomW - margin - ew, entity.getY());
        if (ey + eh > roomY + roomH - margin) entity.setPosition(entity.getX(), roomY + roomH - margin - eh);
    }
}
