package tower.attack;

import org.bukkit.Material;
import tower.Tower;
import tower.TowerCategory;

import java.util.Arrays;
import java.util.List;

public class FireTower extends Tower {

    private int level;
    private TowerCategory category = TowerCategory.Attack;

    @Override
    public Material getDisplayItem() {
        return Material.FIRE_CHARGE;
    }

    @Override
    public double getDamage() {
        switch (level) {
            case 1:
                return 15;
            case 2:
                return 20;
            case 3:
                return 25;
        }
        return 0;
    }

    @Override
    public double getHitDelay() {
        switch (level) {
            case 1:
                return 70;
            case 2:
                return 60;
            case 3:
                return 50;
        }
        return 0;
    }

    @Override
    public double getRange() {
        switch (level) {
            case 1:
                return 5;
            case 2:
                return 6;
            case 3:
                return 8;
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
