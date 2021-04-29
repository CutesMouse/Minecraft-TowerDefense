package tower.attack;

import org.bukkit.Material;
import tower.Tower;
import tower.TowerCategory;

import java.util.Arrays;
import java.util.List;

public class DariusTower extends Tower {

    private TowerCategory category = TowerCategory.Attack;

    @Override
    public Material getDisplayItem() {
        return Material.ANVIL;
    }

    @Override
    public double getDamage() {
        return 20000;
    }

    @Override
    public double getHitDelay() {
        return 200;
    }

    @Override
    public double getRange() {
        return 5;
    }

    @Override
    public int getPrice() {
        return 5000;
    }

    @Override
    public int getLevel() { return 0; }

    @Override
    public String getTitle() {
        return "[Lv."+99999+"] 巨錘瑞斯";
    }


    @Override
    public List<String> getDescription() {
        return Arrays.asList("§c巨錘瑞斯，開剁！","§f給予敵人§c致命的最後一擊，保證擊殺");
    }


}
