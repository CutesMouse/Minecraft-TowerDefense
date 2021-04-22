package tower.attack;

import org.bukkit.Material;
import tower.Tower;
import tower.TowerCategory;

import java.util.Arrays;
import java.util.List;

public class PotionTower extends Tower {

    private int level;
    private TowerCategory category = TowerCategory.Attack;

    @Override
    public Material getDisplayItem() {
        return Material.POTION;
    }

    @Override
    public double getDamage() {
        switch (level) {
            case 1:
                return 10;
            case 2:
                return 15;
            case 3:
                return 20;
        }
        return 0;
    }

    @Override
    public double getHitDelay() {
        switch (level) {
            case 1:
                return 100;
            case 2:
                return 80;
            case 3:
                return 60;
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
        return "[Lv."+getLevel()+"] 藥水塔";
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("§f巫婆調製的§2劇毒藥水§f會要了你的命！","§f給予敵人§c持續數秒的傷害");
    }


}
