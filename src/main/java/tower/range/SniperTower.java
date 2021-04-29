package tower.range;

import com.s206megame.towerdefense.TowerDefense;
import org.bukkit.Material;
import tower.Tower;
import tower.TowerCategory;

import java.util.Arrays;
import java.util.List;

public class SniperTower extends Tower {

    private int level;
    private TowerCategory category = TowerCategory.Range;
    @Override
    public Material getDisplayItem() {
        return Material.OBSERVER;
    }

    @Override
    public double getDamage() {
        switch (level) {
            case 1:
                return 100;
            case 2:
                return 150;
            case 3:
                return 200;
        }
        return 0;
    }

    @Override
    public double getHitDelay() {
        switch (level) {
            case 1:
                return 100;
            case 2:
                return 90;
            case 3:
                return 80;
        }
        return 0;
    }

    @Override
    public double getRange() {
        switch (level) {
            case 1:
                return 40;
            case 2:
                return 45;
            case 3:
                return 50;
        }
        return 0;
    }

    @Override
    public int getPrice() {
        switch (level) {
            case 1:
                return 400;
            case 2:
                return 750;
            case 3:
                return 1250;
        }
        return 0;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public String getTitle() {
        return "[Lv."+getLevel()+"] 狙擊手塔";
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("§f無情的狙擊手隨時都將奪去戰場上敵人的性命！", "§f給予敵人§c致命傷害");
    }
}
