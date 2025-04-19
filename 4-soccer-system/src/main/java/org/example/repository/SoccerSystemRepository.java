package org.example.repository;

import org.example.model.Game;
import org.example.model.Team;

import java.util.List;

public interface SoccerSystemRepository {
    void save(Team team);

    List<Team> getTeams();

    void save(Game game);

    List<Game> getGames();

    Team findTeamByName(String name);
}
