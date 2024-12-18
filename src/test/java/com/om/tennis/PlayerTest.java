package com.om.tennis;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class PlayerTest {

    @DisplayName("Given a new player with a new name A, the score must be null and the full name must be Player A an " +
            "the toString must return the the fullname and the core")
    @Test
    void score() {
        Player player = new Player('A');
        assertEquals("0", player.getScore().getLabel());
        assertEquals('A', player.getName());
        assertEquals("Player A", player.getDisplayName());
        assertEquals("Player A : 0", player.toString());
    }

    @DisplayName("Given a player, when the player wins the first point then the score is updated to 15")
    @Test
    void winFirstPoint() {
        Player player = new Player('A');
        player.wins();
        assertEquals(Point.FIFTEEN, player.getScore());
    }

    @DisplayName("Given a player, when the player wins the second point then the score is updated to 30")
    @Test
    void winSecondPoint() {
        Player player = new Player('A');
        player.wins();
        player.wins();
        assertEquals(Point.THIRTY, player.getScore());
    }

    @DisplayName("Given a player, when the player wins the third point then the score is updated to 40")
    @Test
    void winThirdPoint() {
        Player player = new Player('A');
        player.wins();
        player.wins();
        player.wins();
        assertEquals(Point.FORTY, player.getScore());
    }

    @DisplayName("Given a player, when the player wins the fourth point then the score is updated to 40")
    @Test
    void winFourthPoint() {
        Player player = new Player('A');
        player.wins();
        player.wins();
        player.wins();
        player.wins();
        assertEquals(Point.WINNER, player.getScore());
    }

    @DisplayName("Given a player, when the player wins the fourth point then the score is updated to 40")
    @Test
    void isDeuce() {
        Player player = new Player('A');
        player.deuce();
        assertEquals(Point.DEUCE, player.getScore());
    }

}