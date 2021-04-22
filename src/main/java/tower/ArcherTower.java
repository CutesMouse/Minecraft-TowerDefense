package tower;

import org.bukkit.Material;

import java.util.Arrays;
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
        return "[Lv."+getLevel()+"] 弓箭手塔";
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("§f冷血的弓箭手躲在§9堅固§f的堡壘中，","§f準確§c射殺§f迎面而來的§c敵人");
    }


}
