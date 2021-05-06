package com.s206megame.towerdefense.tower;

import org.bukkit.Location;

import java.util.ArrayList;

public class TowerStructure {
    private ArrayList<BlockElement> BLOCKS;
    public void TowerStructure() {
        BLOCKS = new ArrayList<>();
    }
    public void register(BlockElement blockElement) {
        BLOCKS.add(blockElement);
    }
    public void build(Location center, Direction dir) {
        for (BlockElement block : BLOCKS) {
            block.build();
        }
    }
}
