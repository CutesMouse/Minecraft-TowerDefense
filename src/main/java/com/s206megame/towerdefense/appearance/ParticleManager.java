package com.s206megame.towerdefense.appearance;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.util.Vector;

public class ParticleManager {
    public static void playParticle(Location standardLoc, Vector eyeLoc, double blocks, double distance, Particle part) {
        Vector vec = eyeLoc;
        for (double i = distance; i <= blocks; i+= distance) {
            Location nl = standardLoc.clone().add(vec.normalize().multiply(i));
            standardLoc.getWorld().spawnParticle(part, nl,1,0,0,0,0,null,true);
        }
    }
    public static void playParticle(Location standardLoc, Vector eyeLoc, double blocks, double distance, Particle part, Object obj) {
        Vector vec = eyeLoc;
        for (double i = distance; i <= blocks; i+= distance) {
            Location nl = standardLoc.clone().add(vec.normalize().multiply(i));
            standardLoc.getWorld().spawnParticle(part, nl,1,0,0,0,0,obj,true);
        }
    }
}
