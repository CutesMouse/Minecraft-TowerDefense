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
        Wave wave2 = new Wave();
        wave2.addMob(ZombieMob.class, 5);
        wave2.addMob(SkeletonMob.class, 5);
        wave2.addMob(SpiderMob.class, 10);
        wave2.addMob(VindicatorMob.class, 10);
        wave2.addMob(SlimeMob.class, 5);
        Wave wave3 = new Wave();
        wave3.addMob(ZombieMob.class, 3);
        wave3.addMob(SkeletonMob.class, 3);
        wave3.addMob(SpiderMob.class, 5);
        wave3.addMob(VindicatorMob.class, 5);
        wavelist.add(wave1);
        wavelist.add(wave2);
    }
    public Wave getWave(int value)
    {
        return wavelist.get(value-1);
    }



}
