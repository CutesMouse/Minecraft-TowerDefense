package tower.speed;

import org.bukkit.Material;
import tower.Tower;
import tower.TowerCategory;

import java.util.Arrays;
import java.util.List;

public class SnowballTower extends Tower {

    private int level;
    private TowerCategory category = TowerCategory.Speed;

    @Override
    public Material getDisplayItem() {
        return Material.SNOWBALL;
    }

    @Override
    public double getDamage() {
        switch (level) {
            case 1:
                return 3;
            case 2:
                return 5;
            case 3:
                return 7;
        }
        return 0;
    }

    @Override
    public double getHitDelay() {
        switch (level) {
            case 1:
                return 5;
            case 2:
                return 3;
            case 3:
                return 2;
        }
        return 0;
    }

    @Override
    public double getRange() {
        switch (level) {
            case 1:
                return 5;
            case 2:
                return 7;
            case 3:
                return 10;
        }
        return 0;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public String getTitle() {
        return "[Lv."+getLevel()+"] 雪球塔";
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("§f來自雪人的祝福，在戰場上開啟一場§a雪球大戰！", "使敵人得到§c減速效果數秒");
    }
}