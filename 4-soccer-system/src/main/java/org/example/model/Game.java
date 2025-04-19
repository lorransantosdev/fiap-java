package org.example.model;

public class Game {
    private Team homeTeam;
    private Team visitorTeam;
    private int homeGoals;
    private int visitorGoals;

    public Game() { }

    public Game(Team homeTeam, Team visitorTeam, int homeGoals, int visitorGoals) {
        this.homeTeam = homeTeam;
        this.visitorTeam = visitorTeam;
        this.homeGoals = homeGoals;
        this.visitorGoals = visitorGoals;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getVisitorTeam() {
        return visitorTeam;
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public int getVisitorGoals() {
        return visitorGoals;
    }
}
