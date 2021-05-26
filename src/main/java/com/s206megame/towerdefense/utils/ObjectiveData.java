package com.s206megame.towerdefense.utils;

import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Objective;

import java.util.ArrayList;

public class ObjectiveData {
    private ArrayList<ScoreData> SCORES;
    private Objective obj;
    private Player p;
    public ObjectiveData(Objective obj, Player p) {
        SCORES = new ArrayList<>();
        this.obj = obj;
        this.p = p;
    }
    public void update() {
        for (ScoreData data : SCORES) {
            data.update();
        }
    }

    public void addScoreData(ScoreData data) {
        data.activate(this);
        SCORES.add(data);
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
