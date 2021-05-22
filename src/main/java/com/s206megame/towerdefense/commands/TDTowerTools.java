package com.s206megame.towerdefense.commands;

import com.s206megame.towerdefense.api.TowerSlot;
import com.s206megame.towerdefense.player.PlayerDataManager;
import com.s206megame.towerdefense.tower.*;
import com.s206megame.towerdefense.tower.attack.DariusTower;
import com.s206megame.towerdefense.tower.attack.ExplosionTower;
import com.s206megame.towerdefense.tower.attack.FireTower;
import com.s206megame.towerdefense.tower.attack.PotionTower;
import com.s206megame.towerdefense.tower.range.ArcherTower;
import com.s206megame.towerdefense.tower.range.LongbowTower;
import com.s206megame.towerdefense.tower.range.SniperTower;
import com.s206megame.towerdefense.tower.speed.CrossbowTower;
import com.s206megame.towerdefense.tower.speed.MinigunTower;
import com.s206megame.towerdefense.tower.speed.SnowballTower;
import com.s206megame.towerdefense.utils.ParticleManager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Directional;
import org.bukkit.block.data.MultipleFacing;
import org.bukkit.block.data.type.Stairs;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.*;

public class TDTowerTools implements TDCommandBase {

    @Override
    public String getCommandName() {
        return "tower";
    }

    @Override
    public List<String> getAliases() {
        return new ArrayList<>();
    }

    @Override
    public void run(Player player, String[] arg) {
        ArrayList<Tower> towers = new ArrayList<>();
        towers.add(new SnowballTower());
        towers.add(new MinigunTower());
        towers.add(new CrossbowTower());
        towers.add(new SniperTower());
        towers.add(new LongbowTower());
        towers.add(new ArcherTower());
        towers.add(new PotionTower());
        towers.add(new FireTower());
        towers.add(new ExplosionTower());
        towers.add(new DariusTower());
        for (Tower t : towers) {
            //防禦塔名稱	射程	單次攻擊	攻擊頻率 每...tick打一下 (= 50ms)
            for (int level = 1; level <= t.getMaxLevel(); level++) {
                t.setLevel(level);
                System.out.println(t.getTitle()+"\t"+t.getRange()+"\t"+t.getDamage()+"\t"+t.getHitDelay()+"\t"+t.getPrice(level));
            }
        }
        /*int mx = Integer.parseInt(arg[0]);
        int my = Integer.parseInt(arg[1]);
        int mz = Integer.parseInt(arg[2]);
        int ax = Integer.parseInt(arg[3]);
        int ay = Integer.parseInt(arg[4]);
        int az = Integer.parseInt(arg[5]);
        int middlex = (mx + ax) / 2;
        int middley = 3;
        int middlez = (mz + az) / 2;
        World w = player.getLocation().getWorld();
        for (int x = Math.min(mx, ax); x <= Math.max(mx, ax); x++) {
            for (int y = Math.min(my, ay); y <= Math.max(my, ay); y++) {
                for (int z = Math.min(mz, az); z <= Math.max(mz, az); z++) {
                    Block block = w.getBlockAt(x, y, z);
                    if (block.getType().equals(Material.AIR)) continue;
                    int dx = x - middlex;
                    int dz = z - middlez;
                    int dy = y - middley;
                    if (block.getBlockData() instanceof Stairs) {
                        System.out.println("structure.register(new StairsBlockElement(" + dx + "," + dy + "," + dz + "," +
                                "Material." + block.getType().name().toUpperCase() + ",BlockFace." + ((Directional)
                                block.getBlockData()).getFacing().name().toUpperCase() + ",Bisected.Half." +
                                ((Stairs) block.getBlockData()).getHalf().name().toUpperCase() + ",Stairs.Shape."
                                + ((Stairs) block.getBlockData()).getShape().name().toUpperCase() + "));");
                    } else if (block.getBlockData() instanceof Directional) {
                        System.out.println("structure.register(new DirectionalBlockElement(" + dx + "," + dy + "," + dz + ",Material." + block.getType().name().toUpperCase() + ",BlockFace." + ((Directional) block.getBlockData()).getFacing().name().toUpperCase() + "));");
                    } else if (block.getBlockData() instanceof MultipleFacing) {
                        MultipleFacing data = ((MultipleFacing) block.getBlockData());
                        boolean north = false;
                        boolean south = false;
                        boolean east = false;
                        boolean west = false;
                        for (BlockFace face : data.getFaces()) {
                            switch (face) {
                                case NORTH:
                                    north = true;
                                    break;
                                case SOUTH:
                                    south = true;
                                    break;
                                case WEST:
                                    west = true;
                                    break;
                                case EAST:
                                    east = true;
                                    break;
                            }
                        }

                        //structure.register(new MultipleFacingBlockElement(x,y,z,ma,));
                        System.out.println(String.format("structure.register(new MultipleFacingBlockElement(%d,%d,%d,Material."+block.getType().name()
                                +","+north+","+south+","+west+","+east+"));",dx,dy,dz));
                    } else
                        System.out.println("structure.register(new SolidBlockElement(" + dx + "," + dy + "," + dz + ",Material." + block.getType().name().toUpperCase() + "));");
                }
            }
        }
       // ParticleManager.playParticle(new Location(player.getWorld(),-51,7 ,-42),new Vector(1,0,0),
         //       6,0.5, Particle.SNOWBALL);
        //player.getWorld().spawnParticle(Particle.EXPLOSION_HUGE, player.getLocation(),1);
        /*if (arg.length == 2) {
            int level = Integer.parseInt(arg[1]);
            TowerStructure st = TowerStructureBank.getStructure(level,arg[0]);
            if (st == null) {
                player.sendMessage("不存在的Tower!");
                return;
            }
            TowerSlot slot = PlayerDataManager.getPlayerData(player).getSlot();
            if (slot == null) {
                player.sendMessage("請選擇Slot!");
                return;
            }
            slot.buildTower(new ArcherTower());
        }
        if (arg.length != 6) return;
        int mx = Integer.parseInt(arg[0]);
        int my = Integer.parseInt(arg[1]);
        int mz = Integer.parseInt(arg[2]);
        int ax = Integer.parseInt(arg[3]);
        int ay = Integer.parseInt(arg[4]);
        int az = Integer.parseInt(arg[5]);
        int middlex = (mx + ax) / 2;
        int middley = 3;
        int middlez = (mz + az) / 2;
        World w = player.getLocation().getWorld();
        for (int x = Math.min(mx, ax); x <= Math.max(mx, ax); x++) {
            for (int y = Math.min(my, ay); y <= Math.max(my, ay); y++) {
                for (int z = Math.min(mz, az); z <= Math.max(mz, az); z++) {
                    Block block = w.getBlockAt(x, y, z);
                    if (block.getType().equals(Material.AIR)) continue;
                    int dx = x - middlex;
                    int dz = z - middlez;
                    int dy = y - middley;
                    if (block.getBlockData() instanceof Stairs) {
                        System.out.println("structure.register(new StairsBlockElement(" + dx + "," + dy + "," + dz + "," +
                                "Material." + block.getType().name().toUpperCase() + ",BlockFace." + ((Directional)
                                block.getBlockData()).getFacing().name().toUpperCase() + ",Bisected.Half." +
                                ((Stairs) block.getBlockData()).getHalf().name().toUpperCase() + ",Stairs.Shape."
                                + ((Stairs) block.getBlockData()).getShape().name().toUpperCase() + "));");
                    } else if (block.getBlockData() instanceof Directional) {
                        System.out.println("structure.register(new DirectionalBlockElement(" + dx + "," + dy + "," + dz + ",Material." + block.getType().name().toUpperCase() + ",BlockFace." + ((Directional) block.getBlockData()).getFacing().name().toUpperCase() + "));");
                    } else if (block.getBlockData() instanceof MultipleFacing) {
                        MultipleFacing data = ((MultipleFacing) block.getBlockData());
                        boolean north = false;
                        boolean south = false;
                        boolean east = false;
                        boolean west = false;
                        for (BlockFace face : data.getFaces()) {
                            switch (face) {
                                case NORTH:
                                    north = true;
                                    break;
                                case SOUTH:
                                    south = true;
                                    break;
                                case WEST:
                                    west = true;
                                    break;
                                case EAST:
                                    east = true;
                                    break;
                            }
                        }

                        //structure.register(new MultipleFacingBlockElement(x,y,z,ma,));
                        System.out.println(String.format("structure.register(new MultipleFacingBlockElement(%d,%d,%d,Material."+block.getType().name()
                                +","+north+","+south+","+west+","+east+"));",dx,dy,dz));
                    } else
                        System.out.println("structure.register(new SolidBlockElement(" + dx + "," + dy + "," + dz + ",Material." + block.getType().name().toUpperCase() + "));");
                }
            }
        }*/
    }
}