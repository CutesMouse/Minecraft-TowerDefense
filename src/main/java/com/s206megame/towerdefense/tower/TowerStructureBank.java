package com.s206megame.towerdefense.tower;

import com.s206megame.towerdefense.StairsBlockElement;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Bisected;
import org.bukkit.block.data.type.Stairs;

public class TowerStructureBank {

    public static TowerStructure getStructure(int level, String className) {
        switch (className) {
            case "DariusTower":
            {
                switch (level) {
                    case 1:
                        return DariusTower();
                }
            }
            case "ArcherTower":
            {
                switch (level) {
                    case 1:
                        return LV1ArcherTower();
                    case 2:
                        return LV2ArcherTower();
                    case 3:
                        return LV3ArcherTower();
                }
            }
            case "FireTower":
            {
                switch (level) {
                    case 1:
                        return LV1FireTower();
                    case 2:
                        return LV2FireTower();
                    case 3:
                        return LV3FireTower();
                }
            }
            case "PotionTower":
            {
                switch (level) {
                    case 1:
                        return LV1PotionTower();
                    case 2:
                        return LV2PotionTower();
                    case 3:
                        return LV3PotionTower();
                }
            }
            case "SnowballTower":
            {
                switch (level) {
                    case 1:
                        return LV1SnowballTower();
                    case 2:
                        return LV2SnowballTower();
                    case 3:
                        return LV3SnowballTower();
                }
            }
        }
        return null;
    }

    public static TowerStructure getStructure(int level, Class<? extends Tower> tower) {
        return getStructure(level, tower.getSimpleName());
    }
    private static TowerStructure LV1ArcherTower;
    private static TowerStructure LV1ArcherTower() {
        if (LV1ArcherTower != null) return LV1ArcherTower;
        TowerStructure structure = new TowerStructure();
        structure.register(new SolidBlockElement(-1,1,-1, Material.OAK_LOG));
        structure.register(new SolidBlockElement(-1,1,0,Material.PETRIFIED_OAK_SLAB));
        structure.register(new SolidBlockElement(-1,1,1,Material.OAK_LOG));
        structure.register(new SolidBlockElement(-1,2,-1,Material.OAK_LOG));
        structure.register(new SolidBlockElement(-1,2,0,Material.OAK_FENCE));
        structure.register(new SolidBlockElement(-1,2,1,Material.OAK_LOG));
        structure.register(new SolidBlockElement(-1,3,-1,Material.COBBLESTONE));
        structure.register(new SolidBlockElement(-1,3,0,Material.COBBLESTONE));
        structure.register(new SolidBlockElement(-1,3,1,Material.COBBLESTONE));
        structure.register(new SolidBlockElement(-1,4,-1,Material.PETRIFIED_OAK_SLAB));
        structure.register(new StairsBlockElement(-1,4,0,Material.OAK_STAIRS, BlockFace.EAST, Bisected.Half.BOTTOM, Stairs.Shape.STRAIGHT));
        structure.register(new SolidBlockElement(-1,4,1,Material.PETRIFIED_OAK_SLAB));
        structure.register(new StairsBlockElement(-1,5,-1,Material.OAK_STAIRS,BlockFace.SOUTH,Bisected.Half.TOP,Stairs.Shape.OUTER_LEFT));
        structure.register(new StairsBlockElement(-1,5,0,Material.OAK_STAIRS,BlockFace.EAST,Bisected.Half.TOP,Stairs.Shape.STRAIGHT));
        structure.register(new StairsBlockElement(-1,5,1,Material.OAK_STAIRS,BlockFace.NORTH,Bisected.Half.TOP,Stairs.Shape.OUTER_RIGHT));
        structure.register(new StairsBlockElement(-1,6,0,Material.OAK_STAIRS,BlockFace.EAST,Bisected.Half.BOTTOM,Stairs.Shape.STRAIGHT));
        structure.register(new SolidBlockElement(0,1,-1,Material.PETRIFIED_OAK_SLAB));
        structure.register(new SolidBlockElement(0,1,0,Material.PETRIFIED_OAK_SLAB));
        structure.register(new SolidBlockElement(0,1,1,Material.PETRIFIED_OAK_SLAB));
        structure.register(new SolidBlockElement(0,2,-1,Material.OAK_FENCE));
        structure.register(new SolidBlockElement(0,2,1,Material.OAK_FENCE));
        structure.register(new SolidBlockElement(0,3,-1,Material.COBBLESTONE));
        structure.register(new SolidBlockElement(0,3,1,Material.COBBLESTONE));
        structure.register(new StairsBlockElement(0,4,-1,Material.OAK_STAIRS,BlockFace.SOUTH,Bisected.Half.BOTTOM,Stairs.Shape.STRAIGHT));
        structure.register(new SolidBlockElement(0,4,0,Material.PETRIFIED_OAK_SLAB));
        structure.register(new StairsBlockElement(0,4,1,Material.OAK_STAIRS,BlockFace.NORTH,Bisected.Half.BOTTOM,Stairs.Shape.STRAIGHT));
        structure.register(new StairsBlockElement(0,5,-1,Material.OAK_STAIRS,BlockFace.SOUTH,Bisected.Half.TOP,Stairs.Shape.STRAIGHT));
        structure.register(new StairsBlockElement(0,5,1,Material.OAK_STAIRS,BlockFace.NORTH,Bisected.Half.TOP,Stairs.Shape.STRAIGHT));
        structure.register(new StairsBlockElement(0,6,-1,Material.OAK_STAIRS,BlockFace.SOUTH,Bisected.Half.BOTTOM,Stairs.Shape.STRAIGHT));
        structure.register(new SolidBlockElement(0,6,0,Material.OAK_PLANKS));
        structure.register(new StairsBlockElement(0,6,1,Material.OAK_STAIRS,BlockFace.NORTH,Bisected.Half.BOTTOM,Stairs.Shape.STRAIGHT));
        structure.register(new SolidBlockElement(1,1,-1,Material.OAK_LOG));
        structure.register(new SolidBlockElement(1,1,0,Material.PETRIFIED_OAK_SLAB));
        structure.register(new SolidBlockElement(1,1,1,Material.OAK_LOG));
        structure.register(new SolidBlockElement(1,2,-1,Material.OAK_LOG));
        structure.register(new SolidBlockElement(1,2,0,Material.OAK_FENCE));
        structure.register(new SolidBlockElement(1,2,1,Material.OAK_LOG));
        structure.register(new SolidBlockElement(1,3,-1,Material.COBBLESTONE));
        structure.register(new SolidBlockElement(1,3,0,Material.COBBLESTONE));
        structure.register(new SolidBlockElement(1,3,1,Material.COBBLESTONE));
        structure.register(new SolidBlockElement(1,4,-1,Material.PETRIFIED_OAK_SLAB));
        structure.register(new StairsBlockElement(1,4,0,Material.OAK_STAIRS,BlockFace.WEST,Bisected.Half.BOTTOM,Stairs.Shape.STRAIGHT));
        structure.register(new SolidBlockElement(1,4,1,Material.PETRIFIED_OAK_SLAB));
        structure.register(new StairsBlockElement(1,5,-1,Material.OAK_STAIRS,BlockFace.SOUTH,Bisected.Half.TOP,Stairs.Shape.OUTER_RIGHT));
        structure.register(new StairsBlockElement(1,5,0,Material.OAK_STAIRS,BlockFace.WEST,Bisected.Half.TOP,Stairs.Shape.STRAIGHT));
        structure.register(new StairsBlockElement(1,5,1,Material.OAK_STAIRS,BlockFace.NORTH,Bisected.Half.TOP,Stairs.Shape.OUTER_LEFT));
        structure.register(new StairsBlockElement(1,6,0,Material.OAK_STAIRS,BlockFace.WEST,Bisected.Half.BOTTOM,Stairs.Shape.STRAIGHT));
        LV1ArcherTower = structure;
        return structure;
    }

    private static TowerStructure LV2ArcherTower;
    private static TowerStructure LV2ArcherTower() {
        if (LV2ArcherTower != null) return LV2ArcherTower;
        TowerStructure structure = new TowerStructure();
        structure.register(new SolidBlockElement(-1,1,-1,Material.OAK_LOG));
        structure.register(new SolidBlockElement(-1,1,0,Material.PETRIFIED_OAK_SLAB));
        structure.register(new SolidBlockElement(-1,1,1,Material.OAK_LOG));
        structure.register(new SolidBlockElement(-1,2,-1,Material.OAK_LOG));
        structure.register(new SolidBlockElement(-1,2,0,Material.OAK_FENCE));
        structure.register(new SolidBlockElement(-1,2,1,Material.OAK_LOG));
        structure.register(new SolidBlockElement(-1,3,-1,Material.COBBLESTONE));
        structure.register(new SolidBlockElement(-1,3,0,Material.COBBLESTONE));
        structure.register(new SolidBlockElement(-1,3,1,Material.COBBLESTONE));
        structure.register(new SolidBlockElement(-1,4,-1,Material.PETRIFIED_OAK_SLAB));
        structure.register(new StairsBlockElement(-1,4,0,Material.OAK_STAIRS,BlockFace.EAST,Bisected.Half.BOTTOM,Stairs.Shape.STRAIGHT));
        structure.register(new SolidBlockElement(-1,4,1,Material.PETRIFIED_OAK_SLAB));
        structure.register(new StairsBlockElement(-1,5,-1,Material.OAK_STAIRS,BlockFace.SOUTH,Bisected.Half.TOP,Stairs.Shape.OUTER_LEFT));
        structure.register(new StairsBlockElement(-1,5,0,Material.OAK_STAIRS,BlockFace.EAST,Bisected.Half.TOP,Stairs.Shape.STRAIGHT));
        structure.register(new StairsBlockElement(-1,5,1,Material.OAK_STAIRS,BlockFace.NORTH,Bisected.Half.TOP,Stairs.Shape.OUTER_RIGHT));
        structure.register(new StairsBlockElement(-1,6,0,Material.OAK_STAIRS,BlockFace.EAST,Bisected.Half.BOTTOM,Stairs.Shape.STRAIGHT));
        structure.register(new SolidBlockElement(0,1,-1,Material.PETRIFIED_OAK_SLAB));
        structure.register(new SolidBlockElement(0,1,0,Material.PETRIFIED_OAK_SLAB));
        structure.register(new SolidBlockElement(0,1,1,Material.PETRIFIED_OAK_SLAB));
        structure.register(new SolidBlockElement(0,2,-1,Material.OAK_FENCE));
        structure.register(new SolidBlockElement(0,2,1,Material.OAK_FENCE));
        structure.register(new SolidBlockElement(0,3,-1,Material.COBBLESTONE));
        structure.register(new SolidBlockElement(0,3,1,Material.COBBLESTONE));
        structure.register(new StairsBlockElement(0,4,-1,Material.OAK_STAIRS,BlockFace.SOUTH,Bisected.Half.BOTTOM,Stairs.Shape.STRAIGHT));
        structure.register(new SolidBlockElement(0,4,0,Material.PETRIFIED_OAK_SLAB));
        structure.register(new StairsBlockElement(0,4,1,Material.OAK_STAIRS,BlockFace.NORTH,Bisected.Half.BOTTOM,Stairs.Shape.STRAIGHT));
        structure.register(new StairsBlockElement(0,5,-1,Material.OAK_STAIRS,BlockFace.SOUTH,Bisected.Half.TOP,Stairs.Shape.STRAIGHT));
        structure.register(new StairsBlockElement(0,5,1,Material.OAK_STAIRS,BlockFace.NORTH,Bisected.Half.TOP,Stairs.Shape.STRAIGHT));
        structure.register(new StairsBlockElement(0,6,-1,Material.OAK_STAIRS,BlockFace.SOUTH,Bisected.Half.BOTTOM,Stairs.Shape.STRAIGHT));
        structure.register(new SolidBlockElement(0,6,0,Material.OAK_PLANKS));
        structure.register(new StairsBlockElement(0,6,1,Material.OAK_STAIRS,BlockFace.NORTH,Bisected.Half.BOTTOM,Stairs.Shape.STRAIGHT));
        structure.register(new SolidBlockElement(1,1,-1,Material.OAK_LOG));
        structure.register(new SolidBlockElement(1,1,0,Material.PETRIFIED_OAK_SLAB));
        structure.register(new SolidBlockElement(1,1,1,Material.OAK_LOG));
        structure.register(new SolidBlockElement(1,2,-1,Material.OAK_LOG));
        structure.register(new SolidBlockElement(1,2,0,Material.OAK_FENCE));
        structure.register(new SolidBlockElement(1,2,1,Material.OAK_LOG));
        structure.register(new SolidBlockElement(1,3,-1,Material.COBBLESTONE));
        structure.register(new SolidBlockElement(1,3,0,Material.COBBLESTONE));
        structure.register(new SolidBlockElement(1,3,1,Material.COBBLESTONE));
        structure.register(new SolidBlockElement(1,4,-1,Material.PETRIFIED_OAK_SLAB));
        structure.register(new StairsBlockElement(1,4,0,Material.OAK_STAIRS,BlockFace.WEST,Bisected.Half.BOTTOM,Stairs.Shape.STRAIGHT));
        structure.register(new SolidBlockElement(1,4,1,Material.PETRIFIED_OAK_SLAB));
        structure.register(new StairsBlockElement(1,5,-1,Material.OAK_STAIRS,BlockFace.SOUTH,Bisected.Half.TOP,Stairs.Shape.OUTER_RIGHT));
        structure.register(new StairsBlockElement(1,5,0,Material.OAK_STAIRS,BlockFace.WEST,Bisected.Half.TOP,Stairs.Shape.STRAIGHT));
        structure.register(new StairsBlockElement(1,5,1,Material.OAK_STAIRS,BlockFace.NORTH,Bisected.Half.TOP,Stairs.Shape.OUTER_LEFT));
        structure.register(new StairsBlockElement(1,6,0,Material.OAK_STAIRS,BlockFace.WEST,Bisected.Half.BOTTOM,Stairs.Shape.STRAIGHT));
        LV2ArcherTower = structure;
        return structure;
    }

    private static TowerStructure LV3ArcherTower;
    private static TowerStructure LV3ArcherTower() {
        if (LV3ArcherTower != null) return LV3ArcherTower;
        TowerStructure structure = new TowerStructure();
        structure.register(new SolidBlockElement(-1,1,-1,Material.MOSSY_STONE_BRICK_WALL));
        structure.register(new SolidBlockElement(-1,1,0,Material.MOSSY_COBBLESTONE));
        structure.register(new SolidBlockElement(-1,1,1,Material.MOSSY_STONE_BRICK_WALL));
        structure.register(new SolidBlockElement(-1,2,-1,Material.MOSSY_STONE_BRICK_WALL));
        structure.register(new StairsBlockElement(-1,2,0,Material.POLISHED_ANDESITE_STAIRS,BlockFace.EAST,Bisected.Half.BOTTOM,Stairs.Shape.STRAIGHT));
        structure.register(new SolidBlockElement(-1,2,1,Material.MOSSY_STONE_BRICK_WALL));
        structure.register(new SolidBlockElement(-1,3,-1,Material.POLISHED_ANDESITE));
        structure.register(new StairsBlockElement(-1,3,0,Material.POLISHED_ANDESITE_STAIRS,BlockFace.EAST,Bisected.Half.TOP,Stairs.Shape.STRAIGHT));
        structure.register(new SolidBlockElement(-1,3,1,Material.POLISHED_ANDESITE));
        structure.register(new SolidBlockElement(-1,4,-1,Material.COBWEB));
        structure.register(new StairsBlockElement(-1,4,0,Material.POLISHED_ANDESITE_STAIRS,BlockFace.EAST,Bisected.Half.BOTTOM,Stairs.Shape.STRAIGHT));
        structure.register(new SolidBlockElement(-1,4,1,Material.STONE_BRICK_SLAB));
        structure.register(new StairsBlockElement(-1,5,-1,Material.POLISHED_ANDESITE_STAIRS,BlockFace.EAST,Bisected.Half.TOP,Stairs.Shape.OUTER_RIGHT));
        structure.register(new StairsBlockElement(-1,5,0,Material.POLISHED_ANDESITE_STAIRS,BlockFace.EAST,Bisected.Half.TOP,Stairs.Shape.STRAIGHT));
        structure.register(new StairsBlockElement(-1,5,1,Material.POLISHED_ANDESITE_STAIRS,BlockFace.EAST,Bisected.Half.TOP,Stairs.Shape.OUTER_LEFT));
        structure.register(new SolidBlockElement(-1,6,-1,Material.STONE_BRICK_SLAB));
        structure.register(new StairsBlockElement(-1,6,0,Material.POLISHED_ANDESITE_STAIRS,BlockFace.EAST,Bisected.Half.BOTTOM,Stairs.Shape.STRAIGHT));
        structure.register(new SolidBlockElement(-1,6,1,Material.COBWEB));
        structure.register(new SolidBlockElement(0,1,-1,Material.MOSSY_COBBLESTONE));
        structure.register(new SolidBlockElement(0,1,0,Material.OAK_PLANKS));
        structure.register(new SolidBlockElement(0,1,1,Material.MOSSY_COBBLESTONE));
        structure.register(new StairsBlockElement(0,2,-1,Material.POLISHED_ANDESITE_STAIRS,BlockFace.SOUTH,Bisected.Half.BOTTOM,Stairs.Shape.STRAIGHT));
        structure.register(new SolidBlockElement(0,2,0,Material.OAK_PLANKS));
        structure.register(new StairsBlockElement(0,2,1,Material.POLISHED_ANDESITE_STAIRS,BlockFace.NORTH,Bisected.Half.BOTTOM,Stairs.Shape.STRAIGHT));
        structure.register(new StairsBlockElement(0,3,-1,Material.POLISHED_ANDESITE_STAIRS,BlockFace.SOUTH,Bisected.Half.TOP,Stairs.Shape.STRAIGHT));
        structure.register(new SolidBlockElement(0,3,0,Material.OAK_PLANKS));
        structure.register(new StairsBlockElement(0,3,1,Material.POLISHED_ANDESITE_STAIRS,BlockFace.NORTH,Bisected.Half.TOP,Stairs.Shape.STRAIGHT));
        structure.register(new StairsBlockElement(0,4,-1,Material.POLISHED_ANDESITE_STAIRS,BlockFace.SOUTH,Bisected.Half.BOTTOM,Stairs.Shape.STRAIGHT));
        structure.register(new SolidBlockElement(0,4,0,Material.OAK_LOG));
        structure.register(new StairsBlockElement(0,4,1,Material.POLISHED_ANDESITE_STAIRS,BlockFace.NORTH,Bisected.Half.BOTTOM,Stairs.Shape.STRAIGHT));
        structure.register(new StairsBlockElement(0,5,-1,Material.POLISHED_ANDESITE_STAIRS,BlockFace.SOUTH,Bisected.Half.TOP,Stairs.Shape.STRAIGHT));
        structure.register(new SolidBlockElement(0,5,0,Material.OAK_LOG));
        structure.register(new StairsBlockElement(0,5,1,Material.POLISHED_ANDESITE_STAIRS,BlockFace.NORTH,Bisected.Half.TOP,Stairs.Shape.STRAIGHT));
        structure.register(new StairsBlockElement(0,6,-1,Material.POLISHED_ANDESITE_STAIRS,BlockFace.SOUTH,Bisected.Half.BOTTOM,Stairs.Shape.STRAIGHT));
        structure.register(new SolidBlockElement(0,6,0,Material.POLISHED_ANDESITE));
        structure.register(new StairsBlockElement(0,6,1,Material.OAK_STAIRS,BlockFace.NORTH,Bisected.Half.BOTTOM,Stairs.Shape.STRAIGHT));
        structure.register(new SolidBlockElement(1,1,-1,Material.MOSSY_STONE_BRICK_WALL));
        structure.register(new SolidBlockElement(1,1,0,Material.MOSSY_COBBLESTONE));
        structure.register(new SolidBlockElement(1,1,1,Material.MOSSY_STONE_BRICK_WALL));
        structure.register(new SolidBlockElement(1,2,-1,Material.MOSSY_STONE_BRICK_WALL));
        structure.register(new StairsBlockElement(1,2,0,Material.POLISHED_ANDESITE_STAIRS,BlockFace.WEST,Bisected.Half.BOTTOM,Stairs.Shape.STRAIGHT));
        structure.register(new SolidBlockElement(1,2,1,Material.MOSSY_STONE_BRICK_WALL));
        structure.register(new SolidBlockElement(1,3,-1,Material.POLISHED_ANDESITE));
        structure.register(new StairsBlockElement(1,3,0,Material.POLISHED_ANDESITE_STAIRS,BlockFace.WEST,Bisected.Half.TOP,Stairs.Shape.STRAIGHT));
        structure.register(new SolidBlockElement(1,3,1,Material.POLISHED_ANDESITE));
        structure.register(new SolidBlockElement(1,4,-1,Material.COBWEB));
        structure.register(new StairsBlockElement(1,4,0,Material.POLISHED_ANDESITE_STAIRS,BlockFace.WEST,Bisected.Half.BOTTOM,Stairs.Shape.STRAIGHT));
        structure.register(new SolidBlockElement(1,4,1,Material.STONE_BRICK_SLAB));
        structure.register(new StairsBlockElement(1,5,-1,Material.POLISHED_ANDESITE_STAIRS,BlockFace.SOUTH,Bisected.Half.TOP,Stairs.Shape.OUTER_RIGHT));
        structure.register(new StairsBlockElement(1,5,0,Material.POLISHED_ANDESITE_STAIRS,BlockFace.WEST,Bisected.Half.TOP,Stairs.Shape.STRAIGHT));
        structure.register(new StairsBlockElement(1,5,1,Material.POLISHED_ANDESITE_STAIRS,BlockFace.WEST,Bisected.Half.TOP,Stairs.Shape.OUTER_RIGHT));
        structure.register(new SolidBlockElement(1,6,-1,Material.COBWEB));
        structure.register(new StairsBlockElement(1,6,0,Material.POLISHED_ANDESITE_STAIRS,BlockFace.WEST,Bisected.Half.BOTTOM,Stairs.Shape.STRAIGHT));
        structure.register(new SolidBlockElement(1,6,1,Material.STONE_BRICK_SLAB));
        LV3ArcherTower = structure;
        return structure;
    }

    private static TowerStructure DariusTower;
    private static TowerStructure DariusTower() {
        if (DariusTower != null) return DariusTower;
        TowerStructure structure = new TowerStructure();
        structure.register(new StairsBlockElement(-1,1,-1,Material.JUNGLE_STAIRS,BlockFace.SOUTH,Bisected.Half.BOTTOM,Stairs.Shape.OUTER_LEFT));
        structure.register(new StairsBlockElement(-1,1,0,Material.JUNGLE_STAIRS,BlockFace.EAST,Bisected.Half.BOTTOM,Stairs.Shape.STRAIGHT));
        structure.register(new StairsBlockElement(-1,1,1,Material.JUNGLE_STAIRS,BlockFace.EAST,Bisected.Half.BOTTOM,Stairs.Shape.OUTER_LEFT));
        structure.register(new SolidBlockElement(-1,4,0,Material.COBBLESTONE_WALL));
        structure.register(new DirectionalBlockElement(-1,5,0,Material.HOPPER,BlockFace.EAST));
        structure.register(new StairsBlockElement(-1,7,0,Material.POLISHED_ANDESITE_STAIRS,BlockFace.EAST,Bisected.Half.TOP,Stairs.Shape.STRAIGHT));
        structure.register(new StairsBlockElement(0,1,-1,Material.JUNGLE_STAIRS,BlockFace.SOUTH,Bisected.Half.BOTTOM,Stairs.Shape.STRAIGHT));
        structure.register(new SolidBlockElement(0,1,0,Material.POLISHED_ANDESITE));
        structure.register(new StairsBlockElement(0,1,1,Material.JUNGLE_STAIRS,BlockFace.NORTH,Bisected.Half.BOTTOM,Stairs.Shape.STRAIGHT));
        structure.register(new DirectionalBlockElement(0,2,0,Material.ANVIL,BlockFace.WEST));
        structure.register(new SolidBlockElement(0,3,0,Material.CAULDRON));
        structure.register(new DirectionalBlockElement(0,4,0,Material.HOPPER,BlockFace.DOWN));
        structure.register(new DirectionalBlockElement(0,5,0,Material.DROPPER,BlockFace.SOUTH));
        structure.register(new DirectionalBlockElement(0,6,0,Material.OBSERVER,BlockFace.NORTH));
        structure.register(new StairsBlockElement(0,7,-1,Material.POLISHED_ANDESITE_STAIRS,BlockFace.SOUTH,Bisected.Half.TOP,Stairs.Shape.STRAIGHT));
        structure.register(new SolidBlockElement(0,7,0,Material.POLISHED_ANDESITE));
        structure.register(new StairsBlockElement(0,7,1,Material.POLISHED_ANDESITE_STAIRS,BlockFace.NORTH,Bisected.Half.TOP,Stairs.Shape.STRAIGHT));
        structure.register(new StairsBlockElement(1,1,-1,Material.JUNGLE_STAIRS,BlockFace.WEST,Bisected.Half.BOTTOM,Stairs.Shape.OUTER_LEFT));
        structure.register(new StairsBlockElement(1,1,0,Material.JUNGLE_STAIRS,BlockFace.WEST,Bisected.Half.BOTTOM,Stairs.Shape.STRAIGHT));
        structure.register(new StairsBlockElement(1,1,1,Material.JUNGLE_STAIRS,BlockFace.NORTH,Bisected.Half.BOTTOM,Stairs.Shape.OUTER_LEFT));
        structure.register(new SolidBlockElement(1,3,-1,Material.SPRUCE_FENCE));
        structure.register(new SolidBlockElement(1,4,-1,Material.COBBLESTONE_WALL));
        structure.register(new SolidBlockElement(1,4,0,Material.COBBLESTONE_WALL));
        structure.register(new SolidBlockElement(1,5,-1,Material.SPRUCE_FENCE));
        structure.register(new DirectionalBlockElement(1,5,0,Material.HOPPER,BlockFace.WEST));
        structure.register(new DirectionalBlockElement(1,6,-1,Material.ANVIL,BlockFace.NORTH));
        structure.register(new StairsBlockElement(1,7,0,Material.POLISHED_ANDESITE_STAIRS,BlockFace.WEST,Bisected.Half.TOP,Stairs.Shape.STRAIGHT));
        DariusTower = structure;
        return structure;
    }

    private static TowerStructure LV1SnowballTower;
    private static TowerStructure LV1SnowballTower() {
        if (LV1SnowballTower != null) return LV1SnowballTower;
        TowerStructure structure = new TowerStructure();
        structure.register(new SolidBlockElement(-1,1,-1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(-1,1,0,Material.SMOOTH_QUARTZ));
        structure.register(new SolidBlockElement(-1,1,1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(-1,2,-1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(-1,2,0,Material.SMOOTH_QUARTZ));
        structure.register(new SolidBlockElement(-1,2,1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(-1,3,-1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(-1,3,0,Material.LIGHT_BLUE_STAINED_GLASS_PANE));
        structure.register(new SolidBlockElement(-1,3,1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(-1,5,0,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(-1,6,0,Material.LIGHT_BLUE_STAINED_GLASS_PANE));
        structure.register(new SolidBlockElement(0,1,-1,Material.SMOOTH_QUARTZ));
        structure.register(new SolidBlockElement(0,1,0,Material.SMOOTH_QUARTZ));
        structure.register(new SolidBlockElement(0,1,1,Material.SMOOTH_QUARTZ));
        structure.register(new SolidBlockElement(0,2,-1,Material.SMOOTH_QUARTZ));
        structure.register(new SolidBlockElement(0,2,0,Material.SNOW_BLOCK));
        structure.register(new SolidBlockElement(0,2,1,Material.SMOOTH_QUARTZ));
        structure.register(new SolidBlockElement(0,3,-1,Material.LIGHT_BLUE_STAINED_GLASS_PANE));
        structure.register(new SolidBlockElement(0,3,0,Material.SNOW_BLOCK));
        structure.register(new SolidBlockElement(0,3,1,Material.LIGHT_BLUE_STAINED_GLASS_PANE));
        structure.register(new SolidBlockElement(0,4,0,Material.SNOW_BLOCK));
        structure.register(new SolidBlockElement(0,5,-1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(0,5,0,Material.SMOOTH_QUARTZ));
        structure.register(new SolidBlockElement(0,5,1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(0,6,-1,Material.LIGHT_BLUE_STAINED_GLASS_PANE));
        structure.register(new SolidBlockElement(0,6,0,Material.SNOW_BLOCK));
        structure.register(new SolidBlockElement(0,6,1,Material.LIGHT_BLUE_STAINED_GLASS_PANE));
        structure.register(new SolidBlockElement(1,1,-1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(1,1,0,Material.SMOOTH_QUARTZ));
        structure.register(new SolidBlockElement(1,1,1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(1,2,-1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(1,2,0,Material.SMOOTH_QUARTZ));
        structure.register(new SolidBlockElement(1,2,1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(1,3,-1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(1,3,0,Material.LIGHT_BLUE_STAINED_GLASS_PANE));
        structure.register(new SolidBlockElement(1,3,1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(1,5,0,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(1,6,0,Material.LIGHT_BLUE_STAINED_GLASS_PANE));
        LV1SnowballTower = structure;
        return structure;
    }

    private static TowerStructure LV2SnowballTower;
    private static TowerStructure LV2SnowballTower() {
        if (LV2SnowballTower != null) return LV2SnowballTower;
        TowerStructure structure = new TowerStructure();
        structure.register(new SolidBlockElement(-1,1,-1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(-1,1,0,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(-1,1,1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(-1,2,-1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(-1,2,0,Material.LIGHT_BLUE_STAINED_GLASS_PANE));
        structure.register(new SolidBlockElement(-1,2,1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(-1,3,-1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(-1,3,1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(-1,4,-1,Material.SMOOTH_QUARTZ_SLAB));
        structure.register(new SolidBlockElement(-1,4,0,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(-1,4,1,Material.SMOOTH_QUARTZ_SLAB));
        structure.register(new SolidBlockElement(-1,5,0,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(-1,6,0,Material.LIGHT_BLUE_STAINED_GLASS_PANE));
        structure.register(new SolidBlockElement(-1,7,0,Material.SMOOTH_QUARTZ));
        structure.register(new SolidBlockElement(0,1,-1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(0,1,0,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(0,1,1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(0,2,-1,Material.LIGHT_BLUE_STAINED_GLASS_PANE));
        structure.register(new SolidBlockElement(0,2,0,Material.SMOOTH_QUARTZ));
        structure.register(new SolidBlockElement(0,2,1,Material.LIGHT_BLUE_STAINED_GLASS_PANE));
        structure.register(new SolidBlockElement(0,3,-1,Material.LIGHT_BLUE_STAINED_GLASS_PANE));
        structure.register(new SolidBlockElement(0,3,0,Material.SMOOTH_QUARTZ));
        structure.register(new SolidBlockElement(0,3,1,Material.LIGHT_BLUE_STAINED_GLASS_PANE));
        structure.register(new SolidBlockElement(0,4,-1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(0,4,0,Material.SMOOTH_QUARTZ));
        structure.register(new SolidBlockElement(0,4,1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(0,5,-1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(0,5,0,Material.SMOOTH_QUARTZ));
        structure.register(new SolidBlockElement(0,5,1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(0,6,-1,Material.LIGHT_BLUE_STAINED_GLASS_PANE));
        structure.register(new SolidBlockElement(0,6,0,Material.SMOOTH_QUARTZ));
        structure.register(new SolidBlockElement(0,6,1,Material.LIGHT_BLUE_STAINED_GLASS_PANE));
        structure.register(new SolidBlockElement(0,7,-1,Material.SMOOTH_QUARTZ));
        structure.register(new SolidBlockElement(0,7,0,Material.SMOOTH_QUARTZ));
        structure.register(new SolidBlockElement(0,7,1,Material.SMOOTH_QUARTZ));
        structure.register(new SolidBlockElement(0,8,0,Material.SNOW_BLOCK));
        structure.register(new SolidBlockElement(1,1,-1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(1,1,0,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(1,1,1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(1,2,-1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(1,2,0,Material.LIGHT_BLUE_STAINED_GLASS_PANE));
        structure.register(new SolidBlockElement(1,2,1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(1,3,-1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(1,3,0,Material.LIGHT_BLUE_STAINED_GLASS_PANE));
        structure.register(new SolidBlockElement(1,3,1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(1,4,-1,Material.SMOOTH_QUARTZ_SLAB));
        structure.register(new SolidBlockElement(1,4,0,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(1,4,1,Material.SMOOTH_QUARTZ_SLAB));
        structure.register(new SolidBlockElement(1,5,0,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(1,6,0,Material.LIGHT_BLUE_STAINED_GLASS_PANE));
        structure.register(new SolidBlockElement(1,7,0,Material.SMOOTH_QUARTZ));
        LV2SnowballTower = structure;
        return structure;
    }

    private static TowerStructure LV3SnowballTower;
    private static TowerStructure LV3SnowballTower() {
        if (LV3SnowballTower != null) return LV3SnowballTower;
        TowerStructure structure = new TowerStructure();
        structure.register(new SolidBlockElement(-1,1,-1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(-1,1,0,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(-1,1,1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(-1,2,-1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(-1,2,0,Material.LIGHT_BLUE_STAINED_GLASS_PANE));
        structure.register(new SolidBlockElement(-1,2,1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(-1,3,-1,Material.LIGHT_BLUE_STAINED_GLASS));
        structure.register(new SolidBlockElement(-1,3,0,Material.LIGHT_BLUE_STAINED_GLASS_PANE));
        structure.register(new SolidBlockElement(-1,3,1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(-1,4,-1,Material.SMOOTH_QUARTZ_SLAB));
        structure.register(new SolidBlockElement(-1,4,0,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(-1,4,1,Material.SMOOTH_QUARTZ_SLAB));
        structure.register(new SolidBlockElement(-1,5,0,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(-1,6,0,Material.LIGHT_BLUE_STAINED_GLASS_PANE));
        structure.register(new SolidBlockElement(-1,7,0,Material.DIAMOND_BLOCK));
        structure.register(new SolidBlockElement(0,1,-1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(0,1,0,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(0,1,1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(0,2,-1,Material.LIGHT_BLUE_STAINED_GLASS_PANE));
        structure.register(new SolidBlockElement(0,2,0,Material.DIAMOND_BLOCK));
        structure.register(new SolidBlockElement(0,2,1,Material.LIGHT_BLUE_STAINED_GLASS_PANE));
        structure.register(new SolidBlockElement(0,3,-1,Material.LIGHT_BLUE_STAINED_GLASS_PANE));
        structure.register(new SolidBlockElement(0,3,0,Material.DIAMOND_BLOCK));
        structure.register(new SolidBlockElement(0,3,1,Material.LIGHT_BLUE_STAINED_GLASS_PANE));
        structure.register(new SolidBlockElement(0,4,-1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(0,4,0,Material.DIAMOND_BLOCK));
        structure.register(new SolidBlockElement(0,4,1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(0,5,-1,Material.LIGHT_BLUE_STAINED_GLASS));
        structure.register(new SolidBlockElement(0,5,0,Material.SMOOTH_QUARTZ));
        structure.register(new SolidBlockElement(0,5,1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(0,6,-1,Material.LIGHT_BLUE_STAINED_GLASS_PANE));
        structure.register(new SolidBlockElement(0,6,0,Material.SMOOTH_QUARTZ));
        structure.register(new SolidBlockElement(0,6,1,Material.LIGHT_BLUE_STAINED_GLASS_PANE));
        structure.register(new SolidBlockElement(0,7,-1,Material.DIAMOND_BLOCK));
        structure.register(new SolidBlockElement(0,7,0,Material.SMOOTH_QUARTZ));
        structure.register(new SolidBlockElement(0,7,1,Material.DIAMOND_BLOCK));
        structure.register(new SolidBlockElement(0,8,0,Material.SMOOTH_QUARTZ));
        structure.register(new SolidBlockElement(1,1,-1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(1,1,0,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(1,1,1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(1,2,-1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(1,2,0,Material.LIGHT_BLUE_STAINED_GLASS_PANE));
        structure.register(new SolidBlockElement(1,2,1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(1,3,-1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(1,3,0,Material.LIGHT_BLUE_STAINED_GLASS_PANE));
        structure.register(new SolidBlockElement(1,3,1,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(1,4,-1,Material.SMOOTH_QUARTZ_SLAB));
        structure.register(new SolidBlockElement(1,4,0,Material.LIGHT_BLUE_STAINED_GLASS));
        structure.register(new SolidBlockElement(1,4,1,Material.SMOOTH_QUARTZ_SLAB));
        structure.register(new SolidBlockElement(1,5,0,Material.PACKED_ICE));
        structure.register(new SolidBlockElement(1,6,0,Material.LIGHT_BLUE_STAINED_GLASS_PANE));
        structure.register(new SolidBlockElement(1,7,0,Material.DIAMOND_BLOCK));
        LV3SnowballTower = structure;
        return structure;
    }

    private static TowerStructure LV1PotionTower;
    private static TowerStructure LV1PotionTower() {
        if (LV1PotionTower != null) return LV1PotionTower;
        TowerStructure structure = new TowerStructure();
        structure.register(new SolidBlockElement(-1,1,-1,Material.IRON_BARS));
        structure.register(new SolidBlockElement(-1,1,0,Material.MOSSY_STONE_BRICKS));
        structure.register(new SolidBlockElement(-1,1,1,Material.IRON_BARS));
        structure.register(new SolidBlockElement(-1,2,0,Material.GREEN_STAINED_GLASS));
        structure.register(new SolidBlockElement(-1,3,0,Material.GREEN_STAINED_GLASS));
        structure.register(new SolidBlockElement(-1,4,-1,Material.COBWEB));
        structure.register(new SolidBlockElement(-1,4,0,Material.MOSSY_STONE_BRICKS));
        structure.register(new SolidBlockElement(-1,5,0,Material.COBWEB));
        structure.register(new SolidBlockElement(-1,6,0,Material.COBWEB));
        structure.register(new SolidBlockElement(0,1,-1,Material.MOSSY_STONE_BRICKS));
        structure.register(new SolidBlockElement(0,1,0,Material.COARSE_DIRT));
        structure.register(new SolidBlockElement(0,1,1,Material.MOSSY_STONE_BRICKS));
        structure.register(new SolidBlockElement(0,2,-1,Material.GREEN_STAINED_GLASS));
        structure.register(new SolidBlockElement(0,2,0,Material.GREEN_TERRACOTTA));
        structure.register(new SolidBlockElement(0,2,1,Material.GREEN_STAINED_GLASS));
        structure.register(new SolidBlockElement(0,3,-1,Material.GREEN_STAINED_GLASS));
        structure.register(new SolidBlockElement(0,3,0,Material.GREEN_TERRACOTTA));
        structure.register(new SolidBlockElement(0,3,1,Material.GREEN_STAINED_GLASS));
        structure.register(new SolidBlockElement(0,4,-1,Material.MOSSY_STONE_BRICKS));
        structure.register(new SolidBlockElement(0,4,0,Material.MOSSY_STONE_BRICKS));
        structure.register(new SolidBlockElement(0,4,1,Material.MOSSY_STONE_BRICKS));
        structure.register(new SolidBlockElement(0,5,-1,Material.IRON_BARS));
        structure.register(new SolidBlockElement(0,5,0,Material.MOSSY_STONE_BRICKS));
        structure.register(new SolidBlockElement(0,5,1,Material.IRON_BARS));
        structure.register(new SolidBlockElement(0,6,-1,Material.IRON_BARS));
        structure.register(new SolidBlockElement(0,6,0,Material.MOSSY_STONE_BRICKS));
        structure.register(new SolidBlockElement(0,6,1,Material.IRON_BARS));
        structure.register(new SolidBlockElement(0,7,0,Material.COBWEB));
        structure.register(new SolidBlockElement(1,1,-1,Material.IRON_BARS));
        structure.register(new SolidBlockElement(1,1,0,Material.MOSSY_STONE_BRICKS));
        structure.register(new SolidBlockElement(1,1,1,Material.COBWEB));
        structure.register(new SolidBlockElement(1,2,0,Material.GREEN_STAINED_GLASS));
        structure.register(new SolidBlockElement(1,2,1,Material.VINE));
        structure.register(new SolidBlockElement(1,3,-1,Material.COBWEB));
        structure.register(new SolidBlockElement(1,3,0,Material.GREEN_STAINED_GLASS));
        structure.register(new SolidBlockElement(1,3,1,Material.VINE));
        structure.register(new SolidBlockElement(1,4,-1,Material.VINE));
        structure.register(new SolidBlockElement(1,4,0,Material.MOSSY_STONE_BRICKS));
        structure.register(new SolidBlockElement(1,4,1,Material.VINE));
        structure.register(new SolidBlockElement(1,5,0,Material.VINE));
        structure.register(new SolidBlockElement(1,8,0,Material.COBWEB));
        LV1PotionTower = structure;
        return structure;
    }

    private static TowerStructure LV2PotionTower;
    private static TowerStructure LV2PotionTower() {
        if (LV2PotionTower != null) return LV2PotionTower;
        TowerStructure structure = new TowerStructure();
        structure.register(new SolidBlockElement(-1,1,-1,Material.SPRUCE_FENCE));
        structure.register(new SolidBlockElement(-1,1,0,Material.MOSSY_STONE_BRICKS));
        structure.register(new SolidBlockElement(-1,1,1,Material.SPRUCE_FENCE));
        structure.register(new SolidBlockElement(-1,2,-1,Material.SPRUCE_FENCE));
        structure.register(new SolidBlockElement(-1,2,0,Material.GREEN_STAINED_GLASS));
        structure.register(new SolidBlockElement(-1,2,1,Material.SPRUCE_LEAVES));
        structure.register(new SolidBlockElement(-1,3,-1,Material.SPRUCE_LEAVES));
        structure.register(new SolidBlockElement(-1,3,0,Material.GREEN_STAINED_GLASS));
        structure.register(new SolidBlockElement(-1,3,1,Material.SPRUCE_LEAVES));
        structure.register(new SolidBlockElement(-1,4,-1,Material.SPRUCE_FENCE));
        structure.register(new SolidBlockElement(-1,4,0,Material.MOSSY_STONE_BRICKS));
        structure.register(new SolidBlockElement(-1,4,1,Material.SPRUCE_FENCE));
        structure.register(new SolidBlockElement(-1,5,0,Material.SPRUCE_LEAVES));
        structure.register(new SolidBlockElement(-1,6,0,Material.COBWEB));
        structure.register(new SolidBlockElement(0,1,-1,Material.MOSSY_STONE_BRICKS));
        structure.register(new SolidBlockElement(0,1,0,Material.COARSE_DIRT));
        structure.register(new SolidBlockElement(0,1,1,Material.MOSSY_STONE_BRICKS));
        structure.register(new SolidBlockElement(0,2,-1,Material.GREEN_STAINED_GLASS));
        structure.register(new SolidBlockElement(0,2,0,Material.GREEN_TERRACOTTA));
        structure.register(new SolidBlockElement(0,2,1,Material.GREEN_STAINED_GLASS));
        structure.register(new SolidBlockElement(0,3,-1,Material.GREEN_STAINED_GLASS));
        structure.register(new SolidBlockElement(0,3,0,Material.GREEN_TERRACOTTA));
        structure.register(new SolidBlockElement(0,3,1,Material.GREEN_STAINED_GLASS));
        structure.register(new SolidBlockElement(0,4,-1,Material.MOSSY_STONE_BRICKS));
        structure.register(new SolidBlockElement(0,4,0,Material.MOSSY_STONE_BRICKS));
        structure.register(new SolidBlockElement(0,4,1,Material.MOSSY_STONE_BRICKS));
        structure.register(new SolidBlockElement(0,5,-1,Material.IRON_BARS));
        structure.register(new SolidBlockElement(0,5,0,Material.MOSSY_STONE_BRICKS));
        structure.register(new SolidBlockElement(0,5,1,Material.IRON_BARS));
        structure.register(new SolidBlockElement(0,6,-1,Material.IRON_BARS));
        structure.register(new SolidBlockElement(0,6,0,Material.MOSSY_STONE_BRICKS));
        structure.register(new SolidBlockElement(0,6,1,Material.IRON_BARS));
        structure.register(new SolidBlockElement(0,7,0,Material.COBWEB));
        structure.register(new SolidBlockElement(1,1,-1,Material.SPRUCE_FENCE));
        structure.register(new SolidBlockElement(1,1,0,Material.MOSSY_STONE_BRICKS));
        structure.register(new SolidBlockElement(1,1,1,Material.SPRUCE_FENCE));
        structure.register(new SolidBlockElement(1,2,-1,Material.SPRUCE_FENCE));
        structure.register(new SolidBlockElement(1,2,0,Material.GREEN_STAINED_GLASS));
        structure.register(new SolidBlockElement(1,2,1,Material.SPRUCE_LEAVES));
        structure.register(new SolidBlockElement(1,3,-1,Material.SPRUCE_FENCE));
        structure.register(new SolidBlockElement(1,3,0,Material.GREEN_STAINED_GLASS));
        structure.register(new SolidBlockElement(1,3,1,Material.SPRUCE_FENCE));
        structure.register(new SolidBlockElement(1,4,-1,Material.SPRUCE_LEAVES));
        structure.register(new SolidBlockElement(1,4,0,Material.MOSSY_STONE_BRICKS));
        structure.register(new SolidBlockElement(1,4,1,Material.SPRUCE_FENCE));
        structure.register(new SolidBlockElement(1,5,0,Material.VINE));
        structure.register(new DirectionalBlockElement(1,6,0,Material.GREEN_WALL_BANNER,BlockFace.EAST));
        structure.register(new SolidBlockElement(1,8,0,Material.COBWEB));
        LV2PotionTower = structure;
        return structure;
    }

    private static TowerStructure LV3PotionTower;
    private static TowerStructure LV3PotionTower() {
        if (LV3PotionTower != null) return LV3PotionTower;
        TowerStructure structure = new TowerStructure();
        structure.register(new SolidBlockElement(-1,1,-1,Material.MOSSY_STONE_BRICK_WALL));
        structure.register(new SolidBlockElement(-1,1,0,Material.MOSSY_STONE_BRICKS));
        structure.register(new SolidBlockElement(-1,1,1,Material.MOSSY_STONE_BRICK_WALL));
        structure.register(new SolidBlockElement(-1,2,-1,Material.MOSSY_STONE_BRICK_WALL));
        structure.register(new SolidBlockElement(-1,2,0,Material.LIME_STAINED_GLASS));
        structure.register(new SolidBlockElement(-1,2,1,Material.SPRUCE_LEAVES));
        structure.register(new SolidBlockElement(-1,3,-1,Material.SPRUCE_LEAVES));
        structure.register(new SolidBlockElement(-1,3,0,Material.GREEN_STAINED_GLASS));
        structure.register(new SolidBlockElement(-1,3,1,Material.SPRUCE_LEAVES));
        structure.register(new SolidBlockElement(-1,4,-1,Material.MOSSY_STONE_BRICK_WALL));
        structure.register(new SolidBlockElement(-1,4,0,Material.MOSSY_STONE_BRICKS));
        structure.register(new SolidBlockElement(-1,4,1,Material.MOSSY_STONE_BRICK_WALL));
        structure.register(new SolidBlockElement(-1,5,0,Material.SPRUCE_LEAVES));
        structure.register(new SolidBlockElement(-1,6,0,Material.COBWEB));
        structure.register(new SolidBlockElement(-1,7,0,Material.GREEN_CONCRETE));
        structure.register(new SolidBlockElement(0,1,-1,Material.MOSSY_STONE_BRICKS));
        structure.register(new SolidBlockElement(0,1,0,Material.COARSE_DIRT));
        structure.register(new SolidBlockElement(0,1,1,Material.MOSSY_STONE_BRICKS));
        structure.register(new SolidBlockElement(0,2,-1,Material.LIME_STAINED_GLASS));
        structure.register(new SolidBlockElement(0,2,0,Material.GREEN_TERRACOTTA));
        structure.register(new SolidBlockElement(0,2,1,Material.LIME_STAINED_GLASS));
        structure.register(new SolidBlockElement(0,3,-1,Material.GREEN_STAINED_GLASS));
        structure.register(new SolidBlockElement(0,3,0,Material.GREEN_TERRACOTTA));
        structure.register(new SolidBlockElement(0,3,1,Material.GREEN_STAINED_GLASS));
        structure.register(new SolidBlockElement(0,4,-1,Material.GREEN_CONCRETE));
        structure.register(new SolidBlockElement(0,4,0,Material.MOSSY_STONE_BRICKS));
        structure.register(new SolidBlockElement(0,4,1,Material.GREEN_CONCRETE));
        structure.register(new SolidBlockElement(0,5,-1,Material.IRON_BARS));
        structure.register(new SolidBlockElement(0,5,0,Material.MOSSY_STONE_BRICKS));
        structure.register(new SolidBlockElement(0,5,1,Material.IRON_BARS));
        structure.register(new SolidBlockElement(0,6,-1,Material.IRON_BARS));
        structure.register(new SolidBlockElement(0,6,0,Material.MOSSY_STONE_BRICKS));
        structure.register(new SolidBlockElement(0,6,1,Material.IRON_BARS));
        structure.register(new SolidBlockElement(0,7,-1,Material.GREEN_CONCRETE));
        structure.register(new SolidBlockElement(0,7,0,Material.COBWEB));
        structure.register(new SolidBlockElement(0,7,1,Material.GREEN_CONCRETE));
        structure.register(new SolidBlockElement(0,8,0,Material.COBWEB));
        structure.register(new SolidBlockElement(1,1,-1,Material.MOSSY_STONE_BRICK_WALL));
        structure.register(new SolidBlockElement(1,1,0,Material.MOSSY_STONE_BRICKS));
        structure.register(new SolidBlockElement(1,1,1,Material.MOSSY_STONE_BRICK_WALL));
        structure.register(new SolidBlockElement(1,2,-1,Material.MOSSY_STONE_BRICK_WALL));
        structure.register(new SolidBlockElement(1,2,0,Material.GREEN_STAINED_GLASS));
        structure.register(new SolidBlockElement(1,2,1,Material.MOSSY_STONE_BRICK_WALL));
        structure.register(new SolidBlockElement(1,3,-1,Material.MOSSY_STONE_BRICK_WALL));
        structure.register(new SolidBlockElement(1,3,0,Material.LIME_STAINED_GLASS));
        structure.register(new SolidBlockElement(1,3,1,Material.MOSSY_STONE_BRICK_WALL));
        structure.register(new SolidBlockElement(1,4,-1,Material.SPRUCE_LEAVES));
        structure.register(new SolidBlockElement(1,4,0,Material.MOSSY_STONE_BRICKS));
        structure.register(new SolidBlockElement(1,4,1,Material.SPRUCE_LEAVES));
        structure.register(new SolidBlockElement(1,5,0,Material.POTTED_WITHER_ROSE));
        structure.register(new DirectionalBlockElement(1,6,0,Material.GREEN_WALL_BANNER,BlockFace.EAST));
        structure.register(new SolidBlockElement(1,7,0,Material.GREEN_CONCRETE));
        structure.register(new SolidBlockElement(1,8,0,Material.COBWEB));
        LV3PotionTower = structure;
        return structure;
    }

    private static TowerStructure LV1FireTower;
    private static TowerStructure LV1FireTower() {
        if (LV1FireTower != null) return LV1FireTower;
        TowerStructure structure = new TowerStructure();
        structure.register(new SolidBlockElement(-1,1,0,Material.CHISELED_NETHER_BRICKS));
        structure.register(new SolidBlockElement(-1,2,0,Material.RED_STAINED_GLASS));
        structure.register(new SolidBlockElement(-1,3,0,Material.RED_STAINED_GLASS));
        structure.register(new SolidBlockElement(-1,4,-1,Material.RED_NETHER_BRICK_SLAB));
        structure.register(new SolidBlockElement(-1,4,0,Material.RED_CONCRETE));
        structure.register(new SolidBlockElement(-1,4,1,Material.RED_NETHER_BRICK_SLAB));
        structure.register(new SolidBlockElement(-1,5,0,Material.RED_NETHER_BRICK_SLAB));
        structure.register(new SolidBlockElement(0,1,-1,Material.CHISELED_NETHER_BRICKS));
        structure.register(new SolidBlockElement(0,1,0,Material.CHISELED_NETHER_BRICKS));
        structure.register(new SolidBlockElement(0,1,1,Material.CHISELED_NETHER_BRICKS));
        structure.register(new SolidBlockElement(0,2,-1,Material.RED_STAINED_GLASS));
        structure.register(new SolidBlockElement(0,2,0,Material.RED_CONCRETE));
        structure.register(new SolidBlockElement(0,2,1,Material.RED_STAINED_GLASS));
        structure.register(new SolidBlockElement(0,3,-1,Material.RED_STAINED_GLASS));
        structure.register(new SolidBlockElement(0,3,0,Material.RED_CONCRETE));
        structure.register(new SolidBlockElement(0,3,1,Material.RED_STAINED_GLASS));
        structure.register(new SolidBlockElement(0,4,-1,Material.RED_CONCRETE));
        structure.register(new SolidBlockElement(0,4,0,Material.NETHERRACK));
        structure.register(new SolidBlockElement(0,4,1,Material.RED_CONCRETE));
        structure.register(new SolidBlockElement(0,5,-1,Material.RED_NETHER_BRICK_SLAB));
        structure.register(new SolidBlockElement(0,5,0,Material.FIRE));
        structure.register(new SolidBlockElement(0,5,1,Material.RED_NETHER_BRICK_SLAB));
        structure.register(new SolidBlockElement(1,1,0,Material.CHISELED_NETHER_BRICKS));
        structure.register(new SolidBlockElement(1,2,0,Material.RED_STAINED_GLASS));
        structure.register(new SolidBlockElement(1,3,0,Material.RED_STAINED_GLASS));
        structure.register(new SolidBlockElement(1,4,-1,Material.RED_NETHER_BRICK_SLAB));
        structure.register(new SolidBlockElement(1,4,0,Material.RED_CONCRETE));
        structure.register(new SolidBlockElement(1,4,1,Material.RED_NETHER_BRICK_SLAB));
        structure.register(new SolidBlockElement(1,5,0,Material.RED_NETHER_BRICK_SLAB));
        LV1FireTower = structure;
        return structure;
    }

    private static TowerStructure LV2FireTower;
    private static TowerStructure LV2FireTower() {
        if (LV2FireTower != null) return LV2FireTower;
        TowerStructure structure = new TowerStructure();
        structure.register(new SolidBlockElement(-1,1,-1,Material.NETHER_BRICK_FENCE));
        structure.register(new SolidBlockElement(-1,1,0,Material.CHISELED_NETHER_BRICKS));
        structure.register(new SolidBlockElement(-1,1,1,Material.NETHER_BRICK_FENCE));
        structure.register(new SolidBlockElement(-1,2,-1,Material.NETHER_BRICK_FENCE));
        structure.register(new SolidBlockElement(-1,2,0,Material.RED_STAINED_GLASS));
        structure.register(new SolidBlockElement(-1,2,1,Material.NETHER_BRICK_FENCE));
        structure.register(new SolidBlockElement(-1,3,-1,Material.NETHER_BRICK_FENCE));
        structure.register(new SolidBlockElement(-1,3,0,Material.MAGMA_BLOCK));
        structure.register(new SolidBlockElement(-1,3,1,Material.NETHER_BRICK_FENCE));
        structure.register(new SolidBlockElement(-1,4,-1,Material.RED_NETHER_BRICK_SLAB));
        structure.register(new SolidBlockElement(-1,4,0,Material.RED_CONCRETE));
        structure.register(new SolidBlockElement(-1,4,1,Material.RED_NETHER_BRICK_SLAB));
        structure.register(new SolidBlockElement(-1,5,0,Material.RED_NETHER_BRICK_SLAB));
        structure.register(new SolidBlockElement(0,1,-1,Material.CHISELED_NETHER_BRICKS));
        structure.register(new SolidBlockElement(0,1,0,Material.CHISELED_NETHER_BRICKS));
        structure.register(new SolidBlockElement(0,1,1,Material.CHISELED_NETHER_BRICKS));
        structure.register(new SolidBlockElement(0,2,-1,Material.RED_STAINED_GLASS));
        structure.register(new SolidBlockElement(0,2,0,Material.RED_CONCRETE));
        structure.register(new SolidBlockElement(0,2,1,Material.RED_STAINED_GLASS));
        structure.register(new SolidBlockElement(0,3,-1,Material.MAGMA_BLOCK));
        structure.register(new SolidBlockElement(0,3,0,Material.RED_CONCRETE));
        structure.register(new SolidBlockElement(0,3,1,Material.MAGMA_BLOCK));
        structure.register(new SolidBlockElement(0,4,-1,Material.MAGMA_BLOCK));
        structure.register(new SolidBlockElement(0,4,0,Material.NETHERRACK));
        structure.register(new SolidBlockElement(0,4,1,Material.MAGMA_BLOCK));
        structure.register(new SolidBlockElement(0,5,-1,Material.RED_NETHER_BRICK_SLAB));
        structure.register(new SolidBlockElement(0,5,0,Material.FIRE));
        structure.register(new SolidBlockElement(0,5,1,Material.RED_NETHER_BRICK_SLAB));
        structure.register(new SolidBlockElement(1,1,-1,Material.NETHER_BRICK_FENCE));
        structure.register(new SolidBlockElement(1,1,0,Material.CHISELED_NETHER_BRICKS));
        structure.register(new SolidBlockElement(1,1,1,Material.NETHER_BRICK_FENCE));
        structure.register(new SolidBlockElement(1,2,-1,Material.NETHER_BRICK_FENCE));
        structure.register(new SolidBlockElement(1,2,0,Material.MAGMA_BLOCK));
        structure.register(new SolidBlockElement(1,2,1,Material.NETHER_BRICK_FENCE));
        structure.register(new SolidBlockElement(1,3,-1,Material.NETHER_BRICK_FENCE));
        structure.register(new SolidBlockElement(1,3,0,Material.RED_STAINED_GLASS));
        structure.register(new SolidBlockElement(1,3,1,Material.NETHER_BRICK_FENCE));
        structure.register(new SolidBlockElement(1,4,-1,Material.RED_NETHER_BRICK_SLAB));
        structure.register(new SolidBlockElement(1,4,0,Material.RED_CONCRETE));
        structure.register(new SolidBlockElement(1,4,1,Material.RED_NETHER_BRICK_SLAB));
        structure.register(new SolidBlockElement(1,5,0,Material.RED_NETHER_BRICK_SLAB));
        LV2FireTower = structure;
        return structure;
    }

    private static TowerStructure LV3FireTower;
    private static TowerStructure LV3FireTower() {
        if (LV3FireTower != null) return LV3FireTower;
        TowerStructure structure = new TowerStructure();
        structure.register(new SolidBlockElement(-1,1,-1,Material.NETHER_BRICK_WALL));
        structure.register(new SolidBlockElement(-1,1,0,Material.CHISELED_NETHER_BRICKS));
        structure.register(new SolidBlockElement(-1,1,1,Material.NETHER_BRICK_WALL));
        structure.register(new SolidBlockElement(-1,2,-1,Material.NETHER_BRICK_WALL));
        structure.register(new SolidBlockElement(-1,2,0,Material.RED_STAINED_GLASS));
        structure.register(new SolidBlockElement(-1,2,1,Material.NETHER_BRICK_WALL));
        structure.register(new SolidBlockElement(-1,3,-1,Material.NETHER_BRICK_WALL));
        structure.register(new SolidBlockElement(-1,3,0,Material.MAGMA_BLOCK));
        structure.register(new SolidBlockElement(-1,3,1,Material.NETHER_BRICK_WALL));
        structure.register(new SolidBlockElement(-1,4,-1,Material.RED_NETHER_BRICK_SLAB));
        structure.register(new SolidBlockElement(-1,4,0,Material.RED_CONCRETE));
        structure.register(new SolidBlockElement(-1,4,1,Material.RED_NETHER_BRICK_SLAB));
        structure.register(new SolidBlockElement(-1,5,-1,Material.NETHER_BRICK_WALL));
        structure.register(new SolidBlockElement(-1,5,0,Material.RED_NETHER_BRICK_SLAB));
        structure.register(new SolidBlockElement(-1,5,1,Material.NETHER_BRICK_WALL));
        structure.register(new SolidBlockElement(-1,6,-1,Material.NETHER_BRICK_WALL));
        structure.register(new SolidBlockElement(-1,6,0,Material.RED_STAINED_GLASS));
        structure.register(new SolidBlockElement(-1,6,1,Material.NETHER_BRICK_WALL));
        structure.register(new SolidBlockElement(0,1,-1,Material.CHISELED_NETHER_BRICKS));
        structure.register(new SolidBlockElement(0,1,0,Material.CHISELED_NETHER_BRICKS));
        structure.register(new SolidBlockElement(0,1,1,Material.CHISELED_NETHER_BRICKS));
        structure.register(new SolidBlockElement(0,2,-1,Material.RED_STAINED_GLASS));
        structure.register(new SolidBlockElement(0,2,0,Material.RED_CONCRETE));
        structure.register(new SolidBlockElement(0,2,1,Material.RED_STAINED_GLASS));
        structure.register(new SolidBlockElement(0,3,-1,Material.MAGMA_BLOCK));
        structure.register(new SolidBlockElement(0,3,0,Material.RED_CONCRETE));
        structure.register(new SolidBlockElement(0,3,1,Material.MAGMA_BLOCK));
        structure.register(new SolidBlockElement(0,4,-1,Material.MAGMA_BLOCK));
        structure.register(new SolidBlockElement(0,4,0,Material.NETHERRACK));
        structure.register(new SolidBlockElement(0,4,1,Material.MAGMA_BLOCK));
        structure.register(new SolidBlockElement(0,5,-1,Material.RED_NETHER_BRICK_SLAB));
        structure.register(new SolidBlockElement(0,5,0,Material.FIRE));
        structure.register(new SolidBlockElement(0,5,1,Material.RED_NETHER_BRICK_SLAB));
        structure.register(new SolidBlockElement(0,6,-1,Material.RED_STAINED_GLASS));
        structure.register(new SolidBlockElement(0,6,0,Material.RED_STAINED_GLASS));
        structure.register(new SolidBlockElement(0,6,1,Material.RED_STAINED_GLASS));
        structure.register(new SolidBlockElement(0,7,0,Material.RED_STAINED_GLASS));
        structure.register(new SolidBlockElement(1,1,-1,Material.NETHER_BRICK_WALL));
        structure.register(new SolidBlockElement(1,1,0,Material.CHISELED_NETHER_BRICKS));
        structure.register(new SolidBlockElement(1,1,1,Material.NETHER_BRICK_WALL));
        structure.register(new SolidBlockElement(1,2,-1,Material.NETHER_BRICK_WALL));
        structure.register(new SolidBlockElement(1,2,0,Material.MAGMA_BLOCK));
        structure.register(new SolidBlockElement(1,2,1,Material.NETHER_BRICK_WALL));
        structure.register(new SolidBlockElement(1,3,-1,Material.NETHER_BRICK_WALL));
        structure.register(new SolidBlockElement(1,3,0,Material.RED_STAINED_GLASS));
        structure.register(new SolidBlockElement(1,3,1,Material.NETHER_BRICK_WALL));
        structure.register(new SolidBlockElement(1,4,-1,Material.RED_NETHER_BRICK_SLAB));
        structure.register(new SolidBlockElement(1,4,0,Material.RED_CONCRETE));
        structure.register(new SolidBlockElement(1,4,1,Material.RED_NETHER_BRICK_SLAB));
        structure.register(new SolidBlockElement(1,5,-1,Material.NETHER_BRICK_WALL));
        structure.register(new SolidBlockElement(1,5,0,Material.RED_NETHER_BRICK_SLAB));
        structure.register(new SolidBlockElement(1,5,1,Material.NETHER_BRICK_WALL));
        structure.register(new SolidBlockElement(1,6,-1,Material.NETHER_BRICK_WALL));
        structure.register(new SolidBlockElement(1,6,0,Material.RED_STAINED_GLASS));
        structure.register(new SolidBlockElement(1,6,1,Material.NETHER_BRICK_WALL));
        LV3FireTower = structure;
        return structure;
    }


}
