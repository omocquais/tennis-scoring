package com.om.tennis;

public class Player {

    private final char name;
    private Point score = Point.ZERO;

    public Player(char name) {
        this.name = name;
    }

    public char getName() {
        return name;
    }

    public String getDisplayName() {
        return "Player " + this.name;
    }

    public Point getScore() {
        return score;
    }

    @Override
    public String toString() {
        return getDisplayName() + " : " + score.getLabel();
    }

    public void wins() {
        this.score = this.score.nextScore();
    }

    public void deuce() {
        this.score = Point.DEUCE;
    }
}
