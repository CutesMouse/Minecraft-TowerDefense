package com.s206megame.towerdefense.tower;

import org.bukkit.Location;

import java.util.ArrayList;

public class TowerStructure {
    private ArrayList<BlockElement> BLOCKS;
    public TowerStructure() {
        BLOCKS = new ArrayList<>();
    }
    /*
    已知問題:
        1. 玻璃不會延伸
        2. 藤蔓位置出錯
        3. 樹葉會自然掉落
     */
    public void register(BlockElement blockElement) {
        BLOCKS.add(blockElement);
    }
    public void build(Location center, Direction dir) {
        for (BlockElement block : BLOCKS) {
            block.build(center,dir);
        }
    }
}
