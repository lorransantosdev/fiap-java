package org.example.repository.Impl;

import org.example.model.Game;
import org.example.model.Team;
import org.example.repository.SoccerSystemRepository;

import java.util.ArrayList;
import java.util.List;

public class SoccerSystemRepositoryImpl implements SoccerSystemRepository {
    private List<Team> teams = new ArrayList<>();
    private List<Game> games = new ArrayList<>();

    @Override
    public void save(Team team) {
        teams.add(team);
    }


    @Override
    public List<Team> getTeams() {
        return teams;
    }


    @Override
    public void save(Game game) {
        games.add(game);
    }


    @Override
    public List<Game> getGames() {
        return games;
    }


    @Override
    public Team findTeamByName(String name) {
        return teams.stream()
                .filter(team -> team.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}
