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
        this.p = p;
    }
    public void update() {
        for (ScoreData data : SCORES.values()) {
            data.update();
        }
    }

    public void addScoreData(int score, ScoreData data) {
        data.activate(this);
        SCORES.put(score,data);
    }

    public Player getPlayer() {
        return p;
    }

    public void updateScore(String lastName, String newName, int score) {
        if (newName == null && lastName == null) {
            return;
        }
        if (newName == null) {
            obj.getScoreboard().resetScores(lastName);
            return;
        }
        if (lastName != null && lastName.equals(newName)) return;
        if (lastName != null) {
            obj.getScoreboard().resetScores(lastName);
        }
        obj.getScore(newName).setScore(score);
    }
}
