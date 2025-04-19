package org.example.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChampionTest {

    @Test
    void testInstance() {
        Champion champion = new Champion();
        champion.addGame(buildGame());

        assertNotNull(champion.getGames());
    }

    public Game buildGame() {
        return new Game(buildTeam(), buildTeam(), 0, 0);
    }

    public Team buildTeam() {
        Team team = new Team("São Paulo", "São Paulo");
        team.addPlayer(buildPlayer());
        team.setScore(0);
        return team;
    }

    public Player buildPlayer() {
        return new Player("Lorran", 19, "Atacante", 5);
    }

}