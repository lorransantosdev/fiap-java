package org.example.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void testShouldConstructorWhenThereIsParam() {
        Player player = buildPlayer();

        assertEquals("Lorran", player.getName());
        assertEquals(19, player.getYears());
        assertEquals("Atacante", player.getPosition());
        assertEquals(5, player.getNumberShirt());
        assertEquals(0, player.getNumberGoals());
    }

    @Test
    void testEmptyConstructor() {
        Player player = new Player();
        assertEquals(null, player.getName());
        assertEquals(0, player.getYears());
        assertEquals(null, player.getPosition());
        assertEquals(0, player.getNumberShirt());
        assertEquals(0, player.getNumberGoals());
    }

    public Player buildPlayer() {
        return new Player("Lorran", 19, "Atacante", 5);
    }

}