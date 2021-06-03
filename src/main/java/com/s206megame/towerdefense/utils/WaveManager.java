package com.s206megame.towerdefense.utils;

import com.s206megame.towerdefense.mobs.*;


public class WaveManager {
    public static Wave getWaveData(int w) {
        int strengthen = (w-1) / 10;
        int baseWave = (w-1) % 10;
        return getBaseWaveData(baseWave,w).strengthen(strengthen);
    }
    private static Wave getBaseWaveData(int base, int total) { // 0 <= w <= 9
        Wave wave = new Wave(total);
        switch (base) {
            case 0:
            {
                wave.append(ZombieMob.class, 10);
                wave.append(SkeletonMob.class, 10);
                wave.append(SpiderMob.class, 5);
                wave.append(VindicatorMob.class, 5);
                return wave;
            }
            case 1:
            {
                wave.append(ZombieMob.class, 5);
                wave.append(SkeletonMob.class, 5);
                wave.append(SpiderMob.class, 10);
                wave.append(VindicatorMob.class, 10);

                return wave;
            }
            case 2:
            {
                wave.append(SpiderMob.class, 5);
                wave.append(VindicatorMob.class, 10);
                wave.append(SlimeMob.class, 5);
                wave.append(BabyZombieMob.class, 5);
                wave.append(ChickenJockeyMob.class, 5);
                return wave;
            }
            case 3:
            {
                wave.append(SlimeMob.class, 20);
                wave.append(BabyZombieMob.class, 10);
                wave.append(ChickenJockeyMob.class, 10);

                return wave;
            }
            case 4:
            {
                wave.append(SlimeMob.class, 20);
                wave.append(BabyZombieMob.class, 10);
                wave.append(ChickenJockeyMob.class, 5);
                wave.append(GolemMob.class, 1);
                return wave;
            }
            case 5:
            {
                wave.append(ArmoredZombieMob.class, 10);
                wave.append(WitherSkeletonMob.class, 10);
                wave.append(StrayMob.class, 5);
                wave.append(RavagerMob.class, 5);

                return wave;
            }
            case 6:
            {
                wave.append(ArmoredZombieMob.class, 5);
                wave.append(WitherSkeletonMob.class, 5);
                wave.append(StrayMob.class, 10);
                wave.append(RavagerMob.class, 10);

                return wave;
            }
            case 7:
            {
                wave.append(ArmoredZombieMob.class, 2);
                wave.append(WitherSkeletonMob.class, 2);
                wave.append(StrayMob.class, 5);
                wave.append(RavagerMob.class, 10);
                wave.append(BlazeMob.class, 3);
                wave.append(EndermanMob.class, 3);
                wave.append(EndermiteMob.class, 2);
                wave.append(SilverfishMob.class, 2);
                return wave;
            }
            case 8:
            {
                wave.append(ArmoredZombieMob.class, 2);
                wave.append(WitherSkeletonMob.class, 2);
                wave.append(StrayMob.class, 2);
                wave.append(RavagerMob.class, 3);
                wave.append(BlazeMob.class, 3);
                wave.append(EndermanMob.class, 5);
                wave.append(EndermiteMob.class, 5);
                wave.append(SilverfishMob.class, 5);
                return wave;
            }
            case 9:
            {
                wave.append(SlimeMob.class, 5);
                wave.append(BabyZombieMob.class, 3);
                wave.append(ChickenJockeyMob.class, 3);
                wave.append(GolemMob.class, 2);
                wave.append(ArmoredZombieMob.class, 3);
                wave.append(WitherSkeletonMob.class, 3);
                wave.append(StrayMob.class, 3);
                wave.append(RavagerMob.class, 3);
                wave.append(BlazeMob.class, 3);
                wave.append(EndermanMob.class, 5);
                wave.append(EndermiteMob.class, 10);
                wave.append(SilverfishMob.class, 10);
                wave.append(WitherMob.class, 1);
                return wave;
            }
        }
        return wave;
    }
}
