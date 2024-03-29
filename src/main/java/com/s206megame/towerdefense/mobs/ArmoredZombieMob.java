package com.s206megame.towerdefense.mobs;

import com.s206megame.towerdefense.mobs.basic.CraftMob;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;

public class ArmoredZombieMob extends CraftMob {
    private static final double MAX_HEALTH = 900.0;
    private Zombie armoredzombie;

    @Override
    public Entity getEntity() {
        return armoredzombie;
    }

    @Override
    public String getMobName() {
        return "Armored Zombie";
    }

    @Override
    public String getMobID() {
        return "armoredzombie";
    }

    @Override
    public void spawn(Location loc) {
        currentLocation = loc;
        Zombie entity = loc.getWorld().spawn(loc, Zombie.class);
        entity.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
        entity.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
        entity.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
        entity.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
        this.armoredzombie = entity;
        entity.setAI(false);
        setFacingDegree(0);
    }

    @Override
    public double getBlockPerTick() {
        return 0.1 * strengthen_offset;
    }

    @Override
    public double getMaxHealth() {
        return MAX_HEALTH * strengthen_offset;
    }

    @Override
    public double getHealth() {
        return health;
    }
}
