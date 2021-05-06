package tower.range;

import org.bukkit.Material;
import tower.Tower;
import tower.TowerCategory;

import java.util.Arrays;
import java.util.List;

public class LongbowTower extends Tower {

    private int level;
    TowerCategory category = TowerCategory.Range;
    @Override
    public Material getDisplayItem() {
        return Material.ARROW;
    }

    @Override
    public double getDamage() {
        switch (level) {
            case 1:
                return 50;
            case 2:
                return 70;
            case 3:
                return 90;
        }
        return 0;
    }

    @Override
    public double getHitDelay() {
        switch (level) {
            case 1:
                return 80;
            case 2:
                return 70;
            case 3:
                return 50;
        }
        return 0;
    }

    @Override
    public double getRange() {
        switch (level) {
            case 1:
                return 30;
            case 2:
                return 35;
            case 3:
                return 40;
        }
        return 0;
    }

    @Override
    public int getPrice() {
        switch (level) {
            case 1:
                return 190;
            case 2:
                return 350;
            case 3:
                return 720;
        }
        return 0;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public String getTitle() {
        return "[Lv."+getLevel()+"] 長弓手塔";
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("§f長弓手以其精準的預判能力，","§f遠程射殺敵人！", "§f給予敵人§c高傷害");
    }
}
