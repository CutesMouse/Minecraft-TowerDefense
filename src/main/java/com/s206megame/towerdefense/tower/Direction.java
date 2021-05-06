package com.s206megame.towerdefense.tower;

public enum Direction {
    NORTH(Math.PI),SOUTH(0),EAST(- Math.PI / 2),WEST(Math.PI / 2);
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
