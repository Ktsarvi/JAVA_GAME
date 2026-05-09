package managers;

import entities.Achievement;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages game achievements and tracks progress.
 */
public class AchievementManager {
    private List<Achievement> achievements;

    public AchievementManager() {
        this.achievements = new ArrayList<>();
    }

    public void addAchievement(Achievement achievement) {
        achievements.add(achievement);
    }

    public void unlockAchievement(String name) {
        for (Achievement a : achievements) {
            if (a.getName().equalsIgnoreCase(name)) {
                a.execute();
                break;
            }
        }
    }

    public List<Achievement> getAchievements() {
        return achievements;
    }

    public int getUnlockedCount() {
        int count = 0;
        for (Achievement a : achievements) {
            if (a.isUnlocked()) count++;
        }
        return count;
    }
}
