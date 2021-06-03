package com.s206megame.towerdefense.build;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.MultipleFacing;

import java.util.ArrayList;

public class MultipleFacingBlockElement extends SolidBlockElement {

    private boolean north;
    private boolean south;
    private boolean west;
    private boolean east;

    public MultipleFacingBlockElement(int x, int y, int z, Material mat, boolean north, boolean south, boolean west, boolean east) {
        super(x, y, z, mat);
        this.north = north;
        this.south = south;
        this.west = west;
        this.east = east;
    }

    @Override
    public void build(Location center, Direction dir) {
        super.build(center, dir);
        int direct = (int) Math.round(dir.getDegree() - Direction.NORTH.getDegree());
        Block block = build.getBlock();
        MultipleFacing data = ((MultipleFacing) block.getBlockData());
        data.getFaces().forEach(p -> data.setFace(p,false));
        ArrayList<BlockFace> face = new ArrayList<>();
        if (north) face.add(BlockFace.NORTH);
        if (west) face.add(BlockFace.WEST);
        if (south) face.add(BlockFace.SOUTH);
        if (east) face.add(BlockFace.EAST);
        for (BlockFace faced : face) {
            data.setFace(rotate(faced,direct),true);
        }
        block.setBlockData(data);
    }

    private BlockFace rotate(BlockFace face, int deg) {
        if (deg < 0) {
            return rotate(face,deg + 360);
        }
        if (deg >= 360) {
            return rotate(face, deg- 360);
        }
        while (deg >= 90) {
            switch (face) {
                case NORTH:
                    face = BlockFace.EAST;
                    break;
                case EAST:
                    face = BlockFace.SOUTH;
                    break;
                case SOUTH:
                    face = BlockFace.WEST;
                    break;
                case WEST:
                    face = BlockFace.NORTH;
            }
            deg-=90;
        }
        return face;
    }

}
