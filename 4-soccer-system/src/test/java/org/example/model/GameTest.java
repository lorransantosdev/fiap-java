package org.example.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void TestShouldConstructorWhenThereIsParams() {
        Game game = buildGame();

        assertNotNull(game.getHomeTeam());
        assertNotNull(game.getVisitorTeam());
        assertEquals(0, game.getHomeGoals());
        assertEquals(0, game.getVisitorGoals());
    }

    @Test
    void testEmptyConstructor() {
        Game game = new Game();
        assertNull(game.getHomeTeam());
        assertNull(game.getVisitorTeam());
        assertEquals(0, game.getHomeGoals());
        assertEquals(0, game.getVisitorGoals());
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