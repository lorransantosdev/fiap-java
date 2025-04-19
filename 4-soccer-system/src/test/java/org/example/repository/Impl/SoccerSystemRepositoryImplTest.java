package org.example.repository.Impl;

import org.example.model.Game;
import org.example.model.Player;
import org.example.model.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class SoccerSystemRepositoryImplTest {

    @Spy
    private SoccerSystemRepositoryImpl repository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveTeamAndGetTeams() {
        Team team = buildTeam();
        repository.save(team);

        assertEquals(1, repository.getTeams().size());
        assertEquals(team, repository.getTeams().get(0));
    }

    @Test
    void testSaveGameAndGetGames() {
        repository.save(buildGame());

        assertEquals(1, repository.getGames().size());
    }

    @Test
    void testFindTeamByNameWhenExists() {
        Team team = buildTeam();
        repository.save(team);

        Team foundTeam = repository.findTeamByName("São Paulo");

        assertNotNull(foundTeam);
        assertEquals("São Paulo", foundTeam.getName());
    }

    @Test
    void testFindTeamByNameWhenDoesNotExist() {
        Team team = buildTeam();
        repository.save(team);

        Team foundTeam = repository.findTeamByName("Corinthians");

        assertNull(foundTeam);
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