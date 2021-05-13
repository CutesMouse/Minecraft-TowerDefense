package com.s206megame.towerdefense.mobs;

import java.util.ArrayList;


public class WaveMobList {

    ArrayList<Wave> wavelist = new ArrayList<>();
    public WaveMobList()
    {

        Wave wave1 = new Wave();
        wave1.addMob(ZombieMob.class, 10);
        wave1.addMob(SkeletonMob.class, 10);
        wave1.addMob(SpiderMob.class, 10);
        wavelist.add(wave1);
    }
    public Wave getWave(int value)
    {
        return wavelist.get(value-1);
    }



}
