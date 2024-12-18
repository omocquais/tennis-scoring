package com.om.tennis;

import java.util.ArrayList;
import java.util.List;

public class Match {
    private final Player player1;
    private final Player player2;

    public Match(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }
    
    public Player getPlayerByName(char playerName) {
        if (player1.getName() == playerName) return player1;
        if (player2.getName() == playerName) return player2;
        throw new IllegalArgumentException("Invalid player name: " + playerName);
    }

    public Player getOpponentPlayer(char playerName) {
        if (player1.getName() == playerName) return player2;
        if (player2.getName() == playerName) return player1;
        throw new IllegalArgumentException("Invalid player name: " + playerName);
    }

    public void setScoresToDeuce() {
        player1.deuce();
        player2.deuce();
    }

    public List<String> play(String input) {

        if (input == null) {
            throw new IllegalArgumentException("Input is required");
        }

        List<String> output = new ArrayList<>();

        for (char playerName : input.toCharArray()) {

            Player currentPlayer = getPlayerByName(playerName);
            Player opponentPlayer = getOpponentPlayer(playerName);

            // Special case
            if (Point.FORTY == opponentPlayer.getScore()) {
                setScoresToDeuce();
                output.add("Players are deuce");
            } else {
                // Update the scores
                currentPlayer.wins();

                // Update the output
                switch (currentPlayer.getScore()) {
                    case Point.WINNER:
                        output.add(currentPlayer.getDisplayName() + " wins the game");
                        break;
                    case Point.ADVANTAGE:
                        output.add(currentPlayer.getDisplayName() + " has advantage");
                        break;
                    default:
                        output.add(player1 + " / " + player2);
                }

            }

        }

        //Print the output
        output.forEach(System.out::println);

        return output;
    }



}
