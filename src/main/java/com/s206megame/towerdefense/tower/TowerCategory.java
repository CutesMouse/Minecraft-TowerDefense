package com.s206megame.towerdefense.tower;

public enum TowerCategory {
    Range("§b"),Attack("§c"),Speed("§2");
    String colorCode;
    TowerCategory(String s) {
        colorCode = s;
    }
    public String getColorCode() {return colorCode;}

}
