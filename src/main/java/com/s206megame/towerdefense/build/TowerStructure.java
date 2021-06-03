package com.s206megame.towerdefense.build;

import com.s206megame.towerdefense.build.BlockElement;
import com.s206megame.towerdefense.build.Direction;
import org.bukkit.Location;

import java.util.ArrayList;

public class TowerStructure {
    private ArrayList<BlockElement> BLOCKS;
    public TowerStructure() {
        BLOCKS = new ArrayList<>();
    }
    public void register(BlockElement blockElement) {
        BLOCKS.add(blockElement);
    }
    public void build(Location center, Direction dir) {
        for (BlockElement block : BLOCKS) {
            block.build(center,dir);
        }
    }
    public void remove(Location center, Direction dir) {
        for (BlockElement block : BLOCKS) {
            block.remove(center,dir);
        }
    }
}
