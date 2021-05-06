package com.s206megame.towerdefense.tower;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

public class SolidBlockElement extends BlockElement {
    private Material mat;
    protected Location build;
    public SolidBlockElement(int x, int y, int z, Material mat) {
        super(x, y, z);
        this.mat = mat;
    }
    @Override
    public void build(Location center, Direction dir) {
        // [ cos -sin ][ x ]
        // [ sin  cos ][ z ]
        double theta = dir.getRad() - Direction.NORTH.getRad();
        double dx = this.x * Math.cos(theta) - this.z * Math.sin(theta);
        double dz = this.x * Math.sin(theta) + this.z * Math.cos(theta);
        World w = center.getWorld();
        if (w == null) return;
        Block block = w.getBlockAt(center.getBlockX() + (int) Math.round(dx), center.getBlockY() + y, center.getBlockZ() + (int) Math.round(dz));
        this.build = block.getLocation();
        block.setType(mat);
    }
}
