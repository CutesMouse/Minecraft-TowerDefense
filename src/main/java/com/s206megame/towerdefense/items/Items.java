package com.s206megame.towerdefense.items;

import com.s206megame.towerdefense.api.CustomItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Items {

    public static ItemStack BUILD_TOOL() {
        ItemStack todo = new ItemStack(Material.ARMOR_STAND);
        ItemMeta meta = todo.getItemMeta();
        assert meta != null;
        meta.setDisplayName("§a建塔工具");
        todo.setItemMeta(meta);
        return todo;
    }

}
