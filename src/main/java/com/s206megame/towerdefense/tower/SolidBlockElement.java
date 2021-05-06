package com.s206megame.towerdefense.tower;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;

public class SolidBlockElement extends BlockElement {
    private Material mat;
    public SolidBlockElement(int x, int y, int z, Material mat) {
        super(x, y, z);
        this.mat = mat;
    }
    @Override
    public void build(Location center, Direction dir) {
        // [ cos -sin ][ x ]
        // [ sin  cos ][ y ]
        double dx = this.x * Math.cos(dir.getRad()) - Math.sin(dir.getRad());
        double dz = this.z * Math.sin(dir.getRad()) + Math.cos(dir.getRad());
        World w = center.getWorld();
        if (w == null) return;
        w.getBlockAt(center.getBlockX()+(int) dx,center.getBlockY()+y,center.getBlockZ() + (int) dz).setType(mat);
    }
}
