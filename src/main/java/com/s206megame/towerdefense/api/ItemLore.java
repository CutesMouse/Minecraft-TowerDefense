package com.s206megame.towerdefense.api;

import java.util.ArrayList;

public class ItemLore {
    private ArrayList<String> lore;
    private ArrayList<String> leftClick;
    private ArrayList<String> rightClick;
    private String left_description = "§e左鍵效果:";
    private String right_description = "§e右鍵效果";
    public ItemLore() {

    }
    public ItemLore setLore(ArrayList<String> lore) {
        this.lore = lore;
        return this;
    }
    public void setRightClickAbility(ArrayList<String> lore) {
        this.rightClick = lore;
    }
    public void setLeftClickAbility(ArrayList<String> lore) {
        this.leftClick = lore;
    }
    public ArrayList<String> build() {
        ArrayList<String> result = new ArrayList<>();
        result.addAll(lore);
        if (leftClick != null) {
            result.add(left_description);
            result.addAll(leftClick);
        }
        if (rightClick != null) {
            result.add(right_description);
            result.addAll(rightClick);
        }
        return result;
    }
}
