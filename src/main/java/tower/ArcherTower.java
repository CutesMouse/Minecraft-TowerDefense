package tower;

import org.bukkit.Material;

import java.util.List;

public class ArcherTower extends Tower {

    private int level;
    private TowerCategory category = TowerCategory.Range;

    @Override
    public Material getDisplayItem() {
        return Material.BOW;
    }

    @Override
    public double getDamage() {
        switch (level) {
            case 1:
                return 10;
        }
        return 0;
    }

    @Override
    public double getHitDelay() {
        return 0;
    }

    @Override
    public double getRange() {
        return 0;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public String getTitle() {
        return "弓箭手塔" + " // 等級 " + level;
    }

    @Override
    public List<String> getDescription() {
        return "";
    }


}
