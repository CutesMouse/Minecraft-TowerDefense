package com.s206megame.towerdefense.api;

import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Objective;

import java.util.HashMap;

public class ObjectiveData {
    private HashMap<Integer,ScoreData> SCORES;
    private Objective obj;
    private Player p;
    public ObjectiveData(Objective obj, Player p) {
        SCORES = new HashMap<>();
        this.obj = obj;
    }
    public void update() {
        for (ScoreData data : SCORES.values()) {
            data.update();
        }
    }

    public Player getPlayer() {
        return p;
    }

    public void updateScore(String lastName, String newName, int score) {
        if (lastName == null) return;
        if (lastName.equals(newName)) return;
        obj.getScore(lastName).setScore(score);
    }
}
