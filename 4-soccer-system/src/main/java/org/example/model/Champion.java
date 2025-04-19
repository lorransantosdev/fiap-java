package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Champion {
    private List<Game> games = new ArrayList<>();

    public void addGame(Game game) {
        games.add(game);
    }

    public List<Game> getGames() {
        return games;
    }
}
