package com.om.tennis;

public enum Point {

    ZERO("0"), FIFTEEN("15"), THIRTY("30"), FORTY("40"), DEUCE("DEUCE"), ADVANTAGE("ADVANTAGE"), WINNER("WINNER");

    private final String label;

    public String getLabel() {
        return label;
    }

    Point(String label) {
        this.label = label;
    }

    Point nextScore() {
        return switch (this.label) {
            case "0" -> Point.FIFTEEN;
            case "15" -> Point.THIRTY;
            case "30" -> Point.FORTY;
            case "40", "ADVANTAGE" -> Point.WINNER;
            case "DEUCE" -> Point.ADVANTAGE;
            default -> throw new RuntimeException("Invalid score");
        };
    }
}
