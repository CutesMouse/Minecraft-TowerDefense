package com.s206megame.towerdefense.tower;

import org.bukkit.Location;
import org.bukkit.Material;

public abstract class BlockElement {
    public BlockElement() {
    }
    public abstract void build(Direction dir);
}
