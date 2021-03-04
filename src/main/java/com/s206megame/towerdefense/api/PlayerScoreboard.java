package com.s206megame.towerdefense.api;

import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;

public class PlayerScoreboard {
    private Scoreboard sb;
    private ObjectiveData od;
    private Player p;
    public PlayerScoreboard(Scoreboard sb, Player p) {
        this.sb = sb;
        this.p = p;
    }

    public Player getOwner() {
        return p;
    }

    public Scoreboard getScoreboard() {
        return sb;
    }

    public void setObjectiveData(ObjectiveData od) {
        this.od = od;
    }

    public void update() {
        od.update();
    }



}
