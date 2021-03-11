package com.s206megame.towerdefense.api;

public class MathTool {
    public static String round(double num, int precision) {
        String offset_s = "1";
        for (int i = 0 ; i < precision; i++) offset_s += "0";
        double offset = Double.parseDouble(offset_s);
        return Double.toString(Math.round(num * offset) / offset);
    }
}
