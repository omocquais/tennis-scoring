package com.om.tennis;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PointTest {

    @DisplayName("Given an enum with a specified label, When the getLabel method is called, Then the label is returned")
    @Test
    void getLabel() {
        assertEquals("0", Point.ZERO.getLabel());
        assertEquals("15", Point.FIFTEEN.getLabel());
        assertEquals("30", Point.THIRTY.getLabel());
        assertEquals("40", Point.FORTY.getLabel());
        assertEquals("DEUCE", Point.DEUCE.getLabel());
        assertEquals("ADVANTAGE", Point.ADVANTAGE.getLabel());
        assertEquals("WINNER", Point.WINNER.getLabel());
    }

    @DisplayName("Given a score, When the nextScore method is called, it returns the next score based of tennis rules")
    @Test
    void nextScore() {
        assertEquals(Point.FIFTEEN, Point.ZERO.nextScore());
        assertEquals(Point.THIRTY, Point.FIFTEEN.nextScore());
        assertEquals(Point.FORTY, Point.THIRTY.nextScore());
        assertEquals(Point.WINNER, Point.FORTY.nextScore());
        assertEquals(Point.WINNER, Point.ADVANTAGE.nextScore());
        assertEquals(Point.ADVANTAGE, Point.DEUCE.nextScore());
    }

}