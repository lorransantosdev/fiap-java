package org.example.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {

    @Test
    void testShouldConstructorWhenThereIsParams() {
        Team team = buildTeam();

        assertEquals("São Paulo", team.getName());
        assertEquals("São Paulo", team.getCity());
        assertNotNull(team.getPlayers());
        assertEquals(0, team.getScore());
    }

    @Test
    void testEmptyConstructor() {
        Team team = new Team();
        team.addPlayer(buildPlayer());
        team.setScore(0);

        assertNotNull(team.getPlayers());
        assertEquals(0, team.getScore());
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