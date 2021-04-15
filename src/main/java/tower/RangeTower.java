package tower;

import org.bukkit.Material;

import java.util.List;

public class RangeTower extends Tower {
    @Override
    public Material getDisplayItem() {
        return null;
    }

    @Override
    public double getDamage() {
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
        return 0;
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
