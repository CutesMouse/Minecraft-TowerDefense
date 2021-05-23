package com.s206megame.towerdefense.api;

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
}
