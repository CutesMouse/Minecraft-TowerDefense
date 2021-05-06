package com.s206megame.towerdefense.tower;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Directional;
import org.bukkit.block.data.type.Ladder;
import org.bukkit.block.data.type.Stairs;

public class DirectionalBlockElement extends SolidBlockElement {
    private BlockFace face;
    public DirectionalBlockElement(int x, int y, int z, Material mat, BlockFace face) {
        super(x, y, z, mat);
        this.face = face;
    }

    @Override
    public void build(Location center, Direction dir) {
        super.build(center, dir);
        int direct = (int) Math.round(dir.getDegree() - Direction.NORTH.getDegree());
        Directional state = ((Directional) build.getBlock().getBlockData());
        BlockFace newFace = rotate(face, direct);
        state.setFacing(newFace);
        build.getBlock().setBlockData(state);
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
