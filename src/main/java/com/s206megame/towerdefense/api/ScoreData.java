package com.s206megame.towerdefense.api;

import org.bukkit.entity.Player;

import java.util.function.BiConsumer;
import java.util.function.Function;

public class ScoreData {
    private String name;
    private int score;
    private ObjectiveData od;
    private Function<Player,String> upd;
    public ScoreData(String displayName, ObjectiveData od, int score) {
        this(od, score);
        this.name = displayName;
    }
    public ScoreData(ObjectiveData od, int score) {
        this.od = od;
        this.score = score;
    }

    public void setUpd(Function<Player, String> upd) {
        this.upd = upd;
    }

    public void update() {
        String lastName = name;
        String newName = upd.apply(od.getPlayer());
        od.updateScore(lastName,newName,score);
    }
}
