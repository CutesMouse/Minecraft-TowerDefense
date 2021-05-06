package com.s206megame.towerdefense.tower;

import org.bukkit.Location;
import org.bukkit.Material;

public abstract class BlockElement {
    protected int x;
    protected int y;
    protected int z;
    public BlockElement(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public abstract void build(Location center, Direction dir);
}
