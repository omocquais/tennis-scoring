package com.om.tennis;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MatchTest {


    @DisplayName("Happy Path - Display scores from input")
    @Nested
    class ScoreTest {
        @DisplayName("Given a new match with 2 players A and B, when input is empty, the output is empty")
        @Test
        void getInitialScore() {

            var playerA = new Player('A');
            var playerB = new Player('B');

            var match = new Match(playerA, playerB);

            assertEquals(0, match.play("").size());
        }

        @DisplayName("Given a new match with 2 players A and B, when input is A and the scores are Player A : 15 / Player" +
                " B : 0")
        @Test
        void getScoreAfterOnePoint() {

            var playerA = new Player('A');
            var playerB = new Player('B');

            var match = new Match(playerA, playerB);

            List<String> scores = match.play("A");

            assertEquals(1, scores.size());
            assertEquals("Player A : 15 / Player B : 0", scores.getFirst());
        }


        @DisplayName("Given a new match with 2 players A and B, when input is AB and the scores are Player A : 15 / " +
                "Player B : 15")
        @Test
        void getScoreAfterTwoPoints() {

            var playerA = new Player('A');
            var playerB = new Player('B');

            var match = new Match(playerA, playerB);

            List<String> scores = match.play("AB");

            assertEquals(2, scores.size());
            assertEquals("Player A : 15 / Player B : 0", scores.getFirst());
            assertEquals("Player A : 15 / Player B : 15", scores.getLast());
        }

        @DisplayName("Given a new match with 2 players A and B, when input is ABAB and the scores are Player A : 30 / " +
                "Player B : 30")
        @Test
        void getScoreAfterFourPoints() {

            var playerA = new Player('A');
            var playerB = new Player('B');

            var match = new Match(playerA, playerB);

            List<String> scores = match.play("ABAB");

            assertEquals(4, scores.size());
            assertEquals("Player A : 15 / Player B : 0", scores.getFirst());
            assertEquals("Player A : 15 / Player B : 15", scores.get(1));
            assertEquals("Player A : 30 / Player B : 15", scores.get(2));
            assertEquals("Player A : 30 / Player B : 30", scores.getLast());
        }

        @DisplayName("Given a new match with 2 players A and B, when input is ABABA and the scores are Player A : 40 / " +
                "Player B : 30")
        @Test
        void getScoreAfterFivePoints() {

            var playerA = new Player('A');
            var playerB = new Player('B');

            var match = new Match(playerA, playerB);

            List<String> scores = match.play("ABABA");

            assertEquals(5, scores.size());

            assertEquals("Player A : 15 / Player B : 0", scores.getFirst());
            assertEquals("Player A : 15 / Player B : 15", scores.get(1));
            assertEquals("Player A : 30 / Player B : 15", scores.get(2));
            assertEquals("Player A : 30 / Player B : 30", scores.get(3));
            assertEquals("Player A : 40 / Player B : 30", scores.getLast());
        }

        @DisplayName("Given a new match with 2 players A and B, when input is ABABAA the scores are Player A wins the game")
        @Test
        void getScoreAfterSixPoints() {

            var playerA = new Player('A');
            var playerB = new Player('B');

            var match = new Match(playerA, playerB);

            List<String> scores = match.play("ABABAA");

            assertEquals(6, scores.size());

            assertEquals("Player A : 15 / Player B : 0", scores.getFirst());
            assertEquals("Player A : 15 / Player B : 15", scores.get(1));
            assertEquals("Player A : 30 / Player B : 15", scores.get(2));
            assertEquals("Player A : 30 / Player B : 30", scores.get(3));
            assertEquals("Player A : 40 / Player B : 30", scores.get(4));
            assertEquals("Player A wins the game", scores.getLast());

        }

        @DisplayName("Given a new match with 2 players A and B, when input is BABABB the scores are Player B wins the game")
        @Test
        void getScoreAfterSixPointsBWinner() {

            var playerA = new Player('A');
            var playerB = new Player('B');

            var match = new Match(playerA, playerB);

            String input = "BABABB";
            List<String> scores = match.play(input);

            assertEquals(input.length(), scores.size());

            assertEquals("Player A : 0 / Player B : 15", scores.getFirst());
            assertEquals("Player A : 15 / Player B : 15", scores.get(1));
            assertEquals("Player A : 15 / Player B : 30", scores.get(2));
            assertEquals("Player A : 30 / Player B : 30", scores.get(3));
            assertEquals("Player A : 30 / Player B : 40", scores.get(4));
            assertEquals("Player B wins the game", scores.getLast());
        }

        @DisplayName("Given a new match with 2 players A and B, when input is ABABAB the scores are Players are deuce")
        @Test
        void getScoreAfterDeuceP1Starts() {

            var playerA = new Player('A');
            var playerB = new Player('B');

            var match = new Match(playerA, playerB);

            String input = "ABABAB";

            List<String> scores = match.play(input);

            assertEquals(input.length(), scores.size());
            assertEquals("Player A : 15 / Player B : 0", scores.getFirst());
            assertEquals("Player A : 15 / Player B : 15", scores.get(1));
            assertEquals("Player A : 30 / Player B : 15", scores.get(2));
            assertEquals("Player A : 30 / Player B : 30", scores.get(3));
            assertEquals("Player A : 40 / Player B : 30", scores.get(4));
            assertEquals("Players are deuce", scores.getLast());

        }


        @DisplayName("Given a new match with 2 players A and B, when input is BABABA the scores are Players are " +
                "deuce")
        @Test
        void getScoreAfterDeuceP2Starts() {

            var playerA = new Player('A');
            var playerB = new Player('B');

            var match = new Match(playerA, playerB);

            String input = "BABABA";

            List<String> scores = match.play(input);

            assertEquals(input.length(), scores.size());
            assertEquals("Player A : 0 / Player B : 15", scores.getFirst());
            assertEquals("Player A : 15 / Player B : 15", scores.get(1));
            assertEquals("Player A : 15 / Player B : 30", scores.get(2));
            assertEquals("Player A : 30 / Player B : 30", scores.get(3));
            assertEquals("Player A : 30 / Player B : 40", scores.get(4));
            assertEquals("Players are deuce", scores.getLast());

        }


        @DisplayName("Given a new match with 2 players A and B, when input is BABABAA the score is Player A has " +
                "advantage")
        @Test
        void advantagePlayerA() {

            var playerA = new Player('A');
            var playerB = new Player('B');

            var match = new Match(playerA, playerB);

            String input = "BABABAA";

            List<String> scores = match.play(input);

            assertEquals(input.length(), scores.size());
            assertEquals("Player A : 0 / Player B : 15", scores.getFirst());
            assertEquals("Player A : 15 / Player B : 15", scores.get(1));
            assertEquals("Player A : 15 / Player B : 30", scores.get(2));
            assertEquals("Player A : 30 / Player B : 30", scores.get(3));
            assertEquals("Player A : 30 / Player B : 40", scores.get(4));
            assertEquals("Players are deuce", scores.get(5));
            assertEquals("Player A has advantage", scores.getLast());

        }

        @DisplayName("Given a new match with 2 players A and B, when input is BABABAB the score is Player B has " +
                "advantage")
        @Test
        void advantagePlayerB() {

            var playerA = new Player('A');
            var playerB = new Player('B');

            var match = new Match(playerA, playerB);

            String input = "BABABAB";

            List<String> scores = match.play(input);

            assertEquals(input.length(), scores.size());
            assertEquals("Player A : 0 / Player B : 15", scores.getFirst());
            assertEquals("Player A : 15 / Player B : 15", scores.get(1));
            assertEquals("Player A : 15 / Player B : 30", scores.get(2));
            assertEquals("Player A : 30 / Player B : 30", scores.get(3));
            assertEquals("Player A : 30 / Player B : 40", scores.get(4));
            assertEquals("Players are deuce", scores.get(5));
            assertEquals("Player B has advantage", scores.getLast());

        }

        @DisplayName("Given a new match with 2 players A and B, when input is BABABABB the score is Player B wins the game")
        @Test
        void PlayerBWinsAfterAdvantage() {

            var playerA = new Player('A');
            var playerB = new Player('B');

            var match = new Match(playerA, playerB);

            String input = "BABABABB";

            List<String> scores = match.play(input);

            assertEquals(input.length(), scores.size());
            assertEquals("Player A : 0 / Player B : 15", scores.getFirst());
            assertEquals("Player A : 15 / Player B : 15", scores.get(1));
            assertEquals("Player A : 15 / Player B : 30", scores.get(2));
            assertEquals("Player A : 30 / Player B : 30", scores.get(3));
            assertEquals("Player A : 30 / Player B : 40", scores.get(4));
            assertEquals("Players are deuce", scores.get(5));
            assertEquals("Player B has advantage", scores.get(6));
            assertEquals("Player B wins the game", scores.getLast());

        }

        @DisplayName("Given a new match with 2 players A and B, when input is BABABAAA the score is Player A wins the game")
        @Test
        void PlayerAWinsAfterAdvantage() {

            var playerA = new Player('A');
            var playerB = new Player('B');

            var match = new Match(playerA, playerB);

            String input = "BABABAAA";

            List<String> scores = match.play(input);

            assertEquals(input.length(), scores.size());
            assertEquals("Player A : 0 / Player B : 15", scores.getFirst());
            assertEquals("Player A : 15 / Player B : 15", scores.get(1));
            assertEquals("Player A : 15 / Player B : 30", scores.get(2));
            assertEquals("Player A : 30 / Player B : 30", scores.get(3));
            assertEquals("Player A : 30 / Player B : 40", scores.get(4));
            assertEquals("Players are deuce", scores.get(5));
            assertEquals("Player A has advantage", scores.get(6));
            assertEquals("Player A wins the game", scores.getLast());

        }
    }


    @DisplayName("Unhappy path - Different uses cases with bad inputs")
    @Nested
    class InputsTest {
        @DisplayName("Given a new match with 2 players A and B, when input is CDCC then an IllegalArgumentException is thrown")
        @Test
        void BadInputs() {

            var playerA = new Player('A');
            var playerB = new Player('B');

            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Match(playerA, playerB).play("CDCDC"));
            assertEquals("Invalid player name: C", exception.getMessage());

        }

        @DisplayName("Given a new match with 2 players A and B, when input is A B A B then an IllegalArgumentException is thrown")
        @Test
        void IllegalInputsWithSpace() {

            var playerA = new Player('A');
            var playerB = new Player('B');

            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Match(playerA,
                    playerB).play("A B A B"));
            assertEquals("Invalid player name:  ", exception.getMessage());

        }

        @DisplayName("Given a new match with 2 players A and B, when input is null then an IllegalArgumentException is " +
                "thrown")
        @Test
        void IllegalInputsWithNullValue() {

            var playerA = new Player('A');
            var playerB = new Player('B');

            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Match(playerA, playerB).play(null));
            assertEquals("Input is required", exception.getMessage());
        }
    }



    @DisplayName("Utility methods")
    @Nested
    class UsefulTest {
        
        @DisplayName("Given a character sent as parameter, it should return the expected player matching with the " +
                "name sent as parameter")
        @Test
        void getPlayerByName() {
            var playerA = new Player('A');
            var playerB = new Player('B');
            Match match = new Match(playerA, playerB);

            assertEquals(playerA, match.getPlayerByName('A'));
            assertEquals(playerB, match.getPlayerByName('B'));
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> match.getPlayerByName('W'));
            assertEquals("Invalid player name: W", exception.getMessage());
        }

        @DisplayName("Given two players, it should set the score to deuce for the both players")
        @Test
        void setScoresToDeuce() {
            var playerA = new Player('A');
            var playerB = new Player('B');
            new Match(playerA, playerB).setScoresToDeuce();
            assertEquals(Point.DEUCE.getLabel(), playerA.getScore().getLabel());
        }

        @DisplayName("Given a wrong player name sent as parameter, it should throw an exception")
        @Test
        void getOpponentPlayer() {
            var playerA = new Player('A');
            var playerB = new Player('B');
            Match match = new Match(playerA, playerB);
            assertEquals(playerB, match.getOpponentPlayer('A'));
            assertEquals(playerA, match.getOpponentPlayer('B'));
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> match.getOpponentPlayer('W'));
            assertEquals("Invalid player name: W", exception.getMessage());
        }
    }


}