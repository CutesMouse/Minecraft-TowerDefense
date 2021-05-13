package com.s206megame.towerdefense.tower;

import com.s206megame.towerdefense.tower.Direction;
import com.s206megame.towerdefense.tower.DirectionalBlockElement;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Bisected;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.Stairs;

public class StairsBlockElement extends DirectionalBlockElement {
    protected Bisected.Half bis;
    protected Stairs.Shape shape;
    public StairsBlockElement(int x, int y, int z, Material mat, BlockFace face, Bisected.Half bis, Stairs.Shape shape) {
        super(x, y, z, mat, face);
        this.bis = bis;
        this.shape = shape;
    }

    @Override
    public void build(Location center, Direction dir) {
        super.build(center, dir);
        Stairs data = ((Stairs) build.getBlock().getBlockData());
        data.setHalf(bis);
        data.setShape(shape);
        build.getBlock().setBlockData(data);
    }
}
