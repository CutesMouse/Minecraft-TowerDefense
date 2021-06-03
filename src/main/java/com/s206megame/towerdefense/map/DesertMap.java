package com.s206megame.towerdefense.map;

import com.s206megame.towerdefense.map.basic.CraftMap;
import com.s206megame.towerdefense.map.basic.TowerSlot;
import com.s206megame.towerdefense.map.basic.CheckPoint;
import com.s206megame.towerdefense.tower.basic.TowerType;
import com.s206megame.towerdefense.build.Direction;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.ArrayList;
import java.util.LinkedList;

public class DesertMap extends CraftMap {
    @Override
    protected void initTowers() {
        towerSlots = new ArrayList<>();
        World w = WORLD;
        towerSlots.add(new TowerSlot(new Location(w, -196, 3, -47), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, -196, 3, -44), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, -196, 3, -41), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, -196, 3, -38), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, -196, 3, -35), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, -196, 3, -32), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, -196, 3, -29), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, -196, 3, -26), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, -196, 3, -23), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, -196, 3, -20), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, -195, 3, -17), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, -194, 3, -14), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, -193, 3, -11), TowerType.THREE_BY_THREE, Direction.NORTH));
        towerSlots.add(new TowerSlot(new Location(w, -190, 3, -11), TowerType.THREE_BY_THREE, Direction.NORTH));
        towerSlots.add(new TowerSlot(new Location(w, -187, 3, -11), TowerType.THREE_BY_THREE, Direction.NORTH));
        towerSlots.add(new TowerSlot(new Location(w, -184, 3, -11), TowerType.THREE_BY_THREE, Direction.NORTH));
        towerSlots.add(new TowerSlot(new Location(w, -181, 3, -11), TowerType.THREE_BY_THREE, Direction.NORTH));
        towerSlots.add(new TowerSlot(new Location(w, -178, 3, -11), TowerType.THREE_BY_THREE, Direction.NORTH));
        towerSlots.add(new TowerSlot(new Location(w, -177, 3, -14), TowerType.THREE_BY_THREE, Direction.WEST));
        towerSlots.add(new TowerSlot(new Location(w, -176, 3, -17), TowerType.THREE_BY_THREE, Direction.WEST));
        towerSlots.add(new TowerSlot(new Location(w, -175, 3, -20), TowerType.THREE_BY_THREE, Direction.WEST));
        towerSlots.add(new TowerSlot(new Location(w, -175, 3, -23), TowerType.THREE_BY_THREE, Direction.WEST));
        towerSlots.add(new TowerSlot(new Location(w, -175, 3, -26), TowerType.THREE_BY_THREE, Direction.WEST));
        towerSlots.add(new TowerSlot(new Location(w, -175, 3, -29), TowerType.THREE_BY_THREE, Direction.WEST));
        towerSlots.add(new TowerSlot(new Location(w, -175, 3, -32), TowerType.THREE_BY_THREE, Direction.WEST));
        towerSlots.add(new TowerSlot(new Location(w, -175, 3, -35), TowerType.THREE_BY_THREE, Direction.WEST));
        towerSlots.add(new TowerSlot(new Location(w, -175, 3, -38), TowerType.THREE_BY_THREE, Direction.WEST));
        towerSlots.add(new TowerSlot(new Location(w, -174, 3, -41), TowerType.THREE_BY_THREE, Direction.NORTH));
        towerSlots.add(new TowerSlot(new Location(w, -171, 3, -41), TowerType.THREE_BY_THREE, Direction.NORTH));
        towerSlots.add(new TowerSlot(new Location(w, -168, 3, -41), TowerType.THREE_BY_THREE, Direction.NORTH));
        towerSlots.add(new TowerSlot(new Location(w, -165, 3, -41), TowerType.THREE_BY_THREE, Direction.NORTH));
        towerSlots.add(new TowerSlot(new Location(w, -162, 3, -41), TowerType.THREE_BY_THREE, Direction.NORTH));
        towerSlots.add(new TowerSlot(new Location(w, -159, 3, -41), TowerType.THREE_BY_THREE, Direction.NORTH));
        towerSlots.add(new TowerSlot(new Location(w, -156, 3, -41), TowerType.THREE_BY_THREE, Direction.NORTH));
        towerSlots.add(new TowerSlot(new Location(w, -153, 3, -41), TowerType.THREE_BY_THREE, Direction.NORTH));
        towerSlots.add(new TowerSlot(new Location(w, -150, 3, -41), TowerType.THREE_BY_THREE, Direction.NORTH));
        towerSlots.add(new TowerSlot(new Location(w, -147, 3, -41), TowerType.THREE_BY_THREE, Direction.NORTH));
        towerSlots.add(new TowerSlot(new Location(w, -144, 3, -41), TowerType.THREE_BY_THREE, Direction.NORTH));
        towerSlots.add(new TowerSlot(new Location(w, -141, 3, -41), TowerType.THREE_BY_THREE, Direction.NORTH));
        towerSlots.add(new TowerSlot(new Location(w, -138, 3, -41), TowerType.THREE_BY_THREE, Direction.NORTH));
        towerSlots.add(new TowerSlot(new Location(w, -135, 3, -41), TowerType.THREE_BY_THREE, Direction.NORTH));
        towerSlots.add(new TowerSlot(new Location(w, -132, 3, -40), TowerType.THREE_BY_THREE, Direction.NORTH));
        towerSlots.add(new TowerSlot(new Location(w, -129, 3, -39), TowerType.THREE_BY_THREE, Direction.NORTH));
        towerSlots.add(new TowerSlot(new Location(w, -129, 3, -36), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, -129, 3, -33), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, -129, 3, -30), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, -129, 3, -27), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, -129, 3, -24), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, -129, 3, -21), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, -129, 3, -18), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, -129, 3, -15), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, -129, 3, -12), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, -129, 3, -9), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, -129, 3, -6), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, -129, 3, -3), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, -129, 3, 0), TowerType.THREE_BY_THREE, Direction.EAST));
        towerSlots.add(new TowerSlot(new Location(w, -130, 3, 3), TowerType.THREE_BY_THREE, Direction.SOUTH));
        towerSlots.add(new TowerSlot(new Location(w, -133, 3, 4), TowerType.THREE_BY_THREE, Direction.SOUTH));
        towerSlots.add(new TowerSlot(new Location(w, -136, 3, 5), TowerType.THREE_BY_THREE, Direction.SOUTH));
        towerSlots.add(new TowerSlot(new Location(w, -139, 3, 5), TowerType.THREE_BY_THREE, Direction.SOUTH));
        towerSlots.add(new TowerSlot(new Location(w, -142, 3, 5), TowerType.THREE_BY_THREE, Direction.SOUTH));
        towerSlots.add(new TowerSlot(new Location(w, -145, 3, 5), TowerType.THREE_BY_THREE, Direction.SOUTH));
        towerSlots.add(new TowerSlot(new Location(w, -148, 3, 5), TowerType.THREE_BY_THREE, Direction.SOUTH));
        towerSlots.add(new TowerSlot(new Location(w, -151, 3, 5), TowerType.THREE_BY_THREE, Direction.SOUTH));
        towerSlots.add(new TowerSlot(new Location(w, -154, 3, 5), TowerType.THREE_BY_THREE, Direction.SOUTH));
        towerSlots.add(new TowerSlot(new Location(w, -157, 3, 5), TowerType.THREE_BY_THREE, Direction.SOUTH));
        towerSlots.add(new TowerSlot(new Location(w, -160, 3, 5), TowerType.THREE_BY_THREE, Direction.SOUTH));
        towerSlots.add(new TowerSlot(new Location(w, -163, 3, 5), TowerType.THREE_BY_THREE, Direction.SOUTH));
        towerSlots.add(new TowerSlot(new Location(w, -166, 3, 5), TowerType.THREE_BY_THREE, Direction.SOUTH));
        towerSlots.add(new TowerSlot(new Location(w, -169, 3, 5), TowerType.THREE_BY_THREE, Direction.SOUTH));
        towerSlots.add(new TowerSlot(new Location(w, -172, 3, 5), TowerType.THREE_BY_THREE, Direction.SOUTH));
        towerSlots.add(new TowerSlot(new Location(w, -175, 3, 5), TowerType.THREE_BY_THREE, Direction.SOUTH));
        towerSlots.add(new TowerSlot(new Location(w, -178, 3, 5), TowerType.THREE_BY_THREE, Direction.SOUTH));
        towerSlots.add(new TowerSlot(new Location(w, -181, 3, 5), TowerType.THREE_BY_THREE, Direction.SOUTH));
        towerSlots.add(new TowerSlot(new Location(w, -117, 3, -1), TowerType.FIVE_BY_FIVE, Direction.WEST));
        towerSlots.add(new TowerSlot(new Location(w, -117, 3, -11), TowerType.FIVE_BY_FIVE, Direction.WEST));
        towerSlots.add(new TowerSlot(new Location(w, -117, 3, -21), TowerType.FIVE_BY_FIVE, Direction.WEST));
        towerSlots.add(new TowerSlot(new Location(w, -117, 3, -31), TowerType.FIVE_BY_FIVE, Direction.WEST));
        towerSlots.add(new TowerSlot(new Location(w, -135, 3, -53), TowerType.FIVE_BY_FIVE, Direction.SOUTH));
        towerSlots.add(new TowerSlot(new Location(w, -146, 3, -53), TowerType.FIVE_BY_FIVE, Direction.SOUTH));
        towerSlots.add(new TowerSlot(new Location(w,-159,8,-8),TowerType.FIVE_BY_FIVE,Direction.SOUTH));
    }

    @Override
    protected void initCastleBlocks() {
        castleBlocks = new LinkedList<>();
        castleBlocks.add(new Location(WORLD, -189, 12, 10));
        castleBlocks.add(new Location(WORLD, -189, 12, 9));
        castleBlocks.add(new Location(WORLD, -188, 11, 10));
        castleBlocks.add(new Location(WORLD, -189, 11, 12));
        castleBlocks.add(new Location(WORLD, -189, 11, 11));
        castleBlocks.add(new Location(WORLD, -190, 11, 10));
        castleBlocks.add(new Location(WORLD, -189, 11, 10));
        castleBlocks.add(new Location(WORLD, -189, 11, 9));
        castleBlocks.add(new Location(WORLD, -190, 11, 11));
        castleBlocks.add(new Location(WORLD, -188, 10, 11));
        castleBlocks.add(new Location(WORLD, -189, 10, 12));
        castleBlocks.add(new Location(WORLD, -189, 10, 11));
        castleBlocks.add(new Location(WORLD, -188, 10, 10));
        castleBlocks.add(new Location(WORLD, -190, 10, 9));
        castleBlocks.add(new Location(WORLD, -189, 10, 9));
        castleBlocks.add(new Location(WORLD, -189, 10, 10));
        castleBlocks.add(new Location(WORLD, -190, 10, 10));
        castleBlocks.add(new Location(WORLD, -190, 10, 11));
        castleBlocks.add(new Location(WORLD, -190, 10, 12));
    }

    @Override
    protected void initCheckpoints() {
        cps = new ArrayList<>();
        cps.add(new CheckPoint(-190, 3, -17.5));
        cps.add(new CheckPoint(-180.5, 3, -15.5));
        cps.add(new CheckPoint(-180, 3, -19));
        cps.add(new CheckPoint(-180, 3, -43));
        cps.add(new CheckPoint(-176, 3, -46));
        cps.add(new CheckPoint(-126, 3, -46));
        cps.add(new CheckPoint(-123, 3, -39));
        cps.add(new CheckPoint(-123, 3, 8));
        cps.add(new CheckPoint(-130, 3, 11));
    }

    @Override
    protected void initFinalCastleBlocks() {
        //-190 9 9
        finalCastleBlocks = new ArrayList<>();
        for (int x = -190; x <= -189; x++) {
            for (int z = 9; z <= 12; z++) {
                finalCastleBlocks.add(new Location(WORLD, x, 9, z));
            }
        }
    }

    @Override
    public Location getMobSpawnLocation() {
        return new Location(WORLD, -190.0, 3, -49.5,90,0);
    }

    @Override
    public Location getEndPoint() {
        return new Location(WORLD, -190.5, 3, 11);
    }

    @Override
    public double getEndPointOffset() {
        return 4;
    }

    @Override
    public Location getSpawnPoint() {
        return new Location(WORLD, -157,13,-22);
    }
}
