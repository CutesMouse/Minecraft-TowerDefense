package com.s206megame.towerdefense.mobs;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;

public class ArmoredZombieMob extends CraftMob {
    private Zombie armoredzombie;
    private static final double MAX_HEALTH = 300.0;

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
    public double getTickPerBlock() {
        return 0.1;
    }

    @Override
    public double getMaxHealth() {
        return MAX_HEALTH;
    }

    @Override
    public double getHealth() {
        return health;
    }
}