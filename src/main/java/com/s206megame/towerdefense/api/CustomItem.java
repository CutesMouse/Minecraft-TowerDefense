package com.s206megame.towerdefense.api;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class CustomItem extends ItemStack {
    public CustomItem(Material m) {
        super(m);
    }
    public CustomItem setName(String name) {
        ItemMeta meta = getItemMeta();
        meta.setDisplayName(name);
        setItemMeta(meta);
        return this;
    }
    public CustomItem setLore(List<String> lore) {
        ItemMeta meta = getItemMeta();
        meta.setLore(new ArrayList<>(lore));
        setItemMeta(meta);
        return this;
    }
    public CustomItem enchanted() {
        ItemMeta meta = getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,0,true);
        setItemMeta(meta);
        return this;
    }
}
