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
    public double getDamage() { return 0; } // unused

    public double getInitialDamage() {
        switch (level) {
            case 1:
                return 50;
            case 2:
                return 75;
            case 3:
                return 100;
        }
        return 0;
    }

    public double getFireDamage() {
        switch (level) {
            case 1:
                return 5;
            case 2:
                return 7.5;
            case 3:
                return 10;
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
    public int getPrice() {
        switch (level) {
            case 1:
                return 160;
            case 2:
                return 320;
            case 3:
                return 640;
        }
        return 0;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public String getTitle() {
        return "[Lv."+getLevel()+"] 烈焰塔";
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("§f燃燒吧，§c火鳥！", "§f使敵人得到§c火焰球的初始傷害與持續數秒的傷害");
    }
}
