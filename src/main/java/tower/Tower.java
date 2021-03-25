package tower;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Tower {
    public abstract Material getDisplayItem();
    public abstract double getDamage();
    public abstract double getHitDelay();
    public abstract double getRange();
    public abstract int getLevel();
    public abstract String getTitle();
    public abstract List<String> getDescription();

    public String getDescriptionTitle() {
        return "§f"+getTitle();
    }
    public ArrayList<String> getDescriptionLore() {
        return new ArrayList<>(Arrays.asList("介紹： " + getDescription(), "射程： " + getRange(), "單次攻擊力： " +getDamage(),"攻擊頻率： " + getHitDelay()));
    }
}
