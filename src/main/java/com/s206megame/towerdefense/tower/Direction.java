package com.s206megame.towerdefense.tower;

public enum Direction {
    NORTH(-Math.PI / 2),SOUTH(Math.PI / 2),EAST(0),WEST(Math.PI);
    private double rad;
    Direction(double rad) {
        this.rad = rad;
    }
    public double getDegree() {
        return (this.rad / Math.PI) * 180;
    }
    public double getRad() {
        return rad;
    }
}
