package tower;

import java.util.List;

public class ArcherTower extends Tower {

    private int level;

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
        return 0;
    }

    @Override
    public String getTitle() {
        return "Skele";
    }

    @Override
    public List<String> getDescription() {
        return null;
    }


}
