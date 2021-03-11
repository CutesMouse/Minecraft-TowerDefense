package com.s206megame.towerdefense.api;

import org.bukkit.entity.Player;

import java.util.function.Function;

public class ScoreData {
    private String name;
    private int score;
    private ObjectiveData od;
    private Function<Player,String> upd;
    public ScoreData(int score,String displayName) {
        this(score);
        this.name = displayName;
    }
    public void activate(ObjectiveData od) {
        this.od = od;
    }
    public ScoreData(int score) {
        this.score = score;
    }

    public ScoreData setUpd(Function<Player, String> upd) {
        this.upd = upd;
        return this;
    }

    public void update() {
        if (od == null) return;
        String lastName = name;
        name = upd.apply(od.getPlayer());
        od.updateScore(lastName,name,score);
    }
}
