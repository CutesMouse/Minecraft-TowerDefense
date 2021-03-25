package tower;

import org.bukkit.Material;

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
        switch (level)
        {
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
        switch (level)
        {
            case 1:
                return 16;
            case 2:
                return 8;
            case 3:
                return 4;
        }
    }

    @Override
    public double getRange() {
        switch (level)
        {
            case 1:
                return 5;
            case 2:
                return 7;
            case 3:
                return 9;
        }
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public List<String> getDescription() {
        return null;
    }
}
