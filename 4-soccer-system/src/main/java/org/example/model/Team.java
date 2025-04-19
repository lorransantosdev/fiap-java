package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private String city;
    private int score;
    private List<Player> players;

    public Team() {
        this.players = new ArrayList<>();
        this.score = 0;
    }

    public Team(String name, String city) {
        this.name = name;
        this.city = city;
        this.players = new ArrayList<>();
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getScore() {
        return score;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }
}
