package com.s206megame.towerdefense.build;

import org.bukkit.Location;

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
    public abstract void remove(Location center, Direction dir);
}
