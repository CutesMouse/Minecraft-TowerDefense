package com.s206megame.towerdefense.items;

import com.s206megame.towerdefense.api.CustomItem;
import org.bukkit.Material;

public class Items {
    public static CustomItem BUILD_ITEM() {
        return new CustomItem(Material.ARMOR_STAND).setLore();
    }
}
