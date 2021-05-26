package com.s206megame.towerdefense.utils;

import org.bukkit.Location;

public class MathTool {
    public static String round(double num, int precision) {
        String offset_s = "1";
        for (int i = 0 ; i < precision; i++) offset_s += "0";
        double offset = Double.parseDouble(offset_s);
        return Double.toString(Math.round(num * offset) / offset);
    }
    public static String rome(int num) {
        switch (num) {
            case 1:
                return "I";
            case 2:
                return "II";
            case 3:
                return "III";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 6:
                return "VI";
            case 7:
                return "VII";
            case 8:
                return "VIII";
            case 9:
                return "IX";
            case 10:
                return "X";
        }
        return "";
    }
    public static String toPercentage(double ratio) {
        return round(ratio * 100,0)+"%";
    }
    public static double locationToDegree(Location from, Location to) {
        double[] loc1 = {from.getX(),from.getZ()};
        double[] loc2 = {to.getX(),to.getZ()};
        int[] posZ = {0,1};

        double dot = 0;
        double sq = 0;

        for (int i = 0; i < 2; i++) {
            double vc = loc2[i] - loc1[i];
            sq += vc*vc;
            dot += vc * posZ[i];
        }
        double cos = dot / Math.sqrt(sq);
        double dx = loc2[0] - loc1[0];
        double angle = -Math.acos(cos);
        double deg = (angle * 180) / Math.PI;
        if (dx * Math.cos(angle + Math.PI * 0.5) > 0) return (deg);
        return -deg;
    }
}
